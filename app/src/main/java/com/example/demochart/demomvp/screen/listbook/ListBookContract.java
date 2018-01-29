package com.example.demochart.demomvp.screen.listbook;

import com.example.demochart.demomvp.data.model.Book;
import java.util.List;

/**
 * Created by nguyenhuy95dn on 1/17/2018.
 */

public interface ListBookContract {

    interface View {
        void setPresenter(ListBookContract.Presenter presenter);

        void showBooks(List<Book> books);
    }

    interface Presenter {

        void loadBooks();
    }
}
