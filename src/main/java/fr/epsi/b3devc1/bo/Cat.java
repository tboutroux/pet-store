package fr.epsi.b3devc1.bo;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "cat")
public class Cat extends Animal {

    @Column(name = "chip_id") // Ajoute un mapping explicite
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

