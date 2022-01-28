package com.example.ldevcodebuilder.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

import com.example.ldevcodebuilder.R;
import com.example.ldevcodebuilder.adapters.ProjectsAdapter;
import com.example.ldevcodebuilder.dialog.NewProjectDialog;
import com.example.ldevcodebuilder.objects.Project;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    private ArrayList<Project> projects = new ArrayList<Project>();
    private Project targetProject;
    private androidx.recyclerview.widget.RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton newProjectBtn = (FloatingActionButton) findViewById(R.id.new_project_btn);
        newProjectBtn.setOnClickListener(view ->
        {
            openDialog();
        });

        ProjectsAdapter projectsAdapter = new ProjectsAdapter(projects);
        recyclerView = (androidx.recyclerview.widget.RecyclerView) findViewById(R.id.proj_rec_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(projectsAdapter);

    }

    public ArrayList<Project> getProjects()
    {
        return projects;
    }

    public Project getTargetProject() { return targetProject; }

    public void openDialog()
    {
        NewProjectDialog newProjectDialog = new NewProjectDialog();
        newProjectDialog.show(getSupportFragmentManager(), "Bradan");
    }

}