package com.opentable.opentable.Views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.opentable.opentable.Presenters.ReviewsPresenter;
import com.opentable.opentable.R;
import com.opentable.opentable.Contracts.ReviewsContract;

public class ReviewsActivity extends AppCompatActivity implements ReviewsContract.IReviewsView {

    // region Class Members
    private ReviewsPresenter mPresenter;
    private ListView mListView;
    // endregion

    // region Protected Access
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reviews);
        getSupportActionBar().hide();

        mPresenter = new ReviewsPresenter(this);

        mPresenter.fetchReviews();
    }
    // endregion

    // region Public Access
    @Override
    public void initViews() {
        mListView = findViewById(R.id.listview);
    }

    @Override
    public void makeToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }
    // endregion
}
