package com.example.notesapi.exception;

public class NotesNotFoundException extends RuntimeException{
	public NotesNotFoundException(String message)
	{
		super(message);
	}
}
