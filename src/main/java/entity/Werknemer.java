package entity;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Werknemer {

    @Id
    @GeneratedValue
    private Long id;
    private String voornaam;
    private String achternaam;
    private String username;
    private String password;

    @OneToOne
    private WerknemerDetail werknemerDetailId;

    @ManyToOne
    @JoinColumn(name = "Afdeling_ID")
    private Afdeling afdelingId;

    @ManyToMany
    @JoinTable(name = "Werknemer_Rol", joinColumns = {@JoinColumn(name = "Werknemer_ID")}, inverseJoinColumns = {@JoinColumn(name = "Rol_ID")})
    private List<Rol> rollen = new ArrayList<>();


    public Werknemer() {
    }

    public Werknemer(Long id, String voornaam, String achternaam, String username, String password) {
        this.id = id;
        this.voornaam = voornaam;
        this.achternaam = achternaam;
        this.username = username;
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public void setVoornaam(String voornaam) {
        this.voornaam = voornaam;
    }

    public String getAchternaam() {
        return achternaam;
    }

    public void setAchternaam(String achternaam) {
        this.achternaam = achternaam;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public WerknemerDetail getWerknemerDetailId() {
        return werknemerDetailId;
    }

    public void setWerknemerDetailId(WerknemerDetail werknemerDetailId) {
        this.werknemerDetailId = werknemerDetailId;
    }

    public Afdeling getAfdelingId() {
        return afdelingId;
    }

    public void setAfdelingId(Afdeling afdelingId) {
        this.afdelingId = afdelingId;
    }

    public List<Rol> getRollen() {
        return rollen;
    }

    public void setRollen(List<Rol> rollen) {
        this.rollen = rollen;
    }
}
