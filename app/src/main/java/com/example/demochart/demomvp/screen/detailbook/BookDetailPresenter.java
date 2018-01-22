package com.example.demochart.demomvp.screen.detailbook;

/**
 * Created by nguyenhuy95dn on 1/17/2018.
 */

public class BookDetailPresenter implements BookDetailContract.Presenter {
    private final BookDetailContract.View mBookDetailView;

    public BookDetailPresenter(BookDetailContract.View bookDetailView) {
        mBookDetailView = bookDetailView;
    }
}
