package com.example.ldevcodebuilder.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ldevcodebuilder.objects.Project;

import java.util.ArrayList;
import com.example.ldevcodebuilder.R;

public class ProjectsAdapter extends RecyclerView.Adapter<ProjectsAdapter.ViewHolder>
{

    private ArrayList<Project> projects;

    public ProjectsAdapter(ArrayList<Project> projects)
    {
        this.projects = projects;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.obj_project, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tv_project_name.setText(projects.get(position).getProjectName());
    }

    @Override
    public int getItemCount() {
        return projects.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder
    {
        private TextView tv_project_name;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);

            tv_project_name = (TextView) itemView.findViewById(R.id.tv_project_name);
        }
    }
}
