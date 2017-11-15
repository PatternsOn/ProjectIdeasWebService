package com.patternson.projectideas.webservices;

import com.patternson.projectideas.entities.ProjectIdea;
import com.patternson.projectideas.entities.facades.ProjectIdeaFacade;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;
import java.util.List;

@Path("ideas")
@Produces(MediaType.APPLICATION_XML)
public class ProjectIdeasListService {

    @EJB
    private ProjectIdeaFacade projectIdeaEJB;

    @GET
    @Path("list")
    public List<ProjectIdeasDTO> getProjectIdeasDTO() {
        List<ProjectIdeasDTO> projectIdeasDTOS = new ArrayList<ProjectIdeasDTO>();

        for (ProjectIdea projectIdeas : projectIdeaEJB.findAll()) {
            projectIdeasDTOS.add(constructProjectIdeaDTO(projectIdeas));
        }

        return projectIdeasDTOS;
    }

    private ProjectIdeasDTO constructProjectIdeaDTO(ProjectIdea projectIdea) {
        ProjectIdeasDTO projectIdeasDTO = new ProjectIdeasDTO();
        projectIdeasDTO.setProjectid(projectIdea.getProjectid());
        projectIdeasDTO.setProjectinfo(projectIdea.getProjectinfo());
        projectIdeasDTO.setProjectname(projectIdea.getProjectname());

        return projectIdeasDTO;
    }
}
