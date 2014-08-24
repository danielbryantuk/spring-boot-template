package uk.co.taidev.templates.model;

public class Note {

    private Long id;
    private String name;
    private String content;


    public Note(String name, String content) {
        this.name = name;
        this.content = content;
    }


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }
}
