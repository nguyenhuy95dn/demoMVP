package com.example.demochart.demomvp.screen.detailbook;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.example.demochart.demomvp.R;
import com.example.demochart.demomvp.data.model.Book;

/**
 * Created by nguyenhuy95dn on 1/17/2018.
 */

public class BookDetailActivity extends AppCompatActivity implements BookDetailContract.View{

    private BookDetailContract.Presenter mPresenter;
    private EditText mTitle;
    private EditText mDescription;
    private Book mBook;
    private FloatingActionButton mFloatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);

        mTitle = (EditText)findViewById(R.id.title);
        mDescription = (EditText)findViewById(R.id.description);
        mFloatingActionButton = (FloatingActionButton)findViewById(R.id.fab_edit_book);
        mBook = getIntent().getExtras().getParcelable("BOOK");

        mTitle.setText(mBook.getTitle());
        mDescription.setText(mBook.getDescription());

        mFloatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                mBook.setTitle(mTitle.getText().toString());
                mBook.setDescription(mDescription.getText().toString());
                intent.putExtra("BOOK", mBook);
                setResult(1, intent);
                finish();
            }
        });
    }

    @Override
    public void setPresenter(BookDetailContract.Presenter presenter) {
        mPresenter = presenter;
    }
}
