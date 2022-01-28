package com.ynov.devandroiddevoir.bo;


public class City {
    int id;
    String name;
    ImageBnb pic;

    public int getId() {
        return id;
    }


    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ImageBnb getPic() {
        return pic;
    }

    public void setPic(ImageBnb pic) {
        this.pic = pic;
    }

    public City(int id, String name, ImageBnb pic) {
        this.id = id;
        this.name = name;
        this.pic = pic;
    }

}
