package com.example.demochart.demomvp.screen.addbook;

import com.example.demochart.demomvp.data.BooksRepository;
import com.example.demochart.demomvp.data.model.Book;

/**
 * Created by nguyenhuy95dn on 1/21/2018.
 */

public class AddBookPresenter implements AddBookContract.Presenter {
    private final AddBookContract.View mBookDetailView;
    private final BooksRepository mBooksRepository;

    public AddBookPresenter(AddBookContract.View bookDetailView, BooksRepository booksRepository) {
        mBookDetailView = bookDetailView;
        mBooksRepository = booksRepository;
    }

    @Override
    public void addBook(Book book) {
        mBookDetailView.addBookSuccess(book);
        mBooksRepository.saveBook(book);
    }
}
