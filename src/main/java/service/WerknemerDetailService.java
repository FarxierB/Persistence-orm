package service;

import configuration.JPAConfiguration;
import entity.WerknemerDetail;
import repository.WerknemerDetailRepository;

public class WerknemerDetailService {

    private WerknemerDetailRepository werknemerDetailRepository;

    public WerknemerDetailService() {
        this.werknemerDetailRepository = new WerknemerDetailRepository(JPAConfiguration.getEntityManager());
    }

    public WerknemerDetail createGebruikerDetail(WerknemerDetail werknemerDetail){
        return werknemerDetailRepository.createWerknemerDetail(werknemerDetail);
    }



    public WerknemerDetail updateGebruikerDetail(WerknemerDetail werknemerDetail) {
        return werknemerDetailRepository.updateWerknemerDetail(werknemerDetail);
    }

    public WerknemerDetail deleteGebruikerDetail(WerknemerDetail werknemerDetail) {
        return werknemerDetailRepository.deleteWerknemerDetail(werknemerDetail);
    }
}
