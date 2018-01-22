package com.example.demochart.demomvp.screen.listbook;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.demochart.demomvp.R;
import com.example.demochart.demomvp.data.model.Book;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by nguyenhuy95dn on 1/17/2018.
 */

public class ListBookAdapter extends RecyclerView.Adapter<ListBookAdapter.ViewHolder> {

    private List<Book> mBook;
    private BookItemClickListener mItemListener;

    public ListBookAdapter(List<Book> books) {
        mBook = new ArrayList<>();
        mBook.addAll(books);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View noteView = inflater.inflate(R.layout.item_book, parent, false);

        return new ViewHolder(noteView, mItemListener);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        Book book = mBook.get(position);

        viewHolder.title.setText(book.getTitle());
        viewHolder.description.setText(book.getDescription());
    }

    public void updateData(List<Book> book) {
        if (book == null) {
            return;
        }
        mBook.clear();
        mBook.addAll(book);
        notifyDataSetChanged();
    }

    public void setItemClickListener(BookItemClickListener itemClickListener) {
        mItemListener = itemClickListener;
    }

    @Override
    public int getItemCount() {
        return mBook.size();
    }

    public Book getItem(int position) {
        return mBook.get(position);
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        public TextView title;

        public TextView description;
        private BookItemClickListener mItemListener;

        public ViewHolder(View itemView, BookItemClickListener listener) {
            super(itemView);
            mItemListener = listener;
            title = (TextView) itemView.findViewById(R.id.book_title);
            description = (TextView) itemView.findViewById(R.id.book_description);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position = getAdapterPosition();
            Book book = getItem(position);
            mItemListener.onNoteClick(book);
        }
    }

    public interface BookItemClickListener {
        void onNoteClick(Book book);
    }
}
