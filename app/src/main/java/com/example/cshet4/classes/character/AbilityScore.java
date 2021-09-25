package com.example.cshet4.classes.character;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.cshet4.R;
import com.example.cshet4.classes.apiClasses.Reference;

import java.util.ArrayList;
import java.util.List;

public class AbilityScore extends Reference implements createsTabViews
{

    //private String index;
    //private String name;
    private String full_name;
    private List<String> desc;
    private List<Reference> skills = new ArrayList<Reference>();
    //private String url;

    public int attributeValue = 0;


    /**
     * No args constructor for use in serialization
     *
     */
    public AbilityScore() {
    }

    public AbilityScore(String index, String name, String url)
    {

        this.index = index;
        this.name = name;
        this.url = url;

        //===============
    }

    /**
     *
     * @param skills
     * @param name - (super)
     * @param index - (super)
     * @param fullName
     * @param url - (super)
     * @param desc
     */
    public AbilityScore(String index, String name, String url, String fullName, List<String> desc, List<Reference> skills) {
        //super();
        this.index = index;
        this.name = name;
        this.url = url;
        //===============

        this.full_name = fullName;
        this.desc = desc;
        this.skills = skills;




    }




    // objects of list item views
    public CheckBox ckbExpanded;
    public TextView txtName;
    public TextView txtValue;

    //draw this object
    public LinearLayout linHolder;

    public LinearLayout linAttribute;
    public LinearLayout linAttributeDetails;

    //linattribute subs
    public LinearLayout linAttributeLeft;
    public LinearLayout linAttributeMiddle;
    public LinearLayout linAttributeRight;


    @Override
    public void newViewReferences(Context context)
    {
        ckbExpanded = new CheckBox(context);
        txtName = new TextView(context);
        txtValue = new TextView(context);

        ckbExpanded.setVisibility(View.VISIBLE);
        txtName.setVisibility(View.VISIBLE);
        txtValue.setVisibility(View.VISIBLE);

        linHolder = new LinearLayout(context);



        linAttribute = new LinearLayout(context);
        linAttributeDetails = new LinearLayout(context);

        linAttributeLeft = new LinearLayout(context);
        linAttributeMiddle = new LinearLayout(context);
        linAttributeRight = new LinearLayout(context);

        linHolder.setVisibility(View.VISIBLE);



        linAttribute.setVisibility(View.VISIBLE);
        linAttributeDetails.setVisibility(View.VISIBLE);

        linAttributeLeft.setVisibility(View.VISIBLE);
        linAttributeMiddle.setVisibility(View.VISIBLE);
        linAttributeRight.setVisibility(View.VISIBLE);


        //linHolder
        LinearLayout.LayoutParams linHolderlayoutParams  = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        linHolder.setOrientation(LinearLayout.VERTICAL);
        linHolder.setLayoutParams(linHolderlayoutParams);


        //linAttribute
        LinearLayout.LayoutParams linAttributelayoutParams  = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);


        linAttribute.setOrientation(LinearLayout.HORIZONTAL);
        linAttribute.setVerticalGravity(Gravity.CENTER_VERTICAL);

        linAttribute.setLayoutParams(linAttributelayoutParams);



        //linAttributeDetails
        LinearLayout.LayoutParams linAttributeDetailslayoutParams  = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        linAttributeDetailslayoutParams.setMargins(8,8,8,8);
        linAttributeDetails.setBackgroundColor(Color.parseColor("#59A68F8F"));

        linAttributeDetails.setLayoutParams(linAttributeDetailslayoutParams);



        //linAttributeLeft
        LinearLayout.LayoutParams linAttributeLeftlayoutParams  = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
        linAttributeLeftlayoutParams.setMargins(2,2,2,2);
        linAttributeLeftlayoutParams.weight = 2;
        linAttributeLeft.setBackgroundColor(Color.parseColor("#59A68F8F"));
        linAttributeLeft.setOrientation(LinearLayout.VERTICAL);

