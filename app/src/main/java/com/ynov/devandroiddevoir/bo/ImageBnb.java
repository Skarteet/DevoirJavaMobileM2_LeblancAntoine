package com.ynov.devandroiddevoir.bo;

import java.io.Serializable;

public class ImageBnb implements Serializable {
    String url;

    public ImageBnb(String url) {
        this.url = "https://flutter-learning.mooo.com/"+url;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = "https://flutter-learning.mooo.com/"+url;
    }
}
