package fr.epsi.b3devc1.bo;

import java.util.Date;

public class Fish extends Animal{

    private FishLivEnv fishLivEnv;

    public Fish() {}

    public Fish(Date birth, String color, FishLivEnv fishLivEnv) {
        super(birth, color);
        this.fishLivEnv = fishLivEnv;
    }

    public FishLivEnv getFishLivEnv() {
        return fishLivEnv;
    }

    public void setFishLivEnv(FishLivEnv fishLivEnv) {
        this.fishLivEnv = fishLivEnv;
    }
}
