package entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
@Table(name = "Afdeling")
public class Afdeling {

    @Id
    @GeneratedValue
    private int Id;


    private String AfdelingNaam;


    @OneToMany (mappedBy = "afdelingId")
    private List<Werknemer> werknemers = new ArrayList<>();


    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getAfdelingNaam() {
        return AfdelingNaam;
    }

    public void setAfdelingNaam(String afdelingNaam) {
        AfdelingNaam = afdelingNaam;
    }

    public List<Werknemer> getWerknemers() { return Collections.unmodifiableList(werknemers);
    }

    public void setWerknemer(Werknemer werknemer) { werknemers.add(werknemer);}
}
