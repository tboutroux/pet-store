package fr.epsi.b3devc1;

import fr.epsi.b3devc1.bo.*;
import fr.epsi.b3devc1.enums.FishLivEnv;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.Calendar;
import java.util.Date;

import static fr.epsi.b3devc1.enums.ProdType.*;
import static fr.epsi.b3devc1.enums.FishLivEnv.*;

public class Main {
    public static void main(String[] args) {

        try(
                EntityManagerFactory emf = Persistence.createEntityManagerFactory("petstore");
                EntityManager em = emf.createEntityManager();
            ) {

            em.getTransaction().begin();

            /// /////////////////////
            // CREATION DES OBJETS //
            /// /////////////////////

            // Création de 3 adresses
            Address address = new Address("1",  "rue de la paix", "75000", "Paris");
            Address address2 = new Address("2",  "rue de la joie", "69000", "Lyon");
            Address address3 = new Address("3",  "rue de la liberté", "13000", "Marseille");

            // Création de 3 nouveaux PetStore
            PetStore petStore = new PetStore("PetStore", "Jean Bon");
            PetStore petStore2 = new PetStore("Maxi Zoo", "Jade Orlesanimaux");
            PetStore petStore3 = new PetStore("Animalis", "Jeanne Animaux");

            // Ajout de produits dans les PetStore
            Product product = new Product("99999", "Croquette pour chien", FOOD,5);
            Product product2 = new Product("88888", "Croquette pour chat", FOOD, 10);
            Product product3 = new Product("77777", "Litière pour chat", CLEANING, 15);
            Product product4 = new Product("66666", "Shampoing pour chien", CLEANING, 20);
            Product product5 = new Product("55555", "Jouet pour chien", ACCESSORY, 25);
            Product product6 = new Product("44444", "Jouet pour chat", ACCESSORY, 30);

            // Ajout d'animaux
            Cat animal = new Cat(getDate(2024, Calendar.JANUARY, 20), "noir", "12345");
            Fish animal2 = new Fish(getDate(2023, Calendar.OCTOBER, 15), "rouge", SEA_WATER);
            Animal animal3 = new Animal(getDate(2025, Calendar.FEBRUARY, 10), "blanc");
            Cat animal4 = new Cat(getDate(2022, Calendar.JUNE, 5), "gris", "23456");
            Fish animal5 = new Fish(getDate(2021, Calendar.MARCH, 30), "bleu", FRESH_WATER);
            Animal animal6 = new Animal(getDate(2020, Calendar.SEPTEMBER, 12), "marron");

            /// //////////////////////////////////////////
            // AJOUT DES OBJETS DANS LA BASE DE DONNEES //
            /// //////////////////////////////////////////

            // Ajout des adresses aux PetStore
            petStore.setAddress(address);
            petStore2.setAddress(address2);
            petStore3.setAddress(address3);

            // Ajout des PetStore aux adresses
            address.setPetStore(petStore);
            address2.setPetStore(petStore2);
            address3.setPetStore(petStore3);

            // Ajout des produits aux PetStore
            petStore.addProduct(product);
            petStore2.addProduct(product2);
            petStore2.addProduct(product3);
            petStore3.addProduct(product4);
            petStore3.addProduct(product5);
            petStore.addProduct(product6);

            // Ajout des animaux aux PetStore
            petStore.addAnimal(animal);
            petStore2.addAnimal(animal2);
            petStore2.addAnimal(animal3);
            petStore3.addAnimal(animal4);
            petStore3.addAnimal(animal5);
            petStore.addAnimal(animal6);

            // Ajout des produits à la base de données
            em.persist(product);
            em.persist(product2);
            em.persist(product3);
            em.persist(product4);
            em.persist(product5);
            em.persist(product6);

            // Insertion des adresses dans la base de données
            em.persist(address);
            em.persist(address2);
            em.persist(address3);

            // Ajout des PetStore à la base de données
            em.persist(petStore);
            em.persist(petStore2);
            em.persist(petStore3);

            // Ajout des animaux à la base de données
            em.persist(animal);
            em.persist(animal2);
            em.persist(animal3);
            em.persist(animal4);
            em.persist(animal5);
            em.persist(animal6);

            /// //////////////////////////////////////////////
            // EXTRACTION DE TOUS LES ANIMAUX D'UN PETSTORE //
            /// //////////////////////////////////////////////

            // Récupération de tous les animaux du PetStore
            PetStore petStore4 = em.find(PetStore.class, 1L);

            // Affichage des animaux du PetStore
            System.out.println("Animaux du PetStore " + petStore4.getName() + " :");

            for (Animal a : petStore4.getAnimals()) {
                System.out.println(a);
            }

            em.getTransaction().commit();

        }

    }

    /**
     * Créer une date
     * @param year
     * @param month
     * @param day
     * @return Date
     */
    private static Date getDate(int year, int month, int day) {

        // Création d'une instance de Calendar
        Calendar calendar = Calendar.getInstance();

        // Initialisation de la date
        calendar.set(year, month, day, 0, 0, 0);

        // Retourne la date
        return calendar.getTime();
    }
}