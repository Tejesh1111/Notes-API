package com.example.notesapi.dto;

import jakarta.validation.constraints.NotBlank;

public class NotesRequestDto {
	@NotBlank(message="Title must not be empty")
	private String title;
	private String content;
	
	public NotesRequestDto()
	{
		
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
}
