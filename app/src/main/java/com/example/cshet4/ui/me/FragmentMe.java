package com.example.cshet4.ui.me;

import androidx.annotation.IdRes;
import androidx.fragment.app.FragmentContainer;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.NavHost;
import androidx.navigation.NavHostController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.viewpager2.widget.ViewPager2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.cshet4.MainActivity;
import com.example.cshet4.R;
import com.example.cshet4.databinding.FragmentMeBinding;
import com.google.android.material.tabs.TabLayout;

public class FragmentMe extends Fragment
{


    private FragmentMeViewModel mViewModel;

    //binding
    private FragmentMeBinding binding;

    public static FragmentMe newInstance()
    {
        return new FragmentMe();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {

        //Inflate the layout for this fragment:
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

        binding=FragmentMeBinding.inflate(getLayoutInflater(), container,false);

        View view=binding.getRoot();
//return view;  afterassigninglisteners

//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++


        //listeners:





        //nav

        //get fragment first through SupportFragmentManager
        NavHostFragment meNavHostFragment = (NavHostFragment) getChildFragmentManager().findFragmentById(R.id.meTabNav);
        //obtain navcontroller from fragment
        NavController meNavController = meNavHostFragment.getNavController();
        //leave unchained for reference


//meTablayout
        TabLayout meTabLayout = binding.metabLayout;


        meTabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener()
        {
            @Override
            public void onTabSelected(TabLayout.Tab tab)
            {


                switch(tab.getText().toString())
                {



                    case "Skills":

                        Toast.makeText(getContext(), "tab " + tab.getText(), Toast.LENGTH_SHORT).show();

                        meNavController.navigate(R.id.fragmentMeTabSkills);

                        break;

                    case "Attributes":

                        meNavController.navigate(R.id.fragmentMeTabAttributes);
                        break;

                    case "Equipment":
                        meNavController.navigate(R.id.fragmentMeTabEquipment);
                        break;

                    default:

                        break;

                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab)
            {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab)
            {

            }
        });




        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(FragmentMeViewModel.class);
        // TODO: Use the ViewModel
    }

}