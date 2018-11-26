package com.opentable.opentable.Network;

import android.util.Log;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Class to handle networking and HTTP requests
 */
public class OkHttpSingleton {

    // region Static Members
    private static OkHttpSingleton sInstance;
    private static String TAG = "OkHttpSingleton";
    // endregion

    // region Class Members
    private OkHttpClient mClient;
    // endregion

    // region Private Access

    /**
     * Singlton C'tor
     */
    private OkHttpSingleton() {
        mClient = new OkHttpClient.Builder()
                .retryOnConnectionFailure(true)
                .build();
    }

    private OkHttpClient getClient() {
        return mClient;
    }
    // endregion

    // region Public Access

    /**
     * Getting the instance of the singlton
     * @return new instance for the first time, existing instance otherwise
     */
    public static OkHttpSingleton getInstance() {
        if (sInstance == null) {
            sInstance = new OkHttpSingleton();
        }

        return sInstance;
    }

    /**
     * Function to execute GET request
     * @param url - endpoint to query
     * @param result - an interface to id the sender for the result
     */
    public void getJson(String url, final IResult result) {
        Request request = new Request.Builder()
                .url(url)
                .build();

        getClient().newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                Log.e(TAG, "GET request failed " + e.getMessage());
                result.getResult(e.getMessage(), false);
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                if (!response.isSuccessful()) {
                    result.getResult(response.body().string(), false);
                    throw new IOException("Unexpected code " + response);
                }

                result.getResult(response.body().string(), true);
            }
        });
    }
    // endregion

    // region Interfaces
    /**
     * Interface for getting results of HTTP requests
     */
    public interface IResult{
        void getResult(String result, boolean isRequestSucceeded);
    }
    // endregion
}

