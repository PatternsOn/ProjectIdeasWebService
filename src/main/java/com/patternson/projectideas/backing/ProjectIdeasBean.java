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

    public List<ProjectIdea> getProjectIdeas() {
        if (projectIdeas == null) {
            projectIdeas = projectIdeaEJB.findAll();
        }
        return projectIdeas;
    }

    public void setProjectIdeas(List<ProjectIdea> projectIdeas) {
        this.projectIdeas = projectIdeas;
    }

    public ProjectIdeaFacade getProjectIdeaEJB() {
        return projectIdeaEJB;
    }

    public void setProjectIdeaEJB(ProjectIdeaFacade projectIdeaEJB) {
        this.projectIdeaEJB = projectIdeaEJB;
    }
}