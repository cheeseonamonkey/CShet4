package com.example.cshet4.ui.me.meTabFragments.skillsTab;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.cshet4.MainActivity;
import com.example.cshet4.R;
import com.example.cshet4.classes.character.Skill;
import com.example.cshet4.databinding.FragmentMeTabSkillsBinding;

import java.util.HashMap;

public class FragmentMeTabSkills extends Fragment
{


    private FragmentMeTabSkillsViewModel mViewModel;

    private FragmentMeTabSkillsBinding binding;

    public static FragmentMeTabSkills newInstance()
    {
        return new FragmentMeTabSkills();
    }



    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {
        //Inflate the layout for this fragment:
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

        binding = FragmentMeTabSkillsBinding.inflate(getLayoutInflater(), container,false);
        View view=binding.getRoot();
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++


        //definitions
        LinearLayout linOptionsBar = binding.linOptionsBar;
        LinearLayout linSkillsContent = binding.linSkillsContent;

        //listeners:







        binding.btnLoad.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                DrawTab(linSkillsContent);

            }
        });




        //






        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(FragmentMeTabSkillsViewModel.class);

    }




    public void DrawTab(LinearLayout linSkillsContent)
    {
        //if we have the data
        if(MainActivity.dataStore.isApiLoaded)
        {
            //create views
            for (Skill skill : MainActivity.dataStore.character.skills) {
                skill.newViewReferences(getContext());
            }
            //add the views
            for (Skill skill : MainActivity.dataStore.character.skills) {
                linSkillsContent.addView(skill.linHolder);
            }

        }


    }

}