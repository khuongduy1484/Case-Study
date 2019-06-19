package com.codegym.service.Impl;

import com.codegym.model.Note;
import com.codegym.repository.NoteRepository;
import com.codegym.service.NoteSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class NoteSeviceImpl implements NoteSevice {
    @Autowired
    private NoteRepository noteRepository;
    @Override
    public Page<Note> findAllByTitleContaining(String title, Pageable pageable) {
        return noteRepository.findAllByTitleContaining(title,pageable);
    }

    @Override
    public Page<Note> fillAll(Pageable pageable) {
        return noteRepository.findAll(pageable);
    }

    @Override
    public Note findById(Long id) {
        return noteRepository.findOne(id);
    }

    @Override
    public void save(Note note) {
        noteRepository.save(note);

    }
    @Override
    public void delete(Long id) {
        noteRepository.delete(id);

    }
}
