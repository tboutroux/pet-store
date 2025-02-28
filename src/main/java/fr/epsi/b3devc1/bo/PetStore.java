package fr.epsi.b3devc1.bo;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "petstore")
public class PetStore {

    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "manager_name")
    private String managerName;

    @ManyToMany(mappedBy = "petStores")
    private List<Product> products = new ArrayList<>();

    @OneToOne(mappedBy = "petStore")
    private Address address;

    @OneToMany(mappedBy = "petStore")
    private List<Animal> animals = new ArrayList<>();

    public PetStore() {}

    /**
     * Constructor
     * @param name
     * @param managerName
     */
    public PetStore(String name, String managerName) {
        this.name = name;
        this.managerName = managerName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }
}
