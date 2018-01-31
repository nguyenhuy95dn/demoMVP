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

import android.support.annotation.VisibleForTesting;
import android.support.v4.util.ArrayMap;
import com.example.demochart.demomvp.data.model.Book;
import java.util.ArrayList;
import java.util.List;

/**
 * Fake implementation of {@link BooksServiceApi} to inject a fake service in a hermetic test.
 */
public class FakeBooksServiceApiImpl implements BooksServiceApi {

    // TODO replace this with a new test specific data set.
    private static final ArrayMap<String, Book> NOTES_SERVICE_DATA = new ArrayMap();

    @Override
    public void getAllNotes(NotesServiceCallback<List<Book>> callback) {
        callback.onLoaded(new ArrayList<Book>(NOTES_SERVICE_DATA.values()));
    }

    @Override
    public void getBook(String noteId, NotesServiceCallback<Book> callback) {
        Book book = NOTES_SERVICE_DATA.get(noteId);
        callback.onLoaded(book);
    }

    @Override
    public void saveBook(Book book) {
        NOTES_SERVICE_DATA.put(String.valueOf(book.getId()), book);
    }

    @VisibleForTesting
    public static void addNotes(Book... notes) {
        for (Book book : notes) {
            NOTES_SERVICE_DATA.put(String.valueOf(book.getId()), book);
        }
    }
}
