package com.stevenginsberg.notesapplication.service;


import com.stevenginsberg.notesapplication.dao.NoteDao;
import com.stevenginsberg.notesapplication.entites.Note;
        import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class NoteService

{

    @Autowired

    NoteDao noteDao;





    public Note getNoteById(int id)

    {

        return noteDao.getNoteById(id);

    }



    public List<Note> getAllNotes()

    {

        return noteDao.getAllNotes();

    }



    public Note addNote(Note note)

    {

        return noteDao.addNote(note);

    }



    public void updateNote(Note note)

    {

        noteDao.updateNote(note);

    }



    public void deleteNote(int id)

    {

        noteDao.deleteNoteById(id);

    }



}

