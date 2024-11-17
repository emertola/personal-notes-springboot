package com.emertola.personal_notes.service;

import com.emertola.personal_notes.model.Note;

import java.util.List;
import java.util.Optional;

public interface NoteService {
    List<Note> getAllNotes();
    Optional<Note> getNoteById(Long id);
    Note createNote(Note note);
    Note updateNote(Long id, Note updatedNote);
    void deleteNoteById(Long id);
}
