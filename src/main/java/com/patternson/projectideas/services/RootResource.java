package com.patternson.projectideas.services;


import com.patternson.projectideas.backing.ProjectIdeasBean;
import com.patternson.projectideas.entities.ProjectIdea;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class RootResource {
    @Inject
    ProjectIdeasBean projectIdeasBean;

    @GET
    @Path("list")
    public List<ProjectIdea> getProjectIdeas() {
       return projectIdeasBean.getProjectIdeas();
    }
}
