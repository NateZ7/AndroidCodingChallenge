package com.opentable.opentable.Presenters;

import android.util.Log;

import com.opentable.opentable.BuildConfig;
import com.opentable.opentable.Network.OkHttpSingleton;
import com.opentable.opentable.Models.Review;
import com.opentable.opentable.Contracts.ReviewsContract;
import com.opentable.opentable.Helpers.Utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class ReviewsPresenter implements ReviewsContract.IReviewsPresenter {

    // region Static Members
    private static String TAG = "ReviewsPresenter";
    // endregion

    // region Class Members
    private ArrayList<Review> mReviews;
    private ReviewsContract.IReviewsView mReviewsView;
    // endregion

    // region Public Access
    public ReviewsPresenter(ReviewsContract.IReviewsView IReviewsView) {
        mReviewsView = IReviewsView;
        mReviews = new ArrayList<>();
    }

    @Override
    public void onFetchReviews() {
        OkHttpSingleton.getInstance().getJson(BuildConfig.SERVER_URL, new OkHttpSingleton.IResult() {
            @Override
            public void getResult(String result, boolean isRequestSucceeded) {
                if (!isRequestSucceeded) {
                    mReviewsView.onToast("Could not fetch movie reviews, please try again later");
                    Log.d(TAG, "Movie reviews didn't get fetched");
                    return;
                }

                try {
                    JSONObject jsonResult = new JSONObject(result);
                    JSONArray reviews = jsonResult.getJSONArray("results");
                    for (int i = 0; i < reviews.length(); i++) {
                        onCreateReview(reviews.getJSONObject(i));
                    }

                    mReviewsView.onGetReviewList(mReviews);
                } catch (JSONException e) {
                    Log.e(TAG, e.getMessage());
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void onCreateReview(JSONObject reviewObject) {
        List<String> formats = Arrays.asList("yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd");

        String title = reviewObject.optString("display_title");
        String rating = reviewObject.optString("mpaa_rating");
        String criticsPick = reviewObject.optString("critics_pick");
        String byLine = reviewObject.optString("byline");
        String headline = reviewObject.optString("headline");
        String summaryShort = reviewObject.optString("summary_short");
        Date publicationDate = Utils.stringToDateByMultipleFormats(reviewObject.optString("publication_date"), formats);
        Date openingDate = Utils.stringToDateByMultipleFormats(reviewObject.optString("opening_date"), formats);
        Date dateUpdated = Utils.stringToDateByMultipleFormats(reviewObject.optString("date_updated"), formats);
        JSONObject linkObject = reviewObject.optJSONObject("link");
        JSONObject mmObject = reviewObject.optJSONObject("multimedia");
        String linkType = linkObject.optString("type");
        String linkUrl = linkObject.optString("url");
        String mmType = mmObject.optString("type");
        String mmSrc = mmObject.optString("src");
        int width = mmObject.optInt("width", -1);
        int height = mmObject.optInt("height", -1);

        Review review = new Review(title, rating, headline, byLine, summaryShort, publicationDate,
                openingDate, dateUpdated, criticsPick, mmType, mmSrc, width, height, linkType, linkUrl);

        if (review != null) {
            mReviews.add(review);
        }
    }
    // endregion
}
