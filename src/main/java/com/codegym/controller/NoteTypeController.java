package com.codegym.controller;

import com.codegym.model.NoteType;
import com.codegym.service.NoteTypeSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NoteTypeController {
    @Autowired
    private NoteTypeSevice noteTypeSevice;
    @GetMapping("notetype")
    public ModelAndView listNOteType(){
        ModelAndView modelAndView = new ModelAndView("notetypes/list");
        modelAndView.addObject("notetype",noteTypeSevice.fillAll());
        return modelAndView;
    }
    @GetMapping("create-notetype")
    public ModelAndView createNoteType(){
        ModelAndView modelAndView = new ModelAndView("notetypes/create");
        modelAndView.addObject("notetype",new NoteType());
        return modelAndView;
    }
    @PostMapping("create-notetype")
    public String saveNoteType(@ModelAttribute("notetype") NoteType noteType){
        noteTypeSevice.save(noteType);
        return "redirect:notetype";
    }
    @GetMapping("edit-notetype/{id}")
    public ModelAndView editNoteType(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("notetypes/edit");
       modelAndView.addObject("notetype",noteTypeSevice.findById(id));
       return modelAndView;
    }
    @PostMapping("edit-notetype")
    public String updateNoteType(@ModelAttribute("notetype") NoteType noteType){
        noteTypeSevice.save(noteType);
        return "redirect:notetype";
    }
    @GetMapping("delete-notetype/{id}")
    public ModelAndView deleteNoteType(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("notetypes/delete");
        modelAndView.addObject("notetype",noteTypeSevice.findById(id));
        return modelAndView;
    }
    @PostMapping("delete-notetype")
    public String delete(@ModelAttribute("notetype") NoteType noteType){
        noteTypeSevice.delete(noteType.getId());
        return "redirect:notetype";
    }

}
