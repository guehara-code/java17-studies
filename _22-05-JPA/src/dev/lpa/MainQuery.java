package dev.lpa;

import dev.lpa.music.Artist;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import java.util.List;

public class MainQuery {

    public static void main(String[] args) {

        List<Artist> artists = null;
        try (EntityManagerFactory emf = Persistence.createEntityManagerFactory(
                "dev.lpa.music");
             EntityManager em = emf.createEntityManager();) {
            var transaction = em.getTransaction();
            transaction.begin();
            artists = getArtistJPQL(em, "");
            artists.forEach(System.out::println);
            transaction.commit();
        }

    }

    private static List<Artist> getArtistJPQL(EntityManager em, String matchedValue) {

        String jpql = "SELECT a FROM Artist a";
        var query = em.createQuery(jpql, Artist.class);
        return query.getResultList();
    }
}
