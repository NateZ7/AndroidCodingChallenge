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

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Review review = mReviews.get(position);

        verifyAndSetTextView(review.getTitle(), viewHolder.mTitle, "");

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

    /**
     * Showing more data of specific review
     * @param view - view to show the data
     * @param position - position of the review
     */
    public void showReviewFullData(View view, int position) {
        Review review = mReviews.get(position);

        // Strings
        verifyAndSetTextView(review.getTitle(), (TextView)view.findViewById(R.id.title), "Title: ");
        verifyAndSetTextView(review.getHeadline(), (TextView)view.findViewById(R.id.headline), "Headline: ");
        verifyAndSetTextView(review.getSummaryShort(), (TextView)view.findViewById(R.id.summary_short), "Summary: ");
        verifyAndSetTextView(review.getByLine(), (TextView)view.findViewById(R.id.by_line), "By Line: ");
        verifyAndSetTextView(review.getCriticsPick(), (TextView)view.findViewById(R.id.critics_pick), "Critics Pick: ");
        verifyAndSetTextView(review.getMpaaRating(), (TextView)view.findViewById(R.id.rating), "Rating: ");

        // Dates
        verifyAndSetTextView(Utils.dateToString(review.getOpeningDate(), "yyyy-MM-dd"), (TextView)view.findViewById(R.id.opening_date), "Opening Date: ");
        verifyAndSetTextView(Utils.dateToString(review.getPublicationDate(), "yyyy-MM-dd"), (TextView)view.findViewById(R.id.publication_date), "Publication Date: ");
        verifyAndSetTextView(Utils.dateToString(review.getDateUpdated(), "yyyy-MM-dd"), (TextView)view.findViewById(R.id.date_updated), "Date Updated: ");

        // Multimedia
        verifyAndSetTextView(review.getReviewMultimediaSrc(), (TextView)view.findViewById(R.id.mm_src), "Multimedia Source: ");
        verifyAndSetTextView(review.getReviewMultimediaType(), (TextView)view.findViewById(R.id.mm_type), "Multimedia Type: ");
        verifyAndSetTextView(Integer.toString(review.getReviewMultimediaHeight()), (TextView)view.findViewById(R.id.mm_height), "Multimedia Height: ");
        verifyAndSetTextView(Integer.toString(review.getReviewMultimediaWidth()), (TextView)view.findViewById(R.id.mm_width), "Multimedia Width: ");

        // Link
        verifyAndSetTextView(review.getReviewLinkType(), (TextView)view.findViewById(R.id.link_type), "Link Type: ");
        verifyAndSetTextView(review.getReviewLinkUrl(), (TextView)view.findViewById(R.id.link_url), "Link Url: ");
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
        textView.setText(prefix == "" ? text + " - Read More..." : prefix + text);
    }
    // endregion

    static class ViewHolder {
        TextView mTitle;
    }
}

