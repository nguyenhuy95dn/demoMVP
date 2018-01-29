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

import android.os.Handler;
import android.support.v4.util.ArrayMap;
import com.example.demochart.demomvp.data.model.Book;
import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the Notes Service API that adds a latency simulating network.
 */
public class BooksServiceApiImpl implements BooksServiceApi {

    private static final int SERVICE_LATENCY_IN_MILLIS = 2000;
    private static final ArrayMap<String, Book> NOTES_SERVICE_DATA =
            BooksServiceApiEndpoint.loadPersistedNotes();

    @Override
    public void getAllNotes(final NotesServiceCallback callback) {
        // Simulate network by delaying the execution.
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                List<Book> notes = new ArrayList<>(NOTES_SERVICE_DATA.values());
                callback.onLoaded(notes);
            }
        }, SERVICE_LATENCY_IN_MILLIS);
    }

    @Override
    public void getBook(final String noteId, final NotesServiceCallback callback) {
        //TODO: Add network latency here too.
        Book book = NOTES_SERVICE_DATA.get(noteId);
        callback.onLoaded(book);
    }

    @Override
    public void saveNote(Book book) {
        NOTES_SERVICE_DATA.put(String.valueOf(book.getId()), book);
    }
}

