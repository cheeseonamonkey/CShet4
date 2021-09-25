package com.example.cshet4.ui.me.meTabFragments.attributesTab;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.cshet4.MainActivity;
import com.example.cshet4.R;
import com.example.cshet4.classes.character.AbilityScore;
import com.example.cshet4.classes.character.Skill;
import com.example.cshet4.databinding.FragmentMeTabAttributesBinding;

public class FragmentMeTabAttributes extends Fragment
{

    private FragmentMeTabAttributesViewModel mViewModel;

    private FragmentMeTabAttributesBinding binding;

    public static FragmentMeTabAttributes newInstance()
    {
        return new FragmentMeTabAttributes();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {
        //Inflate the layout for this fragment:
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

        binding = FragmentMeTabAttributesBinding.inflate(getLayoutInflater(), container,false);
        View view=binding.getRoot();

//(old return statement) return inflater.inflate(R.layout.fragment_area, container,false);
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++


//listeners:

        binding.btnAttributeLoad.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                DrawTab(binding.linAttributeContent);
            }
        });







        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(FragmentMeTabAttributesViewModel.class);
        // TODO: Use the ViewModel
    }



    public void DrawTab(LinearLayout linAttributeContent)
    {
        //you are here ?

        //why aren't these loading?

        //just set visibility to be sure.


        //if we have the data
        if(MainActivity.dataStore.isApiLoaded)
        {
            //create views
            for (AbilityScore abs : MainActivity.dataStore.character.abilityScores)
            {
                abs.newViewReferences(getContext());
            }

            //add the views

            for (AbilityScore abs : MainActivity.dataStore.character.abilityScores)
            {
                linAttributeContent.addView(abs.linHolder);
            }


        }


    }

}