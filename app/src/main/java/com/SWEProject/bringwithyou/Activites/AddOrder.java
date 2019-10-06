package com.SWEProject.bringwithyou.Activites;

import android.content.Intent;
import android.os.Bundle;

import com.SWEProject.bringwithyou.Fregments.ProfileFragment;
import com.SWEProject.bringwithyou.Fregments.SettingFragment;
import com.SWEProject.bringwithyou.R;
import com.SWEProject.bringwithyou.ui.home.HomeFragment;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import com.bumptech.glide.Glide;

import android.view.View;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import com.google.android.material.navigation.NavigationView;

import androidx.drawerlayout.widget.DrawerLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import android.widget.Button;
import android.content.Intent;


public class AddOrder extends AppCompatActivity {
    private Button btnAddOrder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_order);

        btnAddOrder = (Button) findViewById(R.id.btnAddOrder);
        btnAddOrder.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v){
            }

        });


    }



}