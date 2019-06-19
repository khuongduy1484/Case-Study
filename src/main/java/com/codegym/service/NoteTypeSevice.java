package com.codegym.service;

import com.codegym.model.NoteType;

public interface NoteTypeSevice {
    Iterable<NoteType>fillAll();
    NoteType findById(Long id);
    void save(NoteType noteType);
    void delete(Long id);
}
