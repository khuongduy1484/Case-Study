package com.codegym.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "note")
public class Note {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(min = 2,max = 50)
     private String title;
    @NotNull
    @Size(min = 2,max = 50)
     private String content;
     @ManyToOne
     private NoteType noteType;

    public NoteType getNoteType() {
        return noteType;
    }

    public void setNoteType(NoteType noteType) {
        this.noteType = noteType;
    }

    public Note(){

     }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
