import entity.Gebruiker;
import entity.GebruikerDetail;
import jakarta.persistence.Query;
import service.GebruikerDetailService;
import service.GebruikerService;

public class Main {

    public static void main(String[] args) {

        GebruikerService gebruikerService = new GebruikerService();
        GebruikerDetailService gebruikerDetailService = new GebruikerDetailService();

        GebruikerDetail adres1 = new GebruikerDetail();
        adres1.setAdress("Elisabethshof #3");
        adres1.setBankNaam("Republic Bank");
        adres1.setGeboorteDatum("12-12-1992");

        GebruikerDetail personToAdres1 = gebruikerDetailService.createGebruikerDetail(adres1);

        Gebruiker person1 = new Gebruiker();
        person1.setVoornaam("Shaq");
        person1.setAchternaam("O'Neil");
        person1.setUsername("soneil");
        person1.setPassword("########");
        person1.setGebruikerDetailId(personToAdres1);

        gebruikerService.createGebruiker(person1);


        person1.setVoornaam("Dhiradj");
        person1.setAchternaam("Bechan");
        gebruikerService.updateGebruiker(person1);
       // gebruikerService.deleteGebruiker(Person1);










        /*List<Gebruiker> gebruikers = gebruikerService.getGebruikers();
        gebruikers.forEach( gebruiker -> {
            System.out.println("Voornaam = " + gebruiker.getVoornaam() + "Achternaam = " + gebruiker.getAchternaam());
        });*/




    }
}
