package com.opentable.opentable;

import org.json.JSONObject;

public interface MoviesContract {

    interface IMoviesView {

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

    interface IMoviesPresenter {

        /**
         * Fetching movies as JSON and notifying the UI
         */
        void fetchMovies();

        /**
         * Creating a review object resulted from a JSON object
         */
        void createReview(JSONObject reviewObject);
    }
}
