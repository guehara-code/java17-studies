package dev.lpa;

import dev.lpa.music.Artist;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class Main {

    public static void main(String[] args) {

        try(var sessionFactory = Persistence.createEntityManagerFactory(
                "dev.lpa.music");
            EntityManager entityManager = sessionFactory.createEntityManager();
        ) {

            var transaction = entityManager.getTransaction();
            transaction.begin();
//            entityManager.persist(new Artist("Muddy Water"));
            Artist artist = entityManager.find(Artist.class, 103);
//            artist.removeDuplicates();
//            Artist artist = new Artist(202, "Muddy Water");
//            artist.addAlbum("The Best of Muddy Waters");
            System.out.println(artist);
//            entityManager.remove(artist);
//            artist.setArtistName("Muddy Waters");
//            entityManager.merge(artist);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
