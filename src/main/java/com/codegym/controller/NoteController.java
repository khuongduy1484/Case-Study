package com.codegym.controller;

import com.codegym.model.Note;
import com.codegym.model.NoteType;
import com.codegym.service.NoteSevice;
import com.codegym.service.NoteTypeSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Optional;

@Controller
public class NoteController {
    @Autowired
    private NoteSevice noteSevice;
    @Autowired
    private NoteTypeSevice noteTypeSevice;
    @ModelAttribute("notetype")
    public Iterable<NoteType> noteTypes(){
        return noteTypeSevice.fillAll();
    }
    @GetMapping("note")
    public ModelAndView listNote(@RequestParam("search")Optional<String> search, @PageableDefault(value = 5)Pageable pageable){
        Page<Note>notes;
        if (search.isPresent()){
            notes = noteSevice.findAllByTitleContaining(search.get(),pageable);
        }else {
            notes = noteSevice.fillAll(pageable);
        }
        ModelAndView modelAndView = new ModelAndView("notes/list");
        modelAndView.addObject("notes",notes);
        return modelAndView;
    }
    @GetMapping("create-note")
    public ModelAndView createNOte(){
        ModelAndView modelAndView = new ModelAndView("notes/create");
        modelAndView.addObject("note",new Note());
        return modelAndView;
    }
    @PostMapping("create-note")
    public String createNote(@ModelAttribute("note") Note note,@RequestParam("create") String creates ) {
        String cancel = "Cancel";
        String create = "Create";
        if (creates.equals(cancel)) {
           return "redirect:note";
        } else {
            noteSevice.save(note);
            return "redirect:note";
        }
    }
    @GetMapping("edit-note/{id}")
    public ModelAndView editNote(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("notes/edit");
        modelAndView.addObject("note",noteSevice.findById(id));
        return modelAndView;
    }
    @PostMapping("edit-note")
    public String updateNote(@ModelAttribute("note") Note note){
        noteSevice.save(note);
        return "redirect:note";
    }
    @GetMapping("delete-note/{id}")
    public ModelAndView deleteNote(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("notes/delete");
        modelAndView.addObject("note",noteSevice.findById(id));
        return modelAndView;
    }
    @PostMapping("delete-note")
    public String deleteNotes(@ModelAttribute("note") Note note){
        noteSevice.delete(note.getId());
        ModelAndView modelAndView = new ModelAndView("notes/delete");
        return "redirect:note";
    }

}
