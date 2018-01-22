package com.example.demochart.demomvp.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;

/**
 * Created by nguyenhuy95dn on 1/17/2018.
 */

public class Book implements Parcelable {
    private int mId;
    private String mTitle;
    private String mDescription;
    private String mImageUrl;

    public Book() {
    }

    public Book(int id, String title, String description, String imageUrl) {
        mId = id;
        mTitle = title;
        mDescription = description;
        mImageUrl = imageUrl;
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public String getImageUrl() {
        return mImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        mImageUrl = imageUrl;
    }

    private Book(Parcel in) {
        mId = in.readInt();
        mTitle = in.readString();
        mDescription = in.readString();
        mImageUrl = in.readString();
    }

    public static final Creator<Book> CREATOR = new Creator<Book>() {
        @Override
        public Book createFromParcel(Parcel in) {
            return new Book(in);
        }

        @Override
        public Book[] newArray(int size) {
            return new Book[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mId);
        dest.writeString(mTitle);
        dest.writeString(mDescription);
        dest.writeString(mImageUrl);
    }
}
