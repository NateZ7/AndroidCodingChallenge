package com.opentable.opentable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MoviesActivity extends AppCompatActivity implements MoviesContract.IMoviesView{

    // region Class Members
    private MoviesPresenter mPresenter;
    private ListView mListView;
    // endregion

    // region Protected Access
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movies);
        getSupportActionBar().hide();

        mPresenter = new MoviesPresenter(this);
    }
    // endregion

    // region Public Access
    @Override
    public void initViews() {
        mListView = findViewById(R.id.listview);
    }
    // endregion
}
