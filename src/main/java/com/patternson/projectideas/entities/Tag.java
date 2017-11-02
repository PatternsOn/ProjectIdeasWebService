package com.patternson.projectideas.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Tag implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Integer tagid;

    @Column(name="tagname")
    private String tagName;

    @ManyToMany(mappedBy = "")
    private List<ProjectIdea> projectIdeas;

    public Integer getTagid() {
        return tagid;
    }

    public void setTagid(Integer tagid) {
        this.tagid = tagid;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public List<ProjectIdea> getProjectIdeas() {
        return projectIdeas;
    }

    public void setProjectIdeas(List<ProjectIdea> projectIdeas) {
        this.projectIdeas = projectIdeas;
    }
}
