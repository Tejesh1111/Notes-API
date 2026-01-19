package com.example.notesapi.service;


import org.springframework.data.domain.Page;

import com.example.notesapi.dto.NotesRequestDto;
import com.example.notesapi.dto.NotesResponseDto;


public interface NotesService {
	NotesResponseDto createNotes(NotesRequestDto dto);
	Page<NotesResponseDto> getAllNotes(int page,int size);
	NotesResponseDto getNotesById(Long id);
	NotesResponseDto updateNotes(Long id,NotesRequestDto dto);
	void deleteNotes(Long id);
}
