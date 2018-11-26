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

        /**
         * Getting review title
         * @return review title
         */
        String getTitle();

        /**
         * Getting rating
         * @return String of rating
         */
        String getMpaaRating();

        /**
         * Getting headline
         * @return String of headline
         */
        String getHeadline();

        /**
         * Getting byline
         * @return String of ByLine
         */
        String getByLine();

        /**
         * Getting short summary
         * @return String of short summary
         */
        String getSummaryShort();

        /**
         * Getting Date of publication date
         * @return Date object of publication date
         */
        Date getPublicationDate();

        /**
         * Getting Date of opening date
         * @return Date object of opening date
         */
        Date getOpeningDate();

        /**
         * Getting Date of updated date
         * @return Date object of updated date
         */
        Date getDateUpdated();

        /**
         * Getting critics pick
         * @return String of critics pick
         */
        String getCriticsPick();

        /**
         * Getting MM type
         * @return String of MM type
         */
        String getReviewMultimediaType();

        /**
         * Getting MM source
         * @return String of MM source
         */
        String getReviewMultimediaSrc();

        /**
         * Getting MM width
         * @return Int of MM width
         */
        int getReviewMultimediaWidth();

        /**
         * Getting MM height
         * @return Int of MM height
         */
        int getReviewMultimediaHeight();

        /**
         * Getting Link Type
         * @return String of link type
         */
        String getReviewLinkType();

        /**
         * Getting Link Url
         * @return String of link url
         */
        String getReviewLinkUrl();
    }
}
