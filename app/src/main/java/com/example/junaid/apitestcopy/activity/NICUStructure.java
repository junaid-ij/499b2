package com.example.junaid.apitestcopy.activity;

/**
 * Created by junaid on 27-Mar-18.
 */

public class NICUStructure {
    private int id;
    private String hname;
    private String hlocation;
    private String  hcontact;
    private String cost;
    private String numofnicu;

    public NICUStructure(int id, String hname, String hlocation, String hcontact, String cost, String numofnicu) {
        this.id = id;
        this.hname = hname;
        this.hlocation = hlocation;
        this.hcontact = hcontact;
        this.cost = cost;
        this.numofnicu = numofnicu;
    }

    public int getId() {
        return id;
    }

    public String getHname() {
        return hname;
    }

    public String getHlocation() {
        return hlocation;
    }

    public String getHcontact() {
        return hcontact;
    }

    public String getCost() {
        return cost;
    }

    public String getNumofnicu() {
        return numofnicu;
    }
}
