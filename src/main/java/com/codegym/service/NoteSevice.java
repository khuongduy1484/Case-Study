package com.codegym.service;

import com.codegym.model.Note;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface NoteSevice {
    Page<Note>findAllByTitleContaining(String title,Pageable pageable);
    Page<Note> fillAll(Pageable pageable);
    Note findById(Long id);
    void save(Note note);
    void delete(Long id);
}
