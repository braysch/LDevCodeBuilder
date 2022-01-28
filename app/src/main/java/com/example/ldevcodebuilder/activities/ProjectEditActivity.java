package com.example.ldevcodebuilder.activities;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.ldevcodebuilder.R;
import com.example.ldevcodebuilder.fragments.ConfigFragment;
import com.example.ldevcodebuilder.fragments.InfoFragment;
import com.example.ldevcodebuilder.objects.Project;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ProjectEditActivity extends AppCompatActivity
{
    private Project project;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_project_edit);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_nav);

        // Navigate to different fragments when items are selected

        bottomNavigationView.setOnNavigationItemSelectedListener(menuItem -> {
            menuItem.setChecked(true);

            if (menuItem.getItemId() == R.id.info_item)
            {
                getSupportFragmentManager().beginTransaction()
                        .setReorderingAllowed(true)
                        .replace(R.id.proj_edit_frag_view, InfoFragment.class, null)
                        .commit();
            }

            if (menuItem.getItemId() == R.id.config_item)
            {
                getSupportFragmentManager().beginTransaction()
                        .setReorderingAllowed(true)
                        .replace(R.id.proj_edit_frag_view, ConfigFragment.class, null)
                        .commit();
            }

            return true;
        });

    }
}
