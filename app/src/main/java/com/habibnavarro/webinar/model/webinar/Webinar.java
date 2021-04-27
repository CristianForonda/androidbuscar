package com.habibnavarro.webinar.model.webinar;

public class Webinar {
    private String id, name, institution, lecturer, date, link;

    public Webinar(String id, String name, String institution, String lecturer, String date, String link) {
        this.setId(id);
        this.setName(name);
        this.setInstitution(institution);
        this.setLecturer(lecturer);
        this.setDate(date);
        this.setLink(link);
    }
    public Webinar(String name, String institution, String lecturer, String date, String link) {
        this.setName(name);
        this.setInstitution(institution);
        this.setLecturer(lecturer);
        this.setDate(date);
        this.setLink(link);
    }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getInstitution() { return institution; }
    public void setInstitution(String institution) { this.institution = institution; }

    public String getLecturer() { return lecturer; }
    public void setLecturer(String lecturer) { this.lecturer = lecturer; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getLink() { return link; }
    public void setLink(String link) { this.link = link; }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
}