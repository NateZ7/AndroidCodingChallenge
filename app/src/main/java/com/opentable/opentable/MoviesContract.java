package com.opentable.opentable;

public interface MoviesContract {

    interface IMoviesView {

        /**
         * Initializing the views
         */
        void initViews();

    }

    interface IMoviesPresenter {

        /**
         * Fetching movies as JSON and notifying the UI
         */
        void fetchMovies();

    }
}
