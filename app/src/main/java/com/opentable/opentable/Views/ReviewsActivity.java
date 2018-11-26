package com.opentable.opentable.Views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.ListView;
import android.widget.Toast;

import com.opentable.opentable.Adapters.ReviewsAdapter;
import com.opentable.opentable.Models.Review;
import com.opentable.opentable.Presenters.ReviewsPresenter;
import com.opentable.opentable.R;
import com.opentable.opentable.Contracts.ReviewsContract;

import java.util.List;

public class ReviewsActivity extends AppCompatActivity implements ReviewsContract.IReviewsView {

    // region Class Members
    private ReviewsPresenter mPresenter;
    private ListView mListView;
    private ReviewsAdapter mAdapter;
    // endregion

    // region Protected Access
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reviews);
        getSupportActionBar().hide();

        mPresenter = new ReviewsPresenter(this);

        mListView = findViewById(R.id.listview);
        mAdapter = new ReviewsAdapter(mPresenter);
        mListView.setAdapter(mAdapter);

        mPresenter.onFetchReviews();
    }
    // endregion

    // region Public Access
    @Override
    public void onToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onGetReviewList(List<Review> reviews) {
        mAdapter.setReviews(reviews);
        runOnUiThread(new Runnable() {

            @Override
            public void run() {
                mAdapter.notifyDataSetChanged();
            }
        });
    }
    // endregion
}
