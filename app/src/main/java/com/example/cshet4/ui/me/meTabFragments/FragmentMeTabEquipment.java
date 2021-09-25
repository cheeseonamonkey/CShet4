package com.example.cshet4.ui.me.meTabFragments;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cshet4.R;

public class FragmentMeTabEquipment extends Fragment
{

    private FragmentMeTabEquipmentViewModel mViewModel;

    public static FragmentMeTabEquipment newInstance()
    {
        return new FragmentMeTabEquipment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_me_tab_equipment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(FragmentMeTabEquipmentViewModel.class);
        // TODO: Use the ViewModel
    }

}