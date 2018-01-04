package com.example.xdd;



public class Trip {
    private String name;
    private String message;
    private  int imageId;
    public Trip(String name,String message,int imageId){
        this.name=name;
        this.imageId=imageId;
        this.message=message;
    }
    public String getName(){
        return name;
    }
    public int getImageId(){
        return imageId;
    }
    public String getDetail(){return message;}
}
