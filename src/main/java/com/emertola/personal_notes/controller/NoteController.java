package com.emertola.personal_notes.controller;

import com.emertola.personal_notes.model.ErrorResponse;
import com.emertola.personal_notes.model.Note;
import com.emertola.personal_notes.service.NoteService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/notes")
public class NoteController {
    private final NoteService noteService;

    public NoteController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping
    public ResponseEntity<List<Note>> getAllNotes() {
        return ResponseEntity.ok(noteService.getAllNotes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getNoteById(@PathVariable Long id) {
        return noteService.getNoteById(id)
                .<ResponseEntity<Object>>map(note -> ResponseEntity.ok().body(note))
                .orElseGet(() -> {
                    ErrorResponse error = new ErrorResponse("Note with ID " + id + " was not found.", 404);
                    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
                });
    }

    @PostMapping
    public ResponseEntity<Note> createNote(@RequestBody Note note) {
        return ResponseEntity.status(HttpStatus.CREATED).body(noteService.createNote(note));
    }
}
