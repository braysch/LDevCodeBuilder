package com.example.ldevcodebuilder.objects;

public class Project
{
    private String projectName;
    private String projectDescription;
    private int lastModified;

    public Project(String projectName)
    {
        this.projectName = projectName;
        this.projectDescription = "";
    }

    public Project(String projectName, String projectDescription)
    {
        this.projectName = projectName;
        this.projectDescription = projectDescription;
    }

    public String getProjectName()
    {
        return this.projectName;
    }

}
