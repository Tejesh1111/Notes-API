package com.example.notesapi.service;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.example.notesapi.dto.NotesRequestDto;
import com.example.notesapi.dto.NotesResponseDto;
import com.example.notesapi.entity.NotesEntity;
import com.example.notesapi.exception.NotesNotFoundException;
import com.example.notesapi.repository.NotesRepository;

@Service
public class NotesServiceImpl implements NotesService {

    @Autowired
    private NotesRepository notesRepository;

    private NotesResponseDto mapToDto(NotesEntity notes) {
        NotesResponseDto dto = new NotesResponseDto();
        dto.setId(notes.getId());
        dto.setTitle(notes.getTitle());
        dto.setContent(notes.getContent());
        dto.setCreatedAt(notes.getCreatedAt());
        return dto;
    }

    @Override
    public NotesResponseDto createNotes(NotesRequestDto dto) {
        NotesEntity notes = new NotesEntity();
        notes.setTitle(dto.getTitle());
        notes.setContent(dto.getContent());
        notes.setCreatedAt(LocalDateTime.now());

        NotesEntity saved = notesRepository.save(notes);
        return mapToDto(saved);
    }

    @Override
    public Page<NotesResponseDto> getAllNotes(int page, int size) {

        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());
        Page<NotesEntity> notesPage = notesRepository.findAll(pageable);

        return notesPage.map(this::mapToDto);
    }

    @Override
    public NotesResponseDto getNotesById(Long id) {
        NotesEntity notes = notesRepository.findById(id)
                .orElseThrow(() -> new NotesNotFoundException("Notes not found with id: " + id));

        return mapToDto(notes);
    }

    @Override
    public NotesResponseDto updateNotes(Long id, NotesRequestDto dto) {
        NotesEntity notes = notesRepository.findById(id)
                .orElseThrow(() -> new NotesNotFoundException("Notes not found with id: " + id));

        notes.setTitle(dto.getTitle());
        notes.setContent(dto.getContent());

        NotesEntity updated = notesRepository.save(notes);
        return mapToDto(updated);
    }

    @Override
    public void deleteNotes(Long id) {
        NotesEntity notes = notesRepository.findById(id)
                .orElseThrow(() -> new NotesNotFoundException("Notes not found with id: " + id));

        notesRepository.delete(notes);
    }
}
