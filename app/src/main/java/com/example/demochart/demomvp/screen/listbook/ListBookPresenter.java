package com.example.demochart.demomvp.screen.listbook;

/**
 * Created by nguyenhuy95dn on 1/17/2018.
 */

public class ListBookPresenter implements  ListBookContract.Presenter {
    private final ListBookContract.View mBookDetailView;

    public ListBookPresenter(ListBookContract.View bookDetailView) {
        mBookDetailView = bookDetailView;
    }
}
