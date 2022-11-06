package com.example.appsantander.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.appsantander.R;
import com.example.appsantander.adapters.MenuItemAdapter;
import com.example.appsantander.ui.MenuItemButton;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MenuActivity extends AppCompatActivity {
    private RecyclerView menuRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        menuRecyclerView = findViewById(R.id.menu_recycler_view);

        Toolbar toolbar = findViewById(R.id.toolbar);
        // using toolbar as ActionBar
        setSupportActionBar(toolbar);

        Objects.requireNonNull(getSupportActionBar()).setDisplayShowTitleEnabled(false);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_close);// set drawable icon
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        List<MenuItemButton> buttons = new ArrayList<>();
        buttons.add(new MenuItemButton("OpenFinance", null, null, "Mais autonomia e as melhores ofertas"));
        buttons.add(new MenuItemButton("Pix", R.drawable.ic_pix, null, "Pague, transfira e receba"));
        buttons.add(new MenuItemButton("Saúde", R.drawable.ic_hand_health, new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MenuActivity.this, HealthSectionActivity.class);
                startActivity(intent);
            }
        }, null));

        menuRecyclerView.setAdapter(new MenuItemAdapter(buttons));
    }
}