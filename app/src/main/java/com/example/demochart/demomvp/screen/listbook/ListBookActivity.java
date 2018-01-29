package com.example.demochart.demomvp.screen.listbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import com.example.demochart.demomvp.R;
import com.example.demochart.demomvp.data.FakeBooksServiceApiImpl;
import com.example.demochart.demomvp.data.BookRepositories;
import com.example.demochart.demomvp.data.BooksRepository;
import com.example.demochart.demomvp.data.model.Book;
import com.example.demochart.demomvp.screen.addbook.AddBookActivity;
import com.example.demochart.demomvp.screen.detailbook.BookDetailActivity;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nguyenhuy95dn on 1/17/2018.
 */

public class ListBookActivity extends AppCompatActivity
        implements ListBookContract.View, ListBookAdapter.BookItemClickListener {
    private ListBookContract.Presenter mPresenter;
    private ListBookAdapter mListAdapter;
    private List<Book> books = new ArrayList<>();
    private FloatingActionButton mFloatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //        books.add(new Book(0, "Book 1", "Mô tả 1", ""));
        //        books.add(new Book(1, "Book 2", "Mô tả 2", ""));
        //        books.add(new Book(2, "Book 3", "Mô tả 3", ""));
        //        books.add(new Book(3, "Book 4", "Mô tả 4", ""));

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycle_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        mListAdapter = new ListBookAdapter(books);
        recyclerView.setAdapter(mListAdapter);
        mListAdapter.setItemClickListener(this);

        BooksRepository notesRepository =
                BookRepositories.getInMemoryRepoInstance(new FakeBooksServiceApiImpl());
        mPresenter = new ListBookPresenter(this, notesRepository);
        setPresenter(mPresenter);

        mFloatingActionButton = (FloatingActionButton) findViewById(R.id.fab_add_book);
        mFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AddBookActivity.class);
                startActivityForResult(intent, 2);
            }
        });
    }

    @Override
    public void setPresenter(ListBookContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    protected void onStart() {
        super.onStart();
        mPresenter.loadBooks();
    }

    @Override
    public void showBooks(List<Book> books) {
        mListAdapter.updateData(books);
    }

    @Override
    public void onNoteClick(Book book) {
        Intent intent = new Intent(this, BookDetailActivity.class);
        intent.putExtra("BOOK", book);
        startActivityForResult(intent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && data != null) {
            Bundle bundle = data.getExtras();
            Book book = (Book) bundle.getParcelable("BOOK");
            books.set(book.getId(), book);
            mListAdapter.updateData(books);
        }
        if (requestCode == 2 && data != null) {
            mPresenter.loadBooks();
        }
    }
}
