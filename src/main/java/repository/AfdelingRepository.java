package repository;

import entity.Afdeling;
import entity.Werknemer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;

import java.util.List;

public class AfdelingRepository {
    private EntityManager entityManager;


    public AfdelingRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<Afdeling> getAfdeling() {
        String query = "select a from Afdeling a";
        TypedQuery<Afdeling> typedQuery = entityManager.createQuery(query, Afdeling.class);
        List<Afdeling> dienstList = typedQuery.getResultList();
        return dienstList;
    }

    public Afdeling createAfdeling(Afdeling afdeling){
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(afdeling);
            entityManager.getTransaction().commit();
        }
        catch (Exception e) {
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }

        return afdeling;
    }

    public Afdeling deleteAfdeling(Afdeling afdeling){
        try{
            entityManager.getTransaction().begin();
            entityManager.find(Werknemer.class, afdeling.getId());
            if(afdeling != null)  entityManager.remove(afdeling);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return afdeling;
    }


    public Afdeling updateAfdeling(Afdeling afdeling){
        try{
            entityManager.getTransaction().begin();
            entityManager.find(Werknemer.class, afdeling.getId());
            entityManager.merge(afdeling);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return afdeling;
    }
}
