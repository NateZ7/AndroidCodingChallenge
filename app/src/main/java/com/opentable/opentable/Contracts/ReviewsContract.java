package com.opentable.opentable.Contracts;

import org.json.JSONObject;

public interface ReviewsContract {

    interface IReviewsView {

        /**
         * Initializing the views
         */
        void initViews();

        /**
         * Displaying a custom toast message
         * @param message - message to toast
         */
        void makeToast(String message);

    }

    interface IReviewsPresenter {

        /**
         * Fetching reviews as JSON and notifying the UI
         */
        void fetchReviews();

        /**
         * Creating a review object resulted from a JSON object
         */
        void createReview(JSONObject reviewObject);
    }
}
