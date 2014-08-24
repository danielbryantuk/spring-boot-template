package uk.co.taidev.templates.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import uk.co.taidev.templates.service.NoteService;
import uk.co.taidev.templates.views.NoteView;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/rest/note")
public class NoteResource {

    @Autowired
    private NoteService noteService;


    @RequestMapping("")
    @ResponseStatus(HttpStatus.OK)
    public List<NoteView> findNotes() {
        return noteService.findNotes().stream()
                .map(n -> new NoteView(n))
                .collect(Collectors.toList());
    }
}
