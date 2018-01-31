/*
 * Copyright 2015, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example.demochart.demomvp.data;

import android.annotation.SuppressLint;
import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;
import com.example.demochart.demomvp.data.model.Book;
import java.util.List;

import static android.support.v4.util.Preconditions.checkNotNull;

/**
 * Concrete implementation to load notes from the a data source.
 */
public class InMemoryBooksRepository implements BooksRepository {

    private final BooksServiceApi mNotesServiceApi;

    /**
     * This method has reduced visibility for testing and is only visible to tests in the same
     * package.
     */
    @VisibleForTesting
    List<Book> mCachedNotes;

    @SuppressLint("RestrictedApi")
    public InMemoryBooksRepository(@NonNull BooksServiceApi notesServiceApi) {
        mNotesServiceApi = checkNotNull(notesServiceApi);
    }

    @SuppressLint("RestrictedApi")
    @Override
    public void getNotes(@NonNull final LoadNotesCallback callback) {
        checkNotNull(callback);
        // Load from API only if needed.
        if (mCachedNotes == null) {
            mNotesServiceApi.getAllNotes(new BooksServiceApi.NotesServiceCallback<List<Book>>() {
                @Override
                public void onLoaded(List<Book> notes) {
                    mCachedNotes = notes;
                    callback.onNotesLoaded(notes);
                }
            });
        } else {
            callback.onNotesLoaded(mCachedNotes);
        }
    }

    @Override
    public void saveBook(@NonNull Book book) {
        mNotesServiceApi.saveBook(book);
        refreshData();
    }

    @Override
    public void getNote(@NonNull final String noteId, @NonNull final GetNoteCallback callback) {
        // Load notes matching the id always directly from the API.
        mNotesServiceApi.getBook(noteId, new BooksServiceApi.NotesServiceCallback<Book>() {
            @Override
            public void onLoaded(Book book) {
                callback.onNoteLoaded(book);
            }
        });
    }

    @Override
    public void refreshData() {
        mCachedNotes = null;
    }
}
