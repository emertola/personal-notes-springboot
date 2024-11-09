package com.emertola.personal_notes.service;

import com.emertola.personal_notes.model.Note;
import com.emertola.personal_notes.repository.NoteRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoteService {
    private final NoteRepository noteRepository;

    public NoteService(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    @Transactional
    public Note createNote(Note note) {
        return noteRepository.save(note);
    }
}
