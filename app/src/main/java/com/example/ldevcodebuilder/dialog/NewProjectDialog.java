package com.example.ldevcodebuilder.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;

import com.example.ldevcodebuilder.activities.MainActivity;
import com.example.ldevcodebuilder.activities.ProjectEditActivity;
import com.example.ldevcodebuilder.objects.Project;
import com.example.ldevcodebuilder.activities.MainActivity;
import com.example.ldevcodebuilder.R;

import java.io.Serializable;
import java.util.ArrayList;

public class NewProjectDialog extends AppCompatDialogFragment implements Serializable
{

    private EditText projectName;
    private EditText projectDescription;
    private ArrayList<Project> projects;
    private Project targetProject;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState)
    {
        projects = ((MainActivity)getActivity()).getProjects();

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dialog_new_project, null);

        projectName = view.findViewById(R.id.project_name);
        projectDescription = view.findViewById(R.id.project_description);

        builder.setView(view)
                .setTitle("New Project")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {

                    }
                })
                .setPositiveButton("Create Project", new DialogInterface.OnClickListener()
                {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i)
                    {
                        String pn = projectName.getText().toString();
                        String pd = projectDescription.getText().toString();
                        Project project = new Project(pn, pd);
                        projects.add(project);
                        targetProject = project;

                        Intent intent = new Intent(getActivity(), ProjectEditActivity.class);
                        //intent.putExtra("Project", (Parcelable) project);
                        startActivity(intent);
                    }
                });
        return builder.create();
    }
}