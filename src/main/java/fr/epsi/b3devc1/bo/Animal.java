package fr.epsi.b3devc1.bo;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "animal")
@Inheritance(strategy = InheritanceType.JOINED)
public class Animal {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "birth")
    private Date birth;

    @Column(name = "color")
    private String color;

    @ManyToOne
    @JoinColumn(name = "petstore_id")
    private PetStore petStore;

    public Animal() {}

    /**
     * Constructor
     * @param birth
     * @param color
     */
    public Animal(Date birth, String color) {
        this.birth = birth;
        this.color = color;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public PetStore getPetStore() {
        return petStore;
    }

    public void setPetStore(PetStore petStore) {
        this.petStore = petStore;
    }
}
