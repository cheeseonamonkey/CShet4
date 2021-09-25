package com.example.cshet4.classes;


import androidx.annotation.NonNull;

import com.example.cshet4.MainActivity;
import com.example.cshet4.classes.apiClasses.GetObject;
import com.example.cshet4.classes.apiClasses.Reference;
import com.example.cshet4.classes.character.AbilityScore;
import com.example.cshet4.classes.character.Character;
import com.example.cshet4.classes.character.Skill;
import com.example.cshet4.databinding.FragmentMoreBinding;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;


public class DataStore
{

    public boolean isApiLoaded = false;

    public Character character;

    public String baseUrl = "https://www.dnd5eapi.co";



    public DataStore()
    {
        character = new Character();


    }


    public int totalApiCalls = 0;

    public void LoadFromAPI(FragmentMoreBinding binding)
    {

        //takes binding for callback / progress bar

        LoadFromAPI_abilityScores(binding);
        LoadFromAPI_skills(binding);





        isApiLoaded = true;

    }




//===================================================================================================================
//        api load abilityScores:                ============================================================================
//===================================================================================================================
    public void LoadFromAPI_abilityScores(FragmentMoreBinding binding)
    {



        MainActivity.log.Log("begin LoadFromApi_abilityScores", "requester");

        OkHttpClient client = new OkHttpClient();



        Request abilityScoreRequest = new Request.Builder().url(baseUrl + "/api/ability-scores").build();

        MainActivity.log.Log("\t\tRequest created for: " + abilityScoreRequest.url(), "requester");
        totalApiCalls ++;


        try {
            client.newCall(abilityScoreRequest).enqueue(new Callback()
            {
                @Override
                public void onFailure(@NonNull Call call, @NonNull IOException e)
                {

                    MainActivity.log.Log("call failed - " + abilityScoreRequest.url() +  " - " + e.toString(), "requester");
                    MainActivity.log.Log("call failed - " + abilityScoreRequest.url() +  " - " + e.toString(), "error");
                }

                @Override
                public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException
                {
                    Gson gson = new Gson();

                    String s =  response.body().string();

                    GetObject getObject = gson.fromJson(s, GetObject.class);

                    List<Reference> refs = getObject.results;

                    character.abilityScores = Reference.toAbilityScoreList(refs);



                    //============================================================
                    //fill out details:

                    try
                    {
                        List<Request> abilityScoreDetailRequests = new ArrayList<>();

                        for(int i=0; i<character.abilityScores.size(); i++)
                        {
                            AbilityScore ref = character.abilityScores.get(i);


                            Request request = new Request.Builder().url(baseUrl + ref.url).build();


                            MainActivity.log.Log("\t\t\tRequest created for: " + request.url().toString(), "requester");
                            totalApiCalls ++;
                            abilityScoreDetailRequests.add(request);


                            client.newCall(request).enqueue(new Callback()
                            {
                                @Override
                                public void onFailure(@NonNull Call call, @NonNull IOException e)
                                {


                                    MainActivity.log.Log("______" + ref.url + "call failed -- " + e.toString(), "requester");
                                }

                                @Override
                                public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException
                                {


                                    Gson gson = new Gson();


                                    try {
                                        //final String s = "{\"index\":\"int\",\"name\":\"INT\",\"full_name\":\"Intelligence\",\"desc\":[\"Intelligence measures mental acuity, accuracy of recall, and the ability to reason.\",\"An Intelligence check comes into play when you need to draw on logic, education, memory, or deductive reasoning. The Arcana, History, Investigation, Nature, and Religion skills reflect aptitude in certain kinds of Intelligence checks.\"],\"skills\":[{\"name\":\"Arcana\",\"index\":\"arcana\",\"url\":\"/api/skills/arcana\"},{\"name\":\"History\",\"index\":\"history\",\"url\":\"/api/skills/history\"},{\"name\":\"Investigation\",\"index\":\"investigation\",\"url\":\"/api/skills/investigation\"},{\"name\":\"Nature\",\"index\":\"nature\",\"url\":\"/api/skills/nature\"},{\"name\":\"Religion\",\"index\":\"religion\",\"url\":\"/api/skills/religion\"}],\"url\":\"/api/ability-scores/int\"}";
                                        final String s = response.body().string();

                                        final AbilityScore newObj = gson.fromJson(s, AbilityScore.class);

                                        ref.setDesc(newObj.getDesc());
                                        ref.setFull_name(newObj.getFull_name());
                                        ref.setSkills(newObj.getSkills());

                                    }catch(Exception eeee)
                                    {
                                        MainActivity.log.Log(eeee.toString(), MyLogger.Priority.High, "error");
                                    }



                                    MainActivity.log.Log("\t\t\t" + ref.url + " loaded.", MyLogger.Priority.High, "requester");
                                    binding.progressBar.setProgress(binding.progressBar.getProgress() + 1);

                                }
                            });
                        }

                        // you are here
                        // yes! ability scores getting loaded. booper button works.
                        // Need to make same thing for skills, copy all this below.


                    }catch(Exception ee)
                    {

                        MainActivity.log.Log("_____" + "call failed -- " + ee.toString(), MyLogger.Priority.High, "requester");
                        MainActivity.log.Log("_____" + "call failed -- " + ee.toString(), MyLogger.Priority.High, "error");
                    }

                    //catagory finished log
                    MainActivity.log.Log("\t\t" + abilityScoreRequest.url() + " loaded.", MyLogger.Priority.High, "requester");
                    binding.progressBar.setProgress(binding.progressBar.getProgress() + 1);
                }
            });
        }catch(Exception ee)
        {
            MainActivity.log.Log("HTTP ERROR - " + ee.toString(), "requester");
            MainActivity.log.Log("HTTP ERROR - " + ee.toString(), "error");
        }






    }



//===================================================================================================================
//        api load skills:                ====================================================================================
//===================================================================================================================
    public void LoadFromAPI_skills(FragmentMoreBinding binding)
    {


        MainActivity.log.Log("begin LoadFromApi_abilityScores", "requester");

        OkHttpClient client = new OkHttpClient();

        Request skillsRequest = new Request.Builder().url(baseUrl + "/api/skills").build();

        MainActivity.log.Log("\t\tRequest created for: " + skillsRequest.url(), "requester");
        totalApiCalls ++;
        try {
            client.newCall(skillsRequest).enqueue(new Callback()
            {
                @Override
                public void onFailure(@NonNull Call call, @NonNull IOException e)
                {

                    MainActivity.log.Log("call failed - " + skillsRequest.url() +  " - " + e.toString(), "requester");
                    MainActivity.log.Log("call failed - " + skillsRequest.url() +  " - " + e.toString(), "error");
                }

                @Override
                public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException
                {
                    Gson gson = new Gson();

                    String s =  response.body().string();

                    GetObject getObject = gson.fromJson(s, GetObject.class);

                    List<Reference> refs = getObject.results;

                    character.skills = Reference.toSkillsList(refs);



                    //============================================================
                    //fill out details:

                    try
                    {
                        List<Request> skillsDetailRequests = new ArrayList<>();

                        for(int i=0; i<character.skills.size(); i++)
                        {
                            Skill ref = character.skills.get(i);


                            Request request = new Request.Builder().url(baseUrl + ref.url).build();


                            MainActivity.log.Log("\t\t\tRequest created for: " + request.url().toString(), "requester");
                            totalApiCalls ++;
                            skillsDetailRequests.add(request);


                            client.newCall(request).enqueue(new Callback()
                            {
                                @Override
                                public void onFailure(@NonNull Call call, @NonNull IOException e)
                                {


                                    MainActivity.log.Log("______" + ref.url + "call failed -- " + e.toString(), "requester");
                                }

                                @Override
                                public void onResponse(@NonNull Call call, @NonNull Response response) throws IOException
                                {


                                    Gson gson = new Gson();


                                    try {

                                        final String s = response.body().string();

                                        final Skill newObj = gson.fromJson(s, Skill.class);

                                        ref.setDesc(newObj.getDesc());
                                        ref.setAbilityScore(newObj.getAbilityScore());


                                    }catch(Exception eeee)
                                    {
                                        MainActivity.log.Log(eeee.toString(), MyLogger.Priority.High, "error");
                                    }



                                    MainActivity.log.Log("\t\t\t" + ref.url + " loaded.", MyLogger.Priority.High, "requester");
                                    binding.progressBar.setProgress(binding.progressBar.getProgress() + 1);
                                }
                            });
                        }



                    }catch(Exception ee)
                    {

                        MainActivity.log.Log("_____" + "call failed -- " + ee.toString(), MyLogger.Priority.High, "requester");
                        MainActivity.log.Log("_____" + "call failed -- " + ee.toString(), MyLogger.Priority.High, "error");
                    }

                    //catagory finished log
                    MainActivity.log.Log("\t\t" + skillsRequest.url() + " loaded.", MyLogger.Priority.High, "requester");
                    binding.progressBar.setProgress(binding.progressBar.getProgress() + 1);
                }
            });
        }catch(Exception ee)
        {
            MainActivity.log.Log("HTTP ERROR - " + ee.toString(), "requester");
            MainActivity.log.Log("HTTP ERROR - " + ee.toString(), "error");
        }





    }









}
