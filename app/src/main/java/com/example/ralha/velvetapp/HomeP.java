package com.example.ralha.velvetapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.os.Bundle;
import com.roughike.bottombar.BottomBar;
import com.roughike.bottombar.OnMenuTabClickListener;

import android.view.Menu;


public class HomeP extends AccountActivity {

    // private ImageView Account = findViewById(R.id.Account);
    // private ImageView Lend = findViewById(R.id.lend);
    // private ImageView love = findViewById(R.id.love);
    // private ImageView bag = findViewById(R.id.bag);
    //  private ImageView orders = findViewById(R.id.orders);
//    private ImageView search = findViewById(R.id.search);
    //NEW
    public ImageView imageView2;
    // BottomBar BB;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page2);
//        super.onCreate(savedInstanceState);
        //      setContentView(R.layout.activity_home_page);
        //Account.setOnClickListener((View.OnClickListener) this);
        //Lend.setOnClickListener((View.OnClickListener) this);
        //love.setOnClickListener((View.OnClickListener) this);
        //bag.setOnClickListener((View.OnClickListener) this);
        //orders.setOnClickListener((View.OnClickListener) this);
        //search.setOnClickListener((View.OnClickListener) this);
        //NEW
        imageView2 = findViewById(R.id.imageView2);
//        imageView2.setOnClickListener(this);
        //NEW
        //BB=BottomBar.attach(this,savedInstanceState);
        //    BB.setOnClickListener(this);
    /*    BB.setItemsFromMenu(R.menu.menu_nevagation, new OnMenuTabClickListener() {
            @Override
            public void OnMenuTabSelected(int i)
            {
                // FOR FRIST ITEM
                if(i ==R.id.bbione) {
                  //  ProfileActivity P = new ProfileActivity();
                   // getSupportFragmentManager().beginTransaction().replace(R.id.frame,P).commit();
                }// CLOSE IF CONDETION

                // FOR  SECOND ITEM
                if(i ==R.id.bbiTwo) {
                 //  ProfileActivity P = new ProfileActivity();
                 //   getSupportFragmentManager().beginTransaction().replace(R.id.frame,P).commit();
                }// CLOSE IF CONDETION

                // FOR 3th ITEM
                if(i ==R.id.bbithree) {
                   // ProfileActivity P = new ProfileActivity();
                   // getSupportFragmentManager().beginTransaction().replace(R.id.frame,P).commit();
                }// CLOSE IF CONDETION

                // FOR 4th ITEM
                if(i ==R.id.bbifore) {
                  //  ProfileActivity P = new ProfileActivity();
                   // getSupportFragmentManager().beginTransaction().replace(R.id.frame,P).commit();
                }// CLOSE IF CONDETION

                // FOR 5th ITEM
                if(i ==R.id.bbifive) {
                  //  ProfileActivity P = new ProfileActivity();
                   // getSupportFragmentManager().beginTransaction().replace(R.id.frame,P).commit();
                }// CLOSE IF CONDETION

            }// CLOSE  OnMenuTabSelected

            @Override
            public void OnMenuTabReSelected( int i)
            {

            }// CLOSE OnMenuTabReSelected
        }); */

        /*
        /ADD COLOR TO THE BUTTON
         */
       /* BB.mapColorForTab(0,"#F44336");
        BB.mapColorForTab(1,"#F44336");
        BB.mapColorForTab(2,"#F44336");
        BB.mapColorForTab(3,"#F44336");
        BB.mapColorForTab(4,"#F44336");
        */
        //  }

  /*  public void onClick(ImageView imgView) {
    /*    if (imgView == Account){
            startActivity(new Intent(getApplicationContext(), AccountActivity.class));
        }
        if (imgView == Lend){
            startActivity(new Intent(getApplicationContext(), Fill_leanding.class));
        }
        if ( imgView == love){
            startActivity(new Intent(getApplicationContext(), AccountActivity.class));
        }
        if (imgView == bag){
            startActivity(new Intent(getApplicationContext(), AccountActivity.class));
        }
        if (imgView == orders){
            startActivity(new Intent(getApplicationContext(), AccountActivity.class));
        }

        if(imgView == search){
            startActivity(new Intent(getApplicationContext(), SearchBarActivity.class));
        } */


        // if (imgView == imageView2) {
        //    startActivity(new Intent(getApplicationContext(), Fill_leanding.class));
        //  }

/*        if(v.getId()== R.id.imageView2)
        {
           Fill_leanding FL =Fill_Leanding();
            ma.AddItem();
        }
        }
        */
    }
}//END OF CLASS
