package com.example.hwk_no_due;

public class AnimalImage {
    private int resource;
    private String name;
    private int numberImage;
    private boolean check;

    public AnimalImage(int resource, String name, int numberImage, boolean check) {
        this.resource = resource;
        this.name = name;
        this.numberImage = numberImage;
        this.check = check;
    }

    public int getResource() {
        return resource;
    }

    public void setResource(int resource) {
        this.resource = resource;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumberImage() {
        return numberImage;
    }

    public void setNumberImage(int numberImage) {
        this.numberImage = numberImage;
    }

    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }
}
