package com.opentable.opentable.Models;

import com.opentable.opentable.Contracts.ReviewsContract;

import java.util.Date;

public class Review implements ReviewsContract.IReview {

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

    @Override
    public String getTitle() {
        return mTitle;
    }

    @Override
    public String getMpaaRating() {
        return mMpaaRating;
    }

    @Override
    public String getHeadline() {
        return mHeadline;
    }

    @Override
    public String getByLine() {
        return mByLine;
    }

    @Override
    public String getSummaryShort() {
        return mSummaryShort;
    }

    @Override
    public Date getPublicationDate() {
        return mPublicationDate;
    }

    @Override
    public Date getOpeningDate() {
        return mOpeningDate;
    }

    @Override
    public Date getDateUpdated() {
        return mDateUpdated;
    }

    @Override
    public String getCriticsPick() {
        return mCriticsPick;
    }

    @Override
    public String getReviewMultimediaType() {
        return mReviewMultimedia.getType();
    }

    @Override
    public String getReviewMultimediaSrc() {
        return mReviewMultimedia.getSrc();
    }

    @Override
    public int getReviewMultimediaWidth() {
        return mReviewMultimedia.getWidth();
    }

    @Override
    public int getReviewMultimediaHeight() {
        return mReviewMultimedia.getHeight();
    }

    @Override
    public String getReviewLinkType() {
        return mReviewLink.getType();
    }

    @Override
    public String getReviewLinkUrl() {
        return mReviewLink.getUrl();
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

        public String getType() {
            return mType;
        }

        public String getSrc() {
            return mSrc;
        }

        public int getWidth() {
            return mWidth;
        }

        public int getHeight() {
            return mHeight;
        }
    }

    private class ReviewLink {

        String mType;
        String mUrl;

        public ReviewLink(String type, String url) {
            this.mType = type;
            this.mUrl = url;
        }

        public String getType() {
            return mType;
        }

        public String getUrl() {
            return mUrl;
        }
    }
}
