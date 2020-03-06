package com.koizumikarin.medimanage;

import java.util.Date;

import io.realm.RealmObject;

public class MedicineCalendar extends RealmObject {

    String event;
    String position;

    public String getEvent(){return event;}
    public void setEvent(String event) { this.event = event ;}

    public String getPosition(Date date){return position;}
    public void setPosition(String position) { this.position = position;}

}