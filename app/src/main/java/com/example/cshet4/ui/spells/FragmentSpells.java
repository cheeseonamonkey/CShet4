package com.example.cshet4.ui.spells;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cshet4.R;
import com.example.cshet4.databinding.FragmentMeBinding;
import com.example.cshet4.databinding.FragmentSpellsBinding;

public class FragmentSpells extends Fragment
{

    private FragmentSpellsViewModel mViewModel;

    //binding
    private FragmentSpellsBinding binding;

    public static FragmentSpells newInstance()
    {
        return new FragmentSpells();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {
        //Inflate the layout for this fragment:
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

        binding= FragmentSpellsBinding.inflate(getLayoutInflater(), container,false);

        View view=binding.getRoot();
//return view;  afterassigninglisteners

//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++










        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(FragmentSpellsViewModel.class);
        // TODO: Use the ViewModel
    }

}