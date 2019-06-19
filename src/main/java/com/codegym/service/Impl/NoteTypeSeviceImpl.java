package com.codegym.service.Impl;

import com.codegym.model.Note;
import com.codegym.model.NoteType;
import com.codegym.repository.NoteTypeRepository;
import com.codegym.service.NoteSevice;
import com.codegym.service.NoteTypeSevice;
import org.springframework.beans.factory.annotation.Autowired;

public class NoteTypeSeviceImpl implements NoteTypeSevice {
  @Autowired
  private NoteTypeRepository noteTypeRepository;


    @Override
    public Iterable<NoteType> fillAll() {
        return noteTypeRepository.findAll();
    }

    @Override
    public NoteType findById(Long id) {
        return noteTypeRepository.findOne(id);
    }

    @Override
    public void save(NoteType noteType) {
        noteTypeRepository.save(noteType);

    }

    @Override
    public void delete(Long id) {
        noteTypeRepository.delete(id);

    }
}
