package com.example.demochart.demomvp.screen.addbook;

import android.content.Intent;
import com.example.demochart.demomvp.data.model.Book;

/**
 * Created by nguyenhuy95dn on 1/21/2018.
 */

public class AddBookPresenter implements AddBookContract.Presenter {
    private final AddBookContract.View mBookDetailView;

    public AddBookPresenter(AddBookContract.View bookDetailView) {
        mBookDetailView = bookDetailView;
    }

    @Override
    public void addBook(Book book) {
        mBookDetailView.addBookSuccess(book);
    }
}
