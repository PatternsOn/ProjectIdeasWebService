package com.patternson.projectideas.backing;


import com.patternson.projectideas.entities.ProjectIdea;
import com.patternson.projectideas.entities.facades.ProjectIdeaFacade;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class ProjectIdeasBean implements Serializable {
    @EJB
    private ProjectIdeaFacade projectIdeaEJB;

    private List<ProjectIdea> projectIdeas;

    private String newProjectName;
    private String newProjectInfo;

    public String getNewProjectName() {
        return newProjectName;
    }

    public void setNewProjectName(String newProjectName) {
        this.newProjectName = newProjectName;
    }

    public String getNewProjectInfo() {
        return newProjectInfo;
    }

    public void setNewProjectInfo(String newProjectInfo) {
        this.newProjectInfo = newProjectInfo;
    }

    public List<ProjectIdea> getProjectIdeas() {
        if (projectIdeas == null) {
            projectIdeas = projectIdeaEJB.findAll();
        }
        return projectIdeas;
    }

    public void newProjectIdea() {
        ProjectIdea p = new ProjectIdea();
        p.setProjectname(newProjectName);
        p.setProjectinfo(newProjectInfo);
        projectIdeaEJB.create(p);
        projectIdeas.add(p);
        newProjectInfo = "";
        newProjectInfo = "";
    }

    public void saveProjectIdea(ProjectIdea p) {
        projectIdeaEJB.edit(p);
    }

    public void setProjectIdeas(List<ProjectIdea> projectIdeas) {
        this.projectIdeas = projectIdeas;
    }



}