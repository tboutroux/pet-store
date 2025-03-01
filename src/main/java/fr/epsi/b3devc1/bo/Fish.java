package fr.epsi.b3devc1.bo;

import fr.epsi.b3devc1.enums.FishLivEnv;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "fish")
public class Fish extends Animal{

    @Column(name = "fish_liv_env")
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