        linAttributeLeft.setVerticalGravity(Gravity.CENTER_VERTICAL);
        linAttributeLeft.setHorizontalGravity(Gravity.START);

        linAttributeLeft.setLayoutParams(linAttributeLeftlayoutParams);

        //linAttributeMiddle
        LinearLayout.LayoutParams linAttributeMiddleLayoutParams  = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
        linAttributeMiddleLayoutParams.setMargins(2,2,2,2);
        linAttributeMiddleLayoutParams.weight = 1;
        linAttributeMiddle.setOrientation(LinearLayout.VERTICAL);

        linAttributeMiddle.setVerticalGravity(Gravity.CENTER_VERTICAL);
        linAttributeMiddle.setHorizontalGravity(Gravity.CENTER);

        linAttributeMiddle.setLayoutParams(linAttributeMiddleLayoutParams);

        //linAttributeRight
        LinearLayout.LayoutParams linAttributeRightLayoutParams  = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
        linAttributeRightLayoutParams.setMargins(2,2,2,2);

        linAttributeRight.setVerticalGravity(Gravity.CENTER_VERTICAL);
        linAttributeRight.setHorizontalGravity(Gravity.END);

        linAttributeRight.setOrientation(LinearLayout.VERTICAL);

        linAttributeRight.setLayoutParams(linAttributeRightLayoutParams);



        //views:
        
        //ckbExpanded
        LinearLayout.LayoutParams ckbExpandedlayoutParams  = new LinearLayout.LayoutParams(61,61);
        ckbExpandedlayoutParams.setMargins(1,1,1,1);

        ckbExpanded.setButtonDrawable(R.drawable.emptyimg);


        ckbExpanded.setBackgroundResource(R.drawable.caretdownicon);



      //  ckbExpanded.setTooltipText("");

        ckbExpanded.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b)
            {
                if(b)
                {
                    compoundButton.setBackgroundResource(R.drawable.caretupicon);
                }else if(! b)
                {
                    compoundButton.setBackgroundResource(R.drawable.caretdownicon);
                }
            }
        });

        ckbExpanded.setLayoutParams(ckbExpandedlayoutParams);





        //txtName
        LinearLayout.LayoutParams txtNamelayoutParams = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        //txtName.setMinWidth();

        txtName.setTextSize(28f);

        txtName.setText(this.name);

        //todo: better tooltip for desc
        //Or just put it in the details linLayout?
        txtName.setTooltipText(desc.get(0));

        txtName.setLayoutParams(txtNamelayoutParams);




        //txtValue
        LinearLayout.LayoutParams txtValuelayoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
        txtValuelayoutParams.setMarginEnd(6);
        txtValuelayoutParams.setMarginStart(2);

        txtValue.setTextSize(30f);
        txtValue.setTypeface(Typeface.DEFAULT_BOLD);

        txtValue.setText(Integer.toString(attributeValue));

        txtValue.setLayoutParams(txtValuelayoutParams);
        
        
        //nest:


        /*

        linAttributeDetails.addView(new TextView(context));
        linAttributeDetails.addView(new TextView(context));
        linAttributeDetails.addView(new TextView(context));

         */

        linAttributeLeft.addView(txtName);
        linAttributeMiddle.addView(txtValue);
        linAttributeRight.addView(ckbExpanded);

        
        linAttribute.addView(linAttributeLeft);
        linAttribute.addView(linAttributeMiddle);
        linAttribute.addView(linAttributeRight);
        
        linHolder.addView(linAttribute);
        linHolder.addView(linAttributeDetails);
        

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

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }

    public List<String> getDesc() {
        return desc;
    }

    public void setDesc(List<String> desc) {
        this.desc = desc;
    }

    public List<Reference> getSkills() {
        return skills;
    }

    public void setSkills(List<Reference> skills) {
        this.skills = skills;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }





}