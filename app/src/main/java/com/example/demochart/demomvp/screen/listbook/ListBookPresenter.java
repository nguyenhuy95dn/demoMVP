package com.example.demochart.demomvp.screen.listbook;

import com.example.demochart.demomvp.data.BooksRepository;
import com.example.demochart.demomvp.data.model.Book;
import java.util.List;

/**
 * Created by nguyenhuy95dn on 1/17/2018.
 */

public class ListBookPresenter implements  ListBookContract.Presenter {
    private final ListBookContract.View mBookDetailView;
    private final BooksRepository mNotesRepository;

    public ListBookPresenter(ListBookContract.View bookDetailView,
            BooksRepository notesRepository) {
        mBookDetailView = bookDetailView;
        mNotesRepository = notesRepository;
    }

    @Override
    public void loadBooks() {
        mNotesRepository.getNotes(new BooksRepository.LoadNotesCallback() {
            @Override
            public void onNotesLoaded(List<Book> books) {
                mBookDetailView.showBooks(books);
            }
        });
    }
}
