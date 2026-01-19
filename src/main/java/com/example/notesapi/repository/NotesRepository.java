package com.example.notesapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.notesapi.entity.NotesEntity;

public interface NotesRepository extends JpaRepository<NotesEntity, Long>{
	
}
