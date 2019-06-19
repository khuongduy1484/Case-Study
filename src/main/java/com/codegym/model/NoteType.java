package com.codegym.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "noteType")
public class NoteType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotEmpty
    @Size(min = 2,max = 50)
    private String name;
    @NotEmpty
    @Size(min = 2,max = 50)
    private String description;
    @OneToMany
    List<Note>notes;

    public List<Note> getNotes() {
        return notes;
    }

    public void setNotes(List<Note> notes) {
        this.notes = notes;
    }

    public NoteType(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
