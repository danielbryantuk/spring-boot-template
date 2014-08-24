package uk.co.taidev.templates.service;

import org.springframework.stereotype.Service;
import uk.co.taidev.templates.model.Note;

import java.util.Arrays;
import java.util.List;

@Service
public class NoteService {

    public List<Note> findNotes() {
        return Arrays.asList(
                new Note("first note", "real important stuff"),
                new Note("second note", "Not quite as important content")
        );
    }
}
