package com.koizumikarin.medimanage;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.TimePicker;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Random;

import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;

public class Alarm extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {

    private TextView textView;
    private Realm realm;
    Medicine medicine;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alarm);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("通知設定");
        Realm.init(this);
//        MedicineTime medicinetime = realm.createObject(MedicineTime.class);
//        medicinetime.setTime(textView.getText().toString());
//        // Realm全体の初期化
//        Realm.init(context);

//        Realm realm = Realm.getDefaultInstance();
//
//        realm.beginTransaction();
//        final MedicineTime managedtime = realm.copyToRealm(medicinetime);
//        realm.commitTransaction();

        textView = findViewById(R.id.timeView);
        textView = findViewById(R.id.timeView2);
        textView = findViewById(R.id.timeView3);
        textView = findViewById(R.id.timeView4);
        textView = findViewById(R.id.timeView5);
        textView = findViewById(R.id.timeView6);
        textView = findViewById(R.id.timeView7);
        textView = findViewById(R.id.timeView8);
        textView = findViewById(R.id.timeView9);

//        Intent intent = getIntent();
//        final int medicineTime = intent.getIntExtra("medicineTime", 0);
//        realm = Realm.getDefaultInstance();
//        RealmResults<Medicine> result = realm.where(Medicine.class).equalTo("medicineTime", medicineTime).findAll();
//        if (medicineTime != 0) {
//            medicine = result.get(0);
//            textView.setText(medicine.getMedicineTime());
//            textView2.setText(medicine.getMedicineTime());
//            textView3.setText(medicine.getMedicineTime());
//            textView4.setText(medicine.getMedicineTime());
//            textView5.setText(medicine.getMedicineTime());
//            textView6.setText(medicine.getMedicineTime());
//            textView7.setText(medicine.getMedicineTime());
//            textView8.setText(medicine.getMedicineTime());
//            textView9.setText(medicine.getMedicineTime());
//        }

        Button buttonTimePicker = findViewById(R.id.button2);
        buttonTimePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment timePicker = new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(), "time picker");
                textView = (TextView) findViewById(R.id.timeView);
//                realm = Realm.getDefaultInstance();
//                medicine.setMedicineTime(Integer.parseInt(textView.getText().toString()));
//                textView.setText(medicine.getMedicineTime());
//                textView.setText(editText.getText());
            }
        });

        Button buttonTimePicker2 = findViewById(R.id.button3);
        buttonTimePicker2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment timePicker = new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(), "time picker");
                textView = (TextView) findViewById(R.id.timeView2);
//                if (medicineTime == 0) {
//                    add();
//                } else {
//                    update();
//                }
            }
        });

        Button buttonTimePicker3 = findViewById(R.id.button4);
        buttonTimePicker3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment timePicker = new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(), "time picker");
                textView = (TextView) findViewById(R.id.timeView3);
//                if (medicineTime == 0) {
//                    add();
//                } else {
//                    update();
//                }
            }
        });

        Button buttonTimePicker4 = findViewById(R.id.button5);
        buttonTimePicker4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment timePicker = new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(), "time picker");
                textView = (TextView) findViewById(R.id.timeView4);
//                if (medicineTime == 0) {
//                    add();
//                } else {
//                    update();
//                }
            }
        });

        Button buttonTimePicker5 = findViewById(R.id.button6);
        buttonTimePicker5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment timePicker = new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(), "time picker");
                textView = (TextView) findViewById(R.id.timeView5);
//                if (medicineTime == 0) {
//                    add();
//                } else {
//                    update();
//                }
            }
        });

        Button buttonTimePicker6 = findViewById(R.id.button7);
        buttonTimePicker6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment timePicker = new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(), "time picker");
                textView = (TextView) findViewById(R.id.timeView6);
//                if (medicineTime == 0) {
//                    add();
//                } else {
//                    update();
//                }
            }
        });

        Button buttonTimePicker7 = findViewById(R.id.button8);
        buttonTimePicker7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment timePicker = new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(), "time picker");
                textView = (TextView) findViewById(R.id.timeView7);
//                if (medicineTime == 0) {
//                    add();
//                } else {
//                    update();
//                }
            }
        });

        Button buttonTimePicker8 = findViewById(R.id.button9);
        buttonTimePicker8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment timePicker = new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(), "time picker");
                textView = (TextView) findViewById(R.id.timeView8);
