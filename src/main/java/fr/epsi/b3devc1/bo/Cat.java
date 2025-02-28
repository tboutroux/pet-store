package fr.epsi.b3devc1.bo;

import java.util.Date;

public class Cat extends Animal{

    private String chipId;

    public Cat() {}

    public Cat(Date birth, String color, String chipId) {
        super(birth, color);
        this.chipId = chipId;
    }

    public String getChipId() {
        return chipId;
    }

    public void setChipId(String chipId) {
        this.chipId = chipId;
    }
}
