package com.example.demochart.demomvp.screen.addbook;

import com.example.demochart.demomvp.data.model.Book;
import com.example.demochart.demomvp.screen.detailbook.BookDetailContract;

/**
 * Created by nguyenhuy95dn on 1/21/2018.
 */

public interface AddBookContract {

    interface View {
        void setPresenter(AddBookContract.Presenter presenter);

        void addBookSuccess(Book book);
    }

    interface Presenter {

        void addBook(Book book);
    }
}