//                if (medicineTime == 0) {
//                    add();
//                } else {
//                    update();
//                }
            }
        });

        Button buttonTimePicker9 = findViewById(R.id.button10);
        buttonTimePicker9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment timePicker = new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(), "time picker");
                textView = (TextView) findViewById(R.id.timeView9);
//                if (medicineTime == 0) {
//                    add();
//                } else {
//                    update();
//                }
            }
        });

//        public void add() {
//            String createdAtText = android.text.format.DateFormat.format("yyyy-MM-dd-kk-mm-ss", Calendar.getInstance()).toString();
//            Random random = new Random();
//            realm.beginTransaction();
//            Medicine medicine = realm.createObject(Medicine.class); // 新たなオブジェクトを作成
//            medicine.setId(random.nextInt(9999999));
//            medicine.setName(editText1.getText().toString());
//            medicine.setDose(editText2.getText().toString());
//            medicine.setDays(editText3.getText().toString());
//            medicine.setTakePerDay(spinner1.getSelectedItem().toString());
//            Log.d("add:", "add: ");
//            medicine.setTiming(spinner2.getSelectedItem().toString());
//            Log.d("add: ", "add: ");
//            medicine.setTiming(spinner3.getSelectedItem().toString());
//            Log.d("add: ", "add: ");
//            medicine.setTiming(spinner4.getSelectedItem().toString());
//            Log.d("add: ", "add: ");
//            medicine.setCreatedAt(createdAtText);
//            medicine.setResId(R.drawable.ic_launcher);
//            realm.commitTransaction();
//        }
//
//        public void update() {
//            String createdAtText = android.text.format.DateFormat.format("yyyy-MM-dd-kk-mm-ss", Calendar.getInstance()).toString();
//            Random random = new Random();
//            realm.beginTransaction();
//            medicine.setId(random.nextInt(9999999));
//            medicine.setName(editText1.getText().toString());
//            medicine.setDose(editText2.getText().toString());
//            medicine.setDays(editText3.getText().toString());
//            medicine.setTakePerDay(spinner1.getSelectedItem().toString());
//            Log.d("update: ", "update: ");
//            medicine.setTiming(spinner2.getSelectedItem().toString());
//            Log.d("update: ", "update: ");
//            medicine.setTiming(spinner3.getSelectedItem().toString());
//            Log.d("update: ", "update: ");
//            medicine.setTiming(spinner4.getSelectedItem().toString());
//            Log.d("update: ", "update: ");
//            medicine.setCreatedAt(createdAtText);
//            medicine.setResId(R.drawable.ic_launcher);
//            realm.commitTransaction();
//
//            finish();
//
//        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        Switch alarm = (Switch) findViewById(R.id.alarm);
        final Switch sound = (Switch) findViewById(R.id.sound);
        final Switch vibrate = (Switch) findViewById(R.id.vibrate);
        final LinearLayout linearlayout = (LinearLayout) findViewById(R.id.layout3);

        alarm.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (sound.getVisibility() != View.GONE) {
                    sound.setVisibility(View.GONE);
                } else {
                    sound.setVisibility(View.VISIBLE);
                }

                if (vibrate.getVisibility() != View.GONE) {
                    vibrate.setVisibility(View.GONE);
                } else {
                    vibrate.setVisibility(View.VISIBLE);
                }

                if (linearlayout.getVisibility() != View.GONE) {
                    linearlayout.setVisibility(View.GONE);
                } else {
                    linearlayout.setVisibility(View.VISIBLE);
                }
            }
        });

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
        getMenuInflater().inflate(R.menu.alarm, menu);
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

    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, hourOfDay);
        c.set(Calendar.MINUTE, minute);
        c.set(Calendar.SECOND, 0);

        updateTimeText(c);
        startAlarm(c);
    }

    private void updateTimeText(Calendar c) {
        String timeText = "";
        timeText += DateFormat.getTimeInstance(DateFormat.SHORT).format(c.getTime());

        textView.setText(timeText);
    }

    private void startAlarm(Calendar c) {
        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(this, AlarmReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 1, intent, 0);

        if (c.before(Calendar.getInstance())) {
            c.add(Calendar.DATE, 1);
        }

        alarmManager.setExact(AlarmManager.RTC_WAKEUP, c.getTimeInMillis(), pendingIntent);
    }

}
