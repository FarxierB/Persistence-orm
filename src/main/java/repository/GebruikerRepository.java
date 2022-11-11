package repository;

import entity.Gebruiker;
import entity.GebruikerDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class GebruikerRepository {

    private EntityManager entityManager;


    public GebruikerRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Gebruiker> getGebruikers() {
        String query = "select g from Gebruiker g";
        TypedQuery<Gebruiker> typedQuery = entityManager.createQuery(query, Gebruiker.class);
        List<Gebruiker> dienstList = typedQuery.getResultList();
        return dienstList;
    }

    public Gebruiker createGebruiker(Gebruiker gebruiker){
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(gebruiker);
            entityManager.getTransaction().commit();
        }
        catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }

        return gebruiker;
    }

    public Gebruiker deleteGebruiker(Gebruiker gebruiker){
        try{
            entityManager.getTransaction().begin();
            entityManager.find(Gebruiker.class, gebruiker.getId());
            if(gebruiker != null)  entityManager.remove(gebruiker);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return gebruiker;
    }


    public Gebruiker updateGebruiker(Gebruiker gebruiker){
        try{
            entityManager.getTransaction().begin();
/*            String findQuery = "from Gebruiker where id = :gebruiker_id";
            Query query = entityManager.createQuery(findQuery);
            query.setParameter("gebruiker_id", gebruiker.getId());*/
            entityManager.find(Gebruiker.class, gebruiker.getId());
            entityManager.merge(gebruiker);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return gebruiker;
    }


}
