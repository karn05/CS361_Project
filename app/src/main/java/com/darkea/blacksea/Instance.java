package com.darkea.blacksea;

public class Instance {
    private String Name;
    private String Bio;
    private int id;

    public String getName(){
        return Name;
    }
    public String getBio(){
        return Bio;
    }
    public int getId(){
        return id;
    }

    public void setName(String namaiwa){
        this.Name = namaiwa;
    }
    public void setId(int id){
        this.id = id;
    }

    public Instance(String Name, String Bio) {
        this.Name = Name;
        this.Bio = Bio;
    }

}
