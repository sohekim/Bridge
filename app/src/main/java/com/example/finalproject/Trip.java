package com.example.finalproject;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Trip {

    private LinearLayout linearLayout;

    public String place, time, numItems, info;

    public Trip(String place, String time, String numItems, String info) {
        this.place = place;
        this.time = time;
        this.numItems = numItems;
        this.info = info;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getNumItems() {
        return numItems;
    }

    public void setNumItems(String numItems) {
        this.numItems = numItems;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
}
