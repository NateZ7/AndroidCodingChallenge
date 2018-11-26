package com.opentable.opentable;

import java.util.Date;

public class Review {

    private String mTitle;
    private String mMpaaRating;
    private String mHeadline;
    private String mByLine;
    private String mSummaryShort;
    private Date mPublicationDate;
    private Date mOpeningDate;
    private Date mDateUpdated;
    private String mCriticsPick;
    private ReviewMultimedia mReviewMultimedia;
    private ReviewLink mReviewLink;

    public Review(String title, String rating, String headline, String byLine, String summaryShort,
                  Date publicationDate, Date openingDate, Date dateUpdated, String criticsPick, String multimediaType, String src,
                  int width, int height, String linkType, String linkUrl) {
        this.mTitle = title;
        this.mMpaaRating = rating;
        this.mHeadline = headline;
        this.mByLine = byLine;
        this.mSummaryShort = summaryShort;
        this.mPublicationDate = publicationDate;
        this.mOpeningDate = openingDate;
        this.mDateUpdated = dateUpdated;
        this.mCriticsPick = criticsPick;
        this.mReviewMultimedia = new ReviewMultimedia(multimediaType, src, width, height);
        this.mReviewLink = new ReviewLink(linkType, linkUrl);
    }

    private class ReviewMultimedia {

        String mType;
        String mSrc;
        int mWidth;
        int mHeight;

        public ReviewMultimedia(String type, String src, int width, int height) {
            this.mType = type;
            this.mSrc = src;
            this.mWidth = width;
            this.mHeight = height;
        }
    }

    private class ReviewLink {

        String mType;
        String mUrl;

        public ReviewLink(String type, String url) {
            this.mType = type;
            this.mUrl = url;
        }
    }
}
