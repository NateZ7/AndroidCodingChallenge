package com.opentable.opentable.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.opentable.opentable.Contracts.ReviewsContract;
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

        viewHolder.mTitle.setText(review.getTitle());

        return convertView;
    }

    public void setReviews(List<Review> reviews){
        if (reviews !=null && reviews.size() > 0){
            this.mReviews.clear();
            this.mReviews.addAll(reviews);
        }
    }
    // endregion

    static class ViewHolder {
        TextView mTitle;
    }
}

