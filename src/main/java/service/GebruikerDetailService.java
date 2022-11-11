package service;

import configuration.JPAConfiguration;
import entity.Gebruiker;
import entity.GebruikerDetail;
import repository.GebruikerDetailRepository;

public class GebruikerDetailService {

    private GebruikerDetailRepository gebruikerDetailRepository;

    public GebruikerDetailService() {
        this.gebruikerDetailRepository = new GebruikerDetailRepository(JPAConfiguration.getEntityManager());
    }

    public GebruikerDetail createGebruikerDetail(GebruikerDetail gebruikerDetail){
        return gebruikerDetailRepository.createGebruikerDetail(gebruikerDetail);
    }



    public GebruikerDetail updateGebruikerDetail(GebruikerDetail gebruikerDetail) {
        return gebruikerDetailRepository.updateGebruikerDetail(gebruikerDetail);
    }

    public GebruikerDetail deleteGebruikerDetail(GebruikerDetail gebruikerDetail) {
        return gebruikerDetailRepository.deleteGebruikerDetail(gebruikerDetail);
    }
}
