package com.opentable.opentable;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

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

        mPresenter.fetchMovies();
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
