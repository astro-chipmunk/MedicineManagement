package com.koizumikarin.medimanage;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;
import io.realm.RealmResults;

public class MyCalendar extends AppCompatActivity
        implements AdapterView.OnItemClickListener {

    private TextView titleText;
    private Button prevButton, nextButton;
    private CalendarAdapter mCalendarAdapter;
    private GridView calendarGridView;
    private String currentDate;
    private Realm realm;
    MedicineCalendar medicineCalendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_calendar);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("カレンダー");

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        View header=navigationView.getHeaderView(0);
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    case R.id. nav_medicine_note:
                        Intent intent = new Intent(getApplicationContext(), MedicineNote.class);
                        startActivity(intent);
                        overridePendingTransition(0, 0);
                        break;
                    case R.id.nav_add_medicine:
                        Intent intent1 = new Intent(getApplicationContext(), AddMedicine.class);
                        startActivity(intent1);
                        overridePendingTransition(0, 0);
                        break;
                    case R.id.nav_search_medicine:
                        Intent intent2 = new Intent(getApplicationContext(), SearchMedicine.class);
                        startActivity(intent2);
                        overridePendingTransition(0, 0);
                        break;
                    case R.id.nav_search_hospital:
                        Intent intent3 = new Intent(getApplicationContext(), SearchHospital.class);
                        startActivity(intent3);
                        overridePendingTransition(0, 0);
                        break;
                    case R.id.nav_calendar:
                        Intent intent4 = new Intent(getApplicationContext(), MyCalendar.class);
                        startActivity(intent4);
                        overridePendingTransition(0, 0);
                        break;
                    case R.id.nav_alarm:
                        Intent intent5 = new Intent(getApplicationContext(), Alarm.class);
                        startActivity(intent5);
                        overridePendingTransition(0, 0);
                        break;
                    default:
                        break;
                }
                return false;
            }
        });

        titleText = findViewById(R.id.titleText);
        prevButton = findViewById(R.id.prevButton);
        prevButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCalendarAdapter.prevMonth();
                titleText.setText(mCalendarAdapter.getTitle());
            }
        });
        nextButton = findViewById(R.id.nextButton);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCalendarAdapter.nextMonth();
                titleText.setText(mCalendarAdapter.getTitle());
            }
        });


        calendarGridView = findViewById(R.id.calendarGridView);
        mCalendarAdapter = new CalendarAdapter(this);
        calendarGridView.setAdapter(mCalendarAdapter);
        titleText.setText(mCalendarAdapter.getTitle());

        calendarGridView.setOnItemClickListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my_calendar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
        Realm.init(this);
        Log.d("position", String.valueOf(position));
        Log.d("date", mCalendarAdapter.getItem(position).toString());

        LayoutInflater inflater = (LayoutInflater)this.getSystemService(LAYOUT_INFLATER_SERVICE);
        final View layout = inflater.inflate(R.layout.dialog, (ViewGroup) findViewById(R.id.alertdialog_layout));

        new AlertDialog.Builder(this)
                .setTitle("予定追加")
                .setView(layout)
                .setPositiveButton("登録", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        EditText editText = (EditText) layout.findViewById(R.id.edittext);
                        final Spinner spinner = (Spinner) layout.findViewById(R.id.spinner);
                        final TextView textView = (TextView) findViewById(R.id.event);
                        textView.setText(editText.getText());
                        final Realm realm = Realm.getDefaultInstance();
                        realm.beginTransaction();
                        MedicineCalendar medicineCalendar = realm.createObject(MedicineCalendar.class);
                        medicineCalendar.setEvent(editText.getText().toString());
                        medicineCalendar.setPosition(mCalendarAdapter.getItem(position).toString());
                        Log.d("入ってる？", "onClick: ");
                        realm.commitTransaction();
                    }
                })
                .setNegativeButton("キャンセル", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                    }
                })
                .show();

        final Spinner spinner = (Spinner) layout.findViewById(R.id.spinner);
        final TextView textView = (TextView) findViewById(R.id.event);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            //　アイテムが選択された時
            @Override
            public void onItemSelected(AdapterView<?> parent,
                                       View view, int position, long id) {

                spinner.getItemAtPosition(position);

                if (position == 0){
                    textView.setTextColor(Color.RED);
                }

                if (position == 1){
                    textView.setTextColor(Color.rgb(255, 165, 0));
                }

                if (position == 2){
                    textView.setTextColor(Color.YELLOW);
                }

                if (position == 3){
                    textView.setTextColor(Color.GREEN);
                }

                if (position == 4){
                    textView.setTextColor(Color.BLUE);
                }

                if (position == 5){
                    textView.setTextColor(Color.rgb(128, 0, 128));
                }
            }

            //　アイテムが選択されなかった
            public void onNothingSelected(AdapterView<?> parent) {
                //
            }
        });
    }




}
