package com.opentable.opentable;

import okhttp3.OkHttpClient;

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

    // endregion
}

