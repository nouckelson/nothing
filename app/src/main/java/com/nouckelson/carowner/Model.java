package com.nouckelson.carowner;

public class Model {
    private String owner;
    private String make;
    private  String id;
    private int logo;
    public Model() { }
    public Model(String id,String owner, String make, int logo) {
        this.id=id;
        this.owner = owner;
        this.make = make;
        this.logo = logo;
    }

    public String getId() { return id; }

    public void setId(String id) { this.id = id;}

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public int getLogo() {
        return logo;
    }

    public void setLogo(int logo) {
        this.logo = logo;
    }
}
