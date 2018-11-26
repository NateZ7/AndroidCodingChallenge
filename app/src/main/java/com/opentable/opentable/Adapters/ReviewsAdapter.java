package com.opentable.opentable.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.opentable.opentable.Contracts.ReviewsContract;
import com.opentable.opentable.Helpers.Utils;
import com.opentable.opentable.Models.Review;
import com.opentable.opentable.R;

import java.util.ArrayList;
import java.util.List;

public class ReviewsAdapter extends BaseAdapter {

    // region Class Members
    private ReviewsContract.IReviewsPresenter mPresenter;
    private List<Review> mReviews;
    // endregion

    // region Public Access
    public ReviewsAdapter(ReviewsContract.IReviewsPresenter presenter) {
        this.mPresenter = presenter;
        this.mReviews = new ArrayList<>();
    }

    @Override
    public int getCount() {
        return mReviews.size();
    }

    @Override
    public Object getItem(int position) {
        return mReviews.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;

        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.reviews_list_view, null);
            viewHolder = new ViewHolder();

            viewHolder.mTitle = convertView.findViewById(R.id.title);
            viewHolder.mRating = convertView.findViewById(R.id.rating);
            viewHolder.mHeadline = convertView.findViewById(R.id.headline);
            viewHolder.mSummaryShort = convertView.findViewById(R.id.summary_short);
            viewHolder.mByLine = convertView.findViewById(R.id.by_line);
            viewHolder.mPublicationDate = convertView.findViewById(R.id.publication_date);
            viewHolder.mOpeningDate = convertView.findViewById(R.id.opening_date);
            viewHolder.mUpdatedDate = convertView.findViewById(R.id.date_updated);
            viewHolder.mCriticsPick = convertView.findViewById(R.id.critics_pick);
            viewHolder.mMmSrc = convertView.findViewById(R.id.mm_src);
            viewHolder.mMmHeight = convertView.findViewById(R.id.mm_height);
            viewHolder.mMmType = convertView.findViewById(R.id.mm_type);
            viewHolder.mMmWidth = convertView.findViewById(R.id.mm_width);
            viewHolder.mLinkUrl = convertView.findViewById(R.id.link_url);
            viewHolder.mLinkType = convertView.findViewById(R.id.link_type);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Review review = mReviews.get(position);

        // Strings
        verifyAndSetTextView(review.getTitle(), viewHolder.mTitle, "Title: ");
        verifyAndSetTextView(review.getHeadline(), viewHolder.mHeadline, "Headline: ");
        verifyAndSetTextView(review.getSummaryShort(), viewHolder.mSummaryShort, "Summary: ");
        verifyAndSetTextView(review.getByLine(), viewHolder.mByLine, "By Line: ");
        verifyAndSetTextView(review.getCriticsPick(), viewHolder.mCriticsPick, "Critics Pick: ");
        verifyAndSetTextView(review.getMpaaRating(), viewHolder.mRating, "Rating: ");

        // Dates
        verifyAndSetTextView(Utils.dateToString(review.getOpeningDate(), "yyyy-MM-dd"), viewHolder.mOpeningDate, "Opening Date: ");
        verifyAndSetTextView(Utils.dateToString(review.getPublicationDate(), "yyyy-MM-dd"), viewHolder.mPublicationDate, "Publication Date: ");
        verifyAndSetTextView(Utils.dateToString(review.getDateUpdated(), "yyyy-MM-dd"), viewHolder.mUpdatedDate, "Date Updated: ");

        // Multimedia
        verifyAndSetTextView(review.getReviewMultimediaSrc(), viewHolder.mMmSrc, "Multimedia Source: ");
        verifyAndSetTextView(review.getReviewMultimediaType(), viewHolder.mMmType, "Multimedia Type: ");
        verifyAndSetTextView(Integer.toString(review.getReviewMultimediaHeight()), viewHolder.mMmHeight, "Multimedia Height: ");
        verifyAndSetTextView(Integer.toString(review.getReviewMultimediaWidth()), viewHolder.mMmWidth, "Multimedia Width: ");

        // Link
        verifyAndSetTextView(review.getReviewLinkType(), viewHolder.mLinkType, "Link Type: ");
        verifyAndSetTextView(review.getReviewLinkUrl(), viewHolder.mLinkUrl, "Link Url: ");

        return convertView;
    }

    /**
     * Setting the reviews
     * @param reviews - list of reviews to set
     */
    public void setReviews(List<Review> reviews){
        if (reviews != null && reviews.size() > 0){
            this.mReviews.clear();
            this.mReviews.addAll(reviews);
        }
    }
    // endregion

    // region Private Access
    /**
     * Validating text and setting as a textview with a prefix
     * @param text - text to set
     * @param textView - textview to be set
     * @param prefix - prefix to describe the following text
     */
    private void verifyAndSetTextView(String text, TextView textView, String prefix) {
        if (text == null || text.isEmpty()) {
            textView.setVisibility(View.GONE);
            return;
        }

        textView.setVisibility(View.VISIBLE);
        textView.setText(prefix + text);
    }
    // endregion

    static class ViewHolder {
        TextView mTitle;
        TextView mRating;
        TextView mHeadline;
        TextView mByLine;
        TextView mSummaryShort;
        TextView mPublicationDate;
        TextView mOpeningDate;
        TextView mUpdatedDate;
        TextView mCriticsPick;
        TextView mMmSrc;
        TextView mMmType;
        TextView mMmWidth;
        TextView mMmHeight;
        TextView mLinkUrl;
        TextView mLinkType;
    }
}

