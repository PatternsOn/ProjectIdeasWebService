package com.patternson.projectideas.webservices;

import com.patternson.projectideas.entities.ProjectIdea;
import com.patternson.projectideas.entities.facades.ProjectIdeaFacade;

import javax.ejb.EJB;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("ideas")

public class ProjectIdeasService {

    @EJB
    private ProjectIdeaFacade projectIdeaEJB;
    private List<ProjectIdea> projectIdeas;
    private String newProjectName;
    private String newProjectInfo;

    @GET
    @Path("all")
    @Produces(MediaType.APPLICATION_XML)
    public List<ProjectIdeasDTO> getProjectIdeasDTO() {
        List<ProjectIdeasDTO> projectIdeasDTOS = new ArrayList<ProjectIdeasDTO>();

        for (ProjectIdea projectIdeas : projectIdeaEJB.findAll()) {
            projectIdeasDTOS.add(constructProjectIdeaDTO(projectIdeas));
        }

        return projectIdeasDTOS;
    }

    @GET
    @Path("/{projectID}")
    @Produces(MediaType.APPLICATION_XML)
    public ProjectIdeasDTO getProjectIdeasDTO(@PathParam("projectID") int projectID) {
        ProjectIdeasDTO projectIdeasDTO = new ProjectIdeasDTO();
        projectIdeasDTO.setProjectname(projectIdeaEJB.find(projectID).getProjectname());
        projectIdeasDTO.setProjectinfo(projectIdeaEJB.find(projectID).getProjectinfo());

        return projectIdeasDTO;
    }

    @POST
    @Path("/{name}, {info}")
    public void postProjectIdea(@PathParam("name") String name, @PathParam("info") String info) {
        ProjectIdeasDTO projectIdeasDTO = new ProjectIdeasDTO();
        projectIdeasDTO.setProjectname(name);
        projectIdeasDTO.setProjectinfo(info);
        ProjectIdea p = constructProjectIdea(projectIdeasDTO);


//        ProjectIdea p = new ProjectIdea();
//        p.setProjectname(name);
//        p.setProjectinfo(info);
        projectIdeaEJB.create(p);
        projectIdeas.add(p);
        newProjectInfo = "";
        newProjectInfo = "";

    }

    private ProjectIdeasDTO constructProjectIdeaDTO(ProjectIdea projectIdea) {
        ProjectIdeasDTO projectIdeasDTO = new ProjectIdeasDTO();
        projectIdeasDTO.setProjectinfo(projectIdea.getProjectinfo());
        projectIdeasDTO.setProjectname(projectIdea.getProjectname());

        return projectIdeasDTO;
    }

    private ProjectIdea constructProjectIdea(ProjectIdeasDTO projectIdeasDTO) {
        ProjectIdea p = new ProjectIdea();
        p.setProjectname(projectIdeasDTO.getProjectname());
        p.setProjectinfo(projectIdeasDTO.getProjectinfo());

        return p;
    }
}
