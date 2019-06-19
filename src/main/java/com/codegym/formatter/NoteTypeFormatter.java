package com.codegym.formatter;

import com.codegym.model.NoteType;
import com.codegym.service.NoteTypeSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;


@Component
public class NoteTypeFormatter implements Formatter<NoteType> {
    private NoteTypeSevice noteTypeSevice;

    @Autowired
    public NoteTypeFormatter (NoteTypeSevice noteTypeSevice){
        this.noteTypeSevice = noteTypeSevice;
    }
    @Override
    public NoteType parse(String text, Locale locale) throws ParseException {
        return noteTypeSevice.findById(Long.parseLong(text));
    }

    @Override
    public String print(NoteType object, Locale locale) {
        return "[" + object.getName() +" , "+ object.getId() + "]";
    }
}
