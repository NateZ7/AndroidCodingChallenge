package com.opentable.opentable.Contracts;

import com.opentable.opentable.Models.Review;

import org.json.JSONObject;

import java.util.Date;
import java.util.List;

public interface ReviewsContract {

    interface IReviewsView {

        /**
         * Displaying a custom toast message
         * @param message - message to toast
         */
        void makeToast(String message);

        /**
         * Getting notified to update reviews
         * @param reviews - new review list
         */
        void onGetReviewList(List<Review> reviews);
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

    interface IReview {

        String getTitle();

        String getMpaaRating();

        String getHeadline();

        String getByLine();

        String getSummaryShort();

        Date getPublicationDate();

        Date getOpeningDate();

        Date getDateUpdated();

        String getCriticsPick();

        String getReviewMultimediaType();

        String getReviewMultimediaSrc();

        int getReviewMultimediaWidth();

        int getReviewMultimediaHeight();

        String getReviewLinkType();

        String getReviewLinkUrl();
    }
}
