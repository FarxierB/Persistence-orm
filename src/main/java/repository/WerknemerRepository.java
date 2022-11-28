package repository;

import entity.Werknemer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.nio.file.StandardWatchEventKinds;
import java.util.List;

public class WerknemerRepository {

    private EntityManager entityManager;


    public WerknemerRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Werknemer> getWerknemers() {
        String query = "select g from Werknemer g";
        TypedQuery<Werknemer> typedQuery = entityManager.createQuery(query, Werknemer.class);
        List<Werknemer> dienstList = typedQuery.getResultList();
        return dienstList;
    }

    public Werknemer createWerknemer(Werknemer werknemer){
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(werknemer);
            entityManager.getTransaction().commit();
        }
        catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }

        return werknemer;
    }

    public Werknemer getWerknemer(Werknemer werknemer){
        String query = "Select w from Werknemer w where w.id = :werknemer_id";
        TypedQuery<Werknemer> typedQuery = entityManager.createQuery(query, Werknemer.class);
        typedQuery.setParameter("werknemer_id", werknemer.getId());
        System.out.println(werknemer.getId() + werknemer.getVoornaam() + werknemer.getAchternaam() + werknemer.getUsername());
        return typedQuery.getSingleResult();
    }

    public Werknemer deleteWerknemer(Werknemer werknemer){
        try{
            entityManager.getTransaction().begin();
            entityManager.find(Werknemer.class, werknemer.getId());
            if(werknemer != null)  entityManager.remove(werknemer);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return werknemer;
    }


    public Werknemer updateWerknemer(Werknemer werknemer){
        try{
            entityManager.getTransaction().begin();
/*            String findQuery = "from Gebruiker where id = :gebruiker_id";
            Query query = entityManager.createQuery(findQuery);
            query.setParameter("gebruiker_id", gebruiker.getId());*/
            entityManager.find(Werknemer.class, werknemer.getId());
            entityManager.merge(werknemer);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return werknemer;
    }


}
