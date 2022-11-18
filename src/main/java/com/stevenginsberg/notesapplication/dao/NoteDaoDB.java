package com.stevenginsberg.notesapplication.dao;


import com.stevenginsberg.notesapplication.entites.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import org.springframework.util.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
    public class NoteDaoDB implements NoteDao
    {
        @Autowired
        JdbcTemplate jdbc;

        @Override
        public Note getNoteById(int id) {
            try {

                final String SELECT_NOTE_BY_ID = "SELECT * FROM notes WHERE noteID = ?";

                Note note = jdbc.queryForObject(SELECT_NOTE_BY_ID, new NoteMapper(),id);

                return note;

            } catch (DataAccessException ex)

            {

                return null;

            }


        }

        @Override
        public List<Note> getAllNotes() {
            final String SELECT_ALL_NOTES = "SELECT * FROM notes;";

            List<Note> notes = jdbc.query(SELECT_ALL_NOTES,new NoteMapper());

            return notes;
        }

        @Override
        public Note addNote(Note note) {
            final String INSERT_NOTE = "INSERT INTO notes(title,body) values (?,?);";

            jdbc.update(INSERT_NOTE,note.getTitle(),note.getBody());

            int newID = jdbc.queryForObject("SELECT LAST_INSERT_ID()", Integer.class);

            note.setId(newID);

            return note;
        }

        @Override
        public void updateNote(Note note) {
            final String UPDATE_NOTE = "UPDATE notes SET title = ?, body = ? WHERE noteID = ?";

            jdbc.update(UPDATE_NOTE,

                    note.getTitle(),

                    note.getBody(),

                    note.getId());
        }

        @Override
        public void deleteNoteNyI(int id) {
            final String DELETE_NOTE = "DELETE FROM notes WHERE noteID = ?;";

            jdbc.update(DELETE_NOTE,id);
        }

        @Override
        public void deleteNoteById(int id) {

        }

        public static final class NoteMapper implements RowMapper<Note>

        {

            @Override
            public Note mapRow(ResultSet rs, int index) throws SQLException

            {
                Note note = new Note(rs.getInt("noteID"), rs.getString("title"), rs.getString("body"));

                return note;

            }

        }



    }



