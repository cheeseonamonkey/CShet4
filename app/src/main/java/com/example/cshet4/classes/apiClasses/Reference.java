package com.example.cshet4.classes.apiClasses;

import com.example.cshet4.classes.character.AbilityScore;
import com.example.cshet4.classes.character.Skill;

import java.util.ArrayList;
import java.util.List;

public class Reference
{
    public Reference(String index, String nam, String url)
    {
        this.index = index;
        this.name = nam;
        this.url = url;
    }


    public Reference()
    {}



    public static List<AbilityScore> toAbilityScoreList(List<Reference> list)
    {
        List<AbilityScore> newList = new ArrayList<AbilityScore>();

        for(int i=0; i<list.size(); i++)
        {
            newList.add(new AbilityScore(list.get(i).index, list.get(i).name, list.get(i).url));
        }

        return newList;
    }

    public static List<Skill> toSkillsList(List<Reference> list)
    {
        List<Skill> newList = new ArrayList<Skill>();

        for(int i=0; i<list.size(); i++)
        {
            newList.add(new Skill(list.get(i).index, list.get(i).name, list.get(i).url));
        }

        return newList;
    }



    public String index;

    public String name;

    public String url;
}