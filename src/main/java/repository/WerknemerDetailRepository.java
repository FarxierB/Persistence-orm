package repository;

import entity.WerknemerDetail;
import jakarta.persistence.EntityManager;

public class WerknemerDetailRepository {

    private EntityManager entityManager;

    public WerknemerDetailRepository(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public WerknemerDetail createWerknemerDetail(WerknemerDetail werknemerDetail) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(werknemerDetail);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return werknemerDetail;
    }



    public WerknemerDetail deleteWerknemerDetail(WerknemerDetail werknemerDetail){
        try{
            entityManager.getTransaction().begin();
            entityManager.find(WerknemerDetail.class, werknemerDetail.getId());
            if(werknemerDetail != null)  entityManager.remove(werknemerDetail);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return werknemerDetail;
    }


    public WerknemerDetail updateWerknemerDetail(WerknemerDetail werknemerDetail){
        try{
            entityManager.getTransaction().begin();
            entityManager.find(WerknemerDetail.class, werknemerDetail.getId());
            entityManager.merge(werknemerDetail);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            e.printStackTrace();
            entityManager.getTransaction().rollback();
        }
        return werknemerDetail;
    }
}
