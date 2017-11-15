package com.patternson.projectideas.webservices;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class ProjectIdeasDTO {

    @XmlElement
    private Integer projectid;

    @XmlElement
    private String projectname;

    @XmlElement
    private String projectinfo;

    public ProjectIdeasDTO() {
    }

    public ProjectIdeasDTO(Integer projectid, String projectname, String projectinfo) {
        this.projectid = projectid;
        this.projectname = projectname;
        this.projectinfo = projectinfo;
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
