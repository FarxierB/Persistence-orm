package service;

import configuration.JPAConfiguration;
import entity.Afdeling;
import repository.AfdelingRepository;

import java.util.List;

public class AfdelingService {


    private final AfdelingRepository repository;

    public AfdelingService() {
        this.repository = new AfdelingRepository(JPAConfiguration.getEntityManager());
    }

    public List<Afdeling> getAfdeling() {
        return repository.getAfdeling();
    }

    public Afdeling createAfdeling(Afdeling afdeling) {
        return repository.createAfdeling(afdeling);
    }

    public  Afdeling updateAfdeling(Afdeling afdeling) { return repository.updateAfdeling(afdeling);}

    public Afdeling deleteAfdeling(Afdeling afdeling) { return repository.deleteAfdeling(afdeling);}
}
