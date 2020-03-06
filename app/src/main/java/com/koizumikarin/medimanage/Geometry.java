package com.koizumikarin.medimanage;

public class Geometry {
    private static final String TAG = Geometry.class.getSimpleName();
    private final Geometry self = this;

    private Location location;

    public Geometry(Location location) {
        this.location = location;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}