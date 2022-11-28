import entity.Werknemer;
import entity.WerknemerDetail;
import service.WerknemerDetailService;
import service.WerknemerService;

public class Main {

    public static void main(String[] args) {

        WerknemerService werknemerService = new WerknemerService();
        WerknemerDetailService werknemerDetailService = new WerknemerDetailService();

        WerknemerDetail adres1 = new WerknemerDetail();
        adres1.setAdress("Elisabethshof #3");
        adres1.setBankNaam("Republic Bank");
        adres1.setGeboorteDatum("12-12-1992");

        WerknemerDetail personToAdres1 = werknemerDetailService.createGebruikerDetail(adres1);

        Werknemer person1 = new Werknemer();
        person1.setVoornaam("Shaq");
        person1.setAchternaam("O'Neil");
        person1.setUsername("soneil");
        person1.setPassword("########");
        person1.setWerknemerDetailId(personToAdres1);

        werknemerService.createWerknemer(person1);

/*
        person1.setVoornaam("Dhiradj");
        person1.setAchternaam("Bechan");
        werknemerService.createWerknemer(person1);*/
       // gebruikerService.deleteGebruiker(Person1);

        Werknemer werknemer = werknemerService.getWerknemer(person1);

        werknemer.setVoornaam("Dhiradj");
        werknemer.setAchternaam("Bechan");
        werknemerService.createWerknemer(werknemer);
        // gebruikerService.deleteGebruiker(Person1);







        /*List<Gebruiker> gebruikers = gebruikerService.getGebruikers();
        gebruikers.forEach( gebruiker -> {
            System.out.println("Voornaam = " + gebruiker.getVoornaam() + "Achternaam = " + gebruiker.getAchternaam());
        });*/




    }
}
