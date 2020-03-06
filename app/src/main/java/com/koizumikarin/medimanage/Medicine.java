package com.koizumikarin.medimanage;

import io.realm.RealmObject;

public class Medicine extends RealmObject {

    int medicineTime;

    public int getMedicineTime(){return medicineTime;}
    public void setMedicineTime(int medicineTime) { this.medicineTime = medicineTime ;}

}