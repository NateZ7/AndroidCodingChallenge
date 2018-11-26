package com.opentable.opentable.Adapters;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
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

            viewHolder.mLayout = convertView.findViewById(R.id.layout);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Review review = mReviews.get(position);

        // Strings
        verifyAndSetStringText(review.getTitle(), viewHolder, parent.getContext(), "Title: ");
        verifyAndSetStringText(review.getHeadline(), viewHolder, parent.getContext(), "Headline: ");
        verifyAndSetStringText(review.getSummaryShort(), viewHolder, parent.getContext(), "Summary: ");
        verifyAndSetStringText(review.getByLine(), viewHolder, parent.getContext(), "By Line: ");
        verifyAndSetStringText(review.getCriticsPick(), viewHolder, parent.getContext(), "Critics Pick: ");
        verifyAndSetStringText(review.getMpaaRating(), viewHolder, parent.getContext(), "Rating: ");

        // Dates
        verifyAndSetStringText(Utils.dateToString(review.getOpeningDate()), viewHolder, parent.getContext(), "Opening Date: ");
        verifyAndSetStringText(Utils.dateToString(review.getPublicationDate()), viewHolder, parent.getContext(), "Publication Date: ");
        verifyAndSetStringText(Utils.dateToString(review.getDateUpdated()), viewHolder, parent.getContext(), "Date Updated: ");

        // Multimedia
        verifyAndSetStringText(review.getReviewMultimediaSrc(), viewHolder, parent.getContext(), "Multimedia Source: ");
        verifyAndSetStringText(review.getReviewMultimediaType(), viewHolder, parent.getContext(), "Multimedia Type: ");
        verifyAndSetStringText(Integer.toString(review.getReviewMultimediaHeight()), viewHolder, parent.getContext(), "Multimedia Height: ");
        verifyAndSetStringText(Integer.toString(review.getReviewMultimediaWidth()), viewHolder, parent.getContext(), "Multimedia Width: ");

        // Link
        verifyAndSetStringText(review.getReviewLinkType(), viewHolder, parent.getContext(), "Link Type: ");
        verifyAndSetStringText(review.getReviewLinkUrl(), viewHolder, parent.getContext(), "Link Url: ");


        return convertView;
    }

    /**
     * Verifying content, and if content is valid, adding to the adapter Layout
     * @param text - text to add
     * @param holder - viewholder that holds the layout
     * @param context - context of the view (the parent)
     */
    private void verifyAndSetStringText(String text, ViewHolder holder, Context context, String prefix) {
        if (text == null || text.isEmpty()) {
            return;
        }

        TextView textView = new TextView(context);
        textView.setTextSize(16);
        textView.setTextColor(Color.BLACK);

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMargins(5,10,5,10);

        textView.setLayoutParams(params);
        holder.mLayout.addView(textView);
        textView.setText(prefix + text);
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

    static class ViewHolder {
        LinearLayout mLayout;
    }
}

