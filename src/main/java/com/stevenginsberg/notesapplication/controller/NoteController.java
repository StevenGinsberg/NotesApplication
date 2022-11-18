package com.stevenginsberg.notesapplication.controller;
import com.stevenginsberg.notesapplication.entites.Note;
import com.stevenginsberg.notesapplication.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


public class NoteController {
    @Autowired

    private final NoteService service;



    public NoteController(NoteService service)

    {

        this.service = service;

    }



    @CrossOrigin

    @GetMapping("/getNote/{id}")

    public Note getNote(@PathVariable int id)

    {

        return service.getNoteById(id);

    }



    @CrossOrigin

    @GetMapping("/getAllNotes")

    public List<Note> getAllNotes()

    {

        return service.getAllNotes();

    }



    @CrossOrigin
    @PostMapping("/addNote")

    public Note addNote(HttpServletRequest request)

    {

        Note note = new Note(1,"My Title","Get soy sauce");

        note.setTitle(request.getParameter("title"));

        note.setBody( request.getParameter("body"));

        return service.addNote(note);

    }



    @CrossOrigin

    @PostMapping("/updateNote")

    public void updateNote(HttpServletRequest request)

    {

        Note note = new Note(1,"My titel","Get soy sauce!!");

        note.setId(Integer.parseInt(request.getParameter("id")));

        note.setTitle(request.getParameter("title"));

        note.setBody(request.getParameter("body"));

        service.updateNote(note);

    }



    @CrossOrigin

    @GetMapping("/deleteNote/{id}")

    public void deleteNote(@PathVariable int id)

    {

        service.deleteNote(id);

    }

}

