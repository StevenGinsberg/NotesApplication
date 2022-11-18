package com.stevenginsberg.notesapplication.dao;
import java.util.*;
import com.stevenginsberg.notesapplication.entites.Note;
public interface NoteDao {
    Note getNoteById(int id);
    List<Note> getAllNotes();
    Note addNote(Note note);
    void updateNote(Note note);
     void deleteNoteNyI(int id);


    void deleteNoteById(int id);
}
