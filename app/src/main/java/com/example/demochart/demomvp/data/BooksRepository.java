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

import android.support.annotation.NonNull;
import com.example.demochart.demomvp.data.model.Book;
import java.util.List;

/**
 * Main entry point for accessing notes data.
 */
public interface BooksRepository {

    interface LoadNotesCallback {

        void onNotesLoaded(List<Book> notes);
    }

    interface GetNoteCallback {

        void onNoteLoaded(Book book);
    }

    void getNotes(@NonNull LoadNotesCallback callback);

    void getNote(@NonNull String noteId, @NonNull GetNoteCallback callback);

    void saveBook(@NonNull Book book);

    void refreshData();

}
