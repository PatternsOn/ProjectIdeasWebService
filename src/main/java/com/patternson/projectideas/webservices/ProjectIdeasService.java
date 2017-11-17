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
        System.out.println("Made get all request");
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
        System.out.println("Made get by id request:" + projectID);
        ProjectIdeasDTO projectIdeasDTO = new ProjectIdeasDTO();
        projectIdeasDTO.setProjectname(projectIdeaEJB.find(projectID).getProjectname());
        projectIdeasDTO.setProjectinfo(projectIdeaEJB.find(projectID).getProjectinfo());

        return projectIdeasDTO;
    }

    @DELETE
    @Path("/{projectID}")
    public void deleteProjectIdea(@PathParam("projectID") int projectID) {
        System.out.println("Made delete request for: " + projectID);
        projectIdeaEJB.delete(projectID);
    }

    @POST
    @Path("/{name}, {info}")
    @Consumes(MediaType.APPLICATION_XML)
    public void postProjectIdea(@PathParam("name") String name, @PathParam("info") String info) {
        System.out.println("Made post request with param: " + name + " & " + info);
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
