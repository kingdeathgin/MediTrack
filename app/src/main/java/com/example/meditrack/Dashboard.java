package com.example.meditrack;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.meditrack.HelperClasses.SliderAdapter;

public class Dashboard extends AppCompatActivity {

    ViewPager viewPager;
    LinearLayout dotsLayout;

    SliderAdapter sliderAdapter;
    TextView[] dots;

    Button skip;
    Button nextBtn;
    Button backBtn;
    Button letsGetStarted;
    Animation animation;
    int currentPosition;
    ConstraintLayout dashbaordBackground;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_dashboard);



        viewPager = findViewById(R.id.slider);
        dotsLayout = findViewById(R.id.dots);
        letsGetStarted= findViewById(R.id.get_started_btn);
        nextBtn = findViewById(R.id.next_btn);
        skip = findViewById(R.id.skip_btn);
        backBtn = findViewById(R.id.back_btn);
        dashbaordBackground = findViewById(R.id.dashbaordBackground);

        sliderAdapter = new SliderAdapter(this);

        viewPager.setAdapter(sliderAdapter);

        addDots(0);
        viewPager.addOnPageChangeListener(changeListener);
    }

    public void skip(View view){
        startActivity(new Intent(this, Signup.class));
        finish();
    }

    public void letsGetStarted(View view){
        startActivity(new Intent(this, Signup.class));
        finish();
    }

    public void next(View view){
        viewPager.setCurrentItem(currentPosition + 1);
    }
    public void back(View view){
        viewPager.setCurrentItem(currentPosition - 1);
    }


    private void addDots(int position){

        dots = new TextView[4];
        dotsLayout.removeAllViews();

        for(int i=0; i<dots.length; i++){
            dots[i] = new TextView(this);
            dots[i].setText(Html.fromHtml("&#8213;"));
            dots[i].setTextSize(35);
            dots[i].setLetterSpacing(.1f);


            dotsLayout.addView(dots[i]);
        }

        if(dots.length>0){
            dots[position].setTextColor(getResources().getColor(com.google.android.material.R.color.design_default_color_primary_dark));
        }
    }

    ViewPager.OnPageChangeListener changeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            addDots(position);
            currentPosition = position;

            if(position == 0){
                letsGetStarted.setVisibility(View.INVISIBLE);
                nextBtn.setVisibility(View.VISIBLE);
                skip.setVisibility(View.VISIBLE);
                backBtn.setVisibility(View.INVISIBLE);
                dotsLayout.setVisibility(View.VISIBLE);
                dashbaordBackground.setBackgroundResource(R.drawable.ic_background);

            }
            else if(position == 1){
                letsGetStarted.setVisibility(View.INVISIBLE);
                nextBtn.setVisibility(View.VISIBLE);
                skip.setVisibility(View.VISIBLE);
                backBtn.setVisibility(View.VISIBLE);
                dotsLayout.setVisibility(View.VISIBLE);
                dashbaordBackground.setBackgroundResource(R.drawable.ic_background1);

            }
            else if (position == 2){
                letsGetStarted.setVisibility(View.INVISIBLE);
                nextBtn.setVisibility(View.VISIBLE);
                skip.setVisibility(View.VISIBLE);
                backBtn.setVisibility(View.VISIBLE);
                dotsLayout.setVisibility(View.VISIBLE);
                dashbaordBackground.setBackgroundResource(R.drawable.ic_background2);

            } else {
                animation = AnimationUtils.loadAnimation(Dashboard.this,R.anim.bottom_animation);
                letsGetStarted.setAnimation(animation);
                letsGetStarted.setVisibility(View.VISIBLE);
                nextBtn.setVisibility(View.INVISIBLE);
                skip.setVisibility(View.INVISIBLE);
                backBtn.setVisibility(View.INVISIBLE);
                dotsLayout.setVisibility(View.INVISIBLE);
                dashbaordBackground.setBackgroundResource(R.drawable.ic_background);
            }

        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
}