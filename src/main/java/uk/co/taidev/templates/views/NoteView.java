package uk.co.taidev.templates.views;

import uk.co.taidev.templates.model.Note;

public class NoteView {

    private final Note delegate;


    public NoteView(Note delegate) {
        this.delegate = delegate;
    }


    public Long getId() {
        return delegate.getId();
    }

    public String getName() {
        return delegate.getName();
    }

    public String getContent() {
        return delegate.getContent();
    }
}
