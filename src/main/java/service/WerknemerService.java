package service;

import configuration.JPAConfiguration;
import entity.Werknemer;
import repository.WerknemerRepository;

import java.util.List;

public class WerknemerService {

    private final WerknemerRepository repository;

    public WerknemerService() {
        this.repository = new WerknemerRepository(JPAConfiguration.getEntityManager());
    }

    public List<Werknemer> getWerknemers() {
        return repository.getWerknemers();
    }

    public Werknemer getWerknemer(Werknemer werknemer){return repository.getWerknemer(werknemer);}

    public Werknemer createWerknemer(Werknemer werknemer) {
        return repository.createWerknemer(werknemer);
    }

    public Werknemer updateWerknemer(Werknemer werknemer) { return repository.updateWerknemer(werknemer);}

    public Werknemer deleteWerknemer(Werknemer werknemer) { return repository.deleteWerknemer(werknemer);}
}
