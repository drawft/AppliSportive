package com.example.romain.applisport;

/**
 * Created by Romain on 13/03/2015.
 */
public interface NavDrawerItem {
    public int getId();

    public String getLabel();

    public int getType();

    public boolean isEnabled();

    public boolean updateActionBarTitle();
}