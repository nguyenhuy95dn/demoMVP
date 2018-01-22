package com.example.demochart.demomvp.screen.addbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import com.example.demochart.demomvp.R;
import com.example.demochart.demomvp.data.model.Book;

/**
 * Created by nguyenhuy95dn on 1/21/2018.
 */

public class AddBookActivity extends AppCompatActivity implements AddBookContract.View {
    private AddBookContract.Presenter mPresenter;
    private EditText mTitle;
    private EditText mDescription;
    private FloatingActionButton mFloatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_book);

        mTitle = (EditText) findViewById(R.id.title);
        mDescription = (EditText) findViewById(R.id.description);
        mFloatingActionButton = (FloatingActionButton) findViewById(R.id.fab_add_book);
        mPresenter = new AddBookPresenter(this);
        setPresenter(mPresenter);

        mFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Book book = new Book();
                book.setTitle(mTitle.getText().toString());
                book.setDescription(mDescription.getText().toString());
                mPresenter.addBook(book);
            }
        });
    }

    @Override
    public void setPresenter(AddBookContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public void addBookSuccess(Book book) {
        Intent intent = new Intent();
        intent.putExtra("ADD_BOOK", book);
        setResult(2, intent);
        finish();
    }
}
