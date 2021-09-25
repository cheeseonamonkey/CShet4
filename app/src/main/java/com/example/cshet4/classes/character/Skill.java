package com.example.cshet4.classes.character;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.viewpager2.widget.ViewPager2;

import com.example.cshet4.MainActivity;
import com.example.cshet4.R;
import com.example.cshet4.classes.apiClasses.Reference;

import java.util.ArrayList;
import java.util.List;

public class Skill extends Reference implements createsTabViews
{

    //in super:
    //private String index;
    //private String name;
    //private String url;

    private List<String> desc = new ArrayList<String>();
    private AbilityScore abilityScore;
    public boolean isFavorited = false;


    //todo:
    public int skillValue = 0;


    // objects of list item views
    public CheckBox ckbFavorited;
    public TextView txtName;
    public ImageView imgGrip;
    public TextView txtValue;

    //draw this object
    public LinearLayout linHolder;

    public LinearLayout linLeft;
    public LinearLayout linRight;

    @Override
    public void newViewReferences(Context context)
    {

        ckbFavorited = new CheckBox(context);
        txtName = new TextView(context);
        imgGrip = new ImageView(context);
        txtValue = new TextView(context);

        linHolder = new LinearLayout(context);
        linLeft = new LinearLayout(context);
        linRight = new LinearLayout(context);

        //config each:

        //linHolder
        LinearLayout.LayoutParams linHolderlayoutParams  = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,75);
        linHolder.setOrientation(LinearLayout.HORIZONTAL);
        linHolder.setLayoutParams(linHolderlayoutParams);


        //linLeft
        LinearLayout.LayoutParams linLeftlayoutParams  = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        linLeftlayoutParams.weight = 1f;
   //     linLeft.setBackgroundColor(Color.BLUE); //color for debug
        linLeft.setHorizontalGravity(Gravity.RIGHT);
        linLeft.setVerticalGravity(Gravity.CENTER_VERTICAL);
        //.setOrientation(LinearLayout.HORIZONTAL);
        linLeft.setLayoutParams(linLeftlayoutParams);

        //linRight
        LinearLayout.LayoutParams linRightlayoutParams  = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        linRightlayoutParams.weight = 2.75f;
    //    linRight.setBackgroundColor(Color.RED); //color for debug
        linRight.setHorizontalGravity(Gravity.RIGHT);
        linRight.setVerticalGravity(Gravity.CENTER_VERTICAL);
       // .setOrientation(LinearLayout.HORIZONTAL);
        linRight.setLayoutParams(linRightlayoutParams);

        //ckbFavorite
        LinearLayout.LayoutParams ckbFavoritedlayoutParams  = new LinearLayout.LayoutParams(54,54);
        ckbFavoritedlayoutParams.setMarginStart(2);

        ckbFavorited.setButtonDrawable(R.drawable.emptyimg);

        //todo: with skill favoriting:
        if(this.isFavorited)
        {
            ckbFavorited.setButtonDrawable(R.drawable.favoritestarcheckedicon);
            ckbFavorited.setChecked(true);
        }
       else if( ! this.isFavorited)
        {
            ckbFavorited.setBackgroundResource(R.drawable.favoritestaricon);
            ckbFavorited.setChecked(false);
        }

        ckbFavorited.setTooltipText("Favorite this skill");

        ckbFavorited.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b)
            {
                if(b)
                {
                    compoundButton.setBackgroundResource(R.drawable.favoritestarcheckedicon);
                }else if(! b)
                {
                    compoundButton.setBackgroundResource(R.drawable.favoritestaricon);
                }
            }
        });

        ckbFavorited.setLayoutParams(ckbFavoritedlayoutParams);




        //name
        LinearLayout.LayoutParams txtNamelayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,LinearLayout.LayoutParams.MATCH_PARENT);
        //txtName.setMinWidth();
        txtNamelayoutParams.setMarginStart(7);
        txtName.setTextSize(24f);

        txtName.setText(this.name);

        //todo: better tooltip for desc
        txtName.setTooltipText(desc.get(0));

        txtName.setLayoutParams(txtNamelayoutParams);


        //grip
        LinearLayout.LayoutParams imgGriplayoutParams = new LinearLayout.LayoutParams(45,45);
        imgGriplayoutParams.setMarginEnd(10);

        imgGrip.setImageResource(R.drawable.griphorizontalicon);

        imgGrip.setLayoutParams(imgGriplayoutParams);


        //value
        LinearLayout.LayoutParams txtValuelayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        txtValuelayoutParams.setMarginEnd(7);
        txtValue.setTextSize(29f);
        txtValue.setTypeface(Typeface.DEFAULT_BOLD);

        txtValue.setText(Integer.toString(skillValue));

        txtValue.setLayoutParams(txtValuelayoutParams);


        //nest:

        //go smallest to largest?
        linLeft.addView(ckbFavorited);
        linLeft.addView(txtName);

        linRight.addView(imgGrip);
        linRight.addView(txtValue);

        linHolder.addView(linLeft);
        linHolder.addView(linRight);

        ckbFavorited.setVisibility(View.VISIBLE);
        txtName.setVisibility(View.VISIBLE);
        imgGrip.setVisibility(View.VISIBLE);
        txtValue.setVisibility(View.VISIBLE);

        linHolder.setVisibility(View.VISIBLE);
        linLeft.setVisibility(View.VISIBLE);
        linRight.setVisibility(View.VISIBLE);

    }





    /**
     * No args constructor for use in serialization
     *
     */
    public Skill() {
    }

    public Skill(String index, String name , String url)
    {
        //super();
        this.index = index;
        this.name = name;
        this.url = url;

        isFavorited = false;
    }

    /**
     *
     * @param name - (super)
     * @param index - (super)
     * @param abilityScore
     * @param url - (super)
     * @param desc
     */
    public Skill(String index, String name , String url, List<String> desc, AbilityScore abilityScore) {
        //super();
        this.index = index;
        this.name = name;
        this.url = url;
        //===============

        this.desc = desc;
        this.abilityScore = abilityScore;


    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getDesc() {
        return desc;
    }

    public void setDesc(List<String> desc) {
        this.desc = desc;
    }

    public AbilityScore getAbilityScore() {
        return abilityScore;
    }

    public void setAbilityScore(AbilityScore abilityScore) {
        this.abilityScore = abilityScore;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}