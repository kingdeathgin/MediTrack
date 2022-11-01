package com.example.meditrack.listeners;

import com.example.meditrack.entities.Note;

public interface NotesListener {
    void onNoteClicked(Note note, int position);
}
