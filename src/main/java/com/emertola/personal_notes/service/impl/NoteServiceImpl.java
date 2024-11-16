package com.emertola.personal_notes.service.impl;

import com.emertola.personal_notes.model.Note;
import com.emertola.personal_notes.repository.NoteRepository;
import com.emertola.personal_notes.service.NoteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NoteServiceImpl implements NoteService {
    private final NoteRepository noteRepository;

    public NoteServiceImpl(NoteRepository noteRepository) {
        this.noteRepository = noteRepository;
    }

    @Override
    public List<Note> getAllNotes() {
        return noteRepository.findAll();
    }

    @Override
    public Note createNote(Note note) {
        return noteRepository.save(note);
    }

    @Override
    public Optional<Note> getNoteById(Long id) {
        return noteRepository.findById(id);
    }

    @Override
    public Note updateNote(Long id, Note updatedNote) {
        return noteRepository.findById(id)
                .map(existingNote -> {
                    existingNote.setNotes(updatedNote.getNotes());
                    return noteRepository.save(existingNote);
                })
                .orElseThrow(() -> new RuntimeException("Note not found"));
    }
}
