package com.example.notesapi.controller;

import com.example.notesapi.dto.NotesRequestDto;
import com.example.notesapi.dto.NotesResponseDto;
import com.example.notesapi.service.NotesService;

import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notes")
public class NotesController {

    @Autowired
    private NotesService notesService;

    @PostMapping
    public ResponseEntity<NotesResponseDto> createNotes(@Valid @RequestBody NotesRequestDto dto) {
        NotesResponseDto created=notesService.createNotes(dto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<NotesResponseDto>> getAllNotes(
            @RequestParam(defaultValue="0") int page,
            @RequestParam(defaultValue="5") int size) {

        Page<NotesResponseDto> notes=notesService.getAllNotes(page, size);
        return ResponseEntity.ok(notes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<NotesResponseDto> getNoteById(@PathVariable Long id) {
        NotesResponseDto note=notesService.getNotesById(id);
        return ResponseEntity.ok(note);
    }

    @PutMapping("/{id}")
    public ResponseEntity<NotesResponseDto> updateNote(
            @PathVariable Long id,
            @Valid @RequestBody NotesRequestDto dto) {

        NotesResponseDto updated=notesService.updateNotes(id, dto);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteNote(@PathVariable Long id) {
        notesService.deleteNotes(id);
        return ResponseEntity.noContent().build();
    }
}
