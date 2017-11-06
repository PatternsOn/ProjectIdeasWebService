package com.patternson.projectideas.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class ProjectIdea {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "projectid")
    private Integer projectid;

    @Column(name = "projectname")
    private String projectname;

    @Column(name = "projectinfo")
    private String projectinfo;

    @ManyToMany
    @JoinTable(
            name="project_tag",
            joinColumns = {@JoinColumn(name = "projectid", referencedColumnName = "projectid")},
            inverseJoinColumns = {@JoinColumn(name = "tagid", referencedColumnName = "tagid")}
    )
    private List<Tag> tags;

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public Integer getProjectid() {
        return projectid;
    }

    public void setProjectid(Integer projectid) {
        this.projectid = projectid;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    public String getProjectinfo() {
        return projectinfo;
    }

    public void setProjectinfo(String projectinfo) {
        this.projectinfo = projectinfo;
    }
}
