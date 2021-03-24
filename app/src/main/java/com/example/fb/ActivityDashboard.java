package com.example.fb;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.example.fb.ActionActivities.ActionCart;
import com.example.fb.ActionActivities.ActionFavorite;


public class ActivityDashboard extends AppCompatActivity {

    Toolbar App_toolbar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);

        //initialize the the toolbar here
        App_toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(App_toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false); // hide the current title from the Toolbar

        }

    // Menu icons are inflated just as they were with actionbar
    // Inflate the menu; this adds items to the action bar if it is present.
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.toolbar, menu);

            // Associate searchable configuration with the SearchView
            SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
            SearchView searchView = (SearchView) menu.findItem(R.id.search_view).getActionView();
            searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));

            return super.onCreateOptionsMenu(menu);
        }

        //event listeners for favorite, cart and help
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id){
            case R.id.favorite:
                Intent intent = new Intent(this, ActionFavorite.class);
                startActivity(intent);
                break;
            case R.id.cart:
                Intent cartIntent = new Intent(this, ActionCart.class);
                startActivity(cartIntent);
        }
        return super.onOptionsItemSelected(item);
    }
}