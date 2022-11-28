package entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Rol")
public class Rol {
    @Id
    @GeneratedValue
    private int id;

    private String Rol;

    @ManyToMany (mappedBy = "rollen")
    private List<Werknemer> werknemers = new ArrayList<>();


    public Rol() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRol() {
        return Rol;
    }

    public void setRol(String rol) {
        Rol = rol;
    }

    public List<Werknemer> getWerknemers() {
        return werknemers;
    }

    public void setWerknemers(List<Werknemer> werknemers) {
        this.werknemers = werknemers;
    }
}
