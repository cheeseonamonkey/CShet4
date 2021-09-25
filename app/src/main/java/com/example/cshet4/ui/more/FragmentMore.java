package com.example.cshet4.ui.more;

import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;

import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cshet4.MainActivity;
import com.example.cshet4.R;
import com.example.cshet4.classes.DataStore;
import com.example.cshet4.databinding.FragmentMoreBinding;
import com.example.cshet4.databinding.FragmentSpellsBinding;

public class FragmentMore extends Fragment
{

    private FragmentMoreViewModel mViewModel;

    private FragmentMoreBinding binding;

    public static FragmentMore newInstance()
    {
        return new FragmentMore();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {
        //Inflate the layout for this fragment:
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

        binding = FragmentMoreBinding.inflate(getLayoutInflater(), container,false);

        View view = binding.getRoot();
//return view;  afterassigninglisteners

//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++





        // Button btnLoadFromAPI
        Button btnLoadFromApi = binding.btnLoadFromApi;

        btnLoadFromApi.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                MainActivity.dataStore.LoadFromAPI(binding);
            }
        });




        //Spinner (log now) spnBoop
       Spinner spnLogNow = (Spinner) binding.spnLogNow;

       spnLogNow.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
       {
           @Override
           public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l)
           {
               String strSelectedItem = adapterView.getItemAtPosition(i).toString();

               switch (strSelectedItem)
               {
                   case "Log now":

                       break;

                   case "Total number of requests":
                        MainActivity.log.Log("Total number of API requests: " + MainActivity.dataStore.totalApiCalls + "", "main");
                                   adapterView.setSelection(0);

                       break;

                   case "aaaa":

                       adapterView.setSelection(0);
                       break;

                   case "aaaaa":

                       adapterView.setSelection(0);
                       break;




                   default:
                       Toast.makeText(getContext(), "Error: '" + strSelectedItem + "' not found", Toast.LENGTH_SHORT).show();
                       MainActivity.log.Log("Error in FragmentMore > spnLogNow > item selected - '" + strSelectedItem + "' not found", "error");
                       break;
               }

           }

           @Override
           public void onNothingSelected(AdapterView<?> adapterView)
           {

           }
       });



       //Button btnLog
        Button btnLog = binding.btnLog;
/*
        btnLog.setOnClickListener(new View.OnClickListener()
        {

            @Override
            public void onClick(View view)
            {
                try
                {
                    TextView textView = new TextView(getContext());
                    textView.setInputType(InputType.TYPE_TEXT_FLAG_MULTI_LINE);
                    textView.setText("asdfasdfasasdfasdfasdf");

                    LinearLayout.LayoutParams layoutparams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
                    layoutparams.weight = 1;
                    textView.setLayoutParams(layoutparams);

                    ((LinearLayout)view.getParent().getParent()).addView(textView);

                }catch (Exception exc)
                {
                    MainActivity.log.LogGeneralError();
                }
            }
        });
*/







        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState)
    {
        super.onActivityCreated(savedInstanceState);
        mViewModel = new ViewModelProvider(this).get(FragmentMoreViewModel.class);
        // TODO: Use the ViewModel
    }

}