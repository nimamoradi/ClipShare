package com.nimamoradi.clipshare;

import android.net.Uri;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.widget.MediaController;
import android.widget.VideoView;
import android.app.Activity;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.Date;

public class firstpad extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainlayout);

        ListView     listView = (ListView) findViewById(R.id.list);
        mylistview adapter = new mylistview(this, R.layout.customlistveiewcomoment);
        for (int i = 0; i < 20; i++) {
            adoptor_compoment clip = new adoptor_compoment("item : " + i);
            clip.movie_relese_date = (new Date(9000000000l*i) {
                @Override
                public String toString() {
                    return super.toGMTString().replace("GMT", "");
                }
            }).toString();


            adapter.add(clip);
        }
       listView.setAdapter(adapter);

        silder();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);


    }

    private void silder() {
        ViewPager pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(new adptor(getSupportFragmentManager()));

        new DrawerBuilder().withActivity(this).build();
    }

}
