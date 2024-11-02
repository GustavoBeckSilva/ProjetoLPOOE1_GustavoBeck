
package model;

import jakarta.persistence.*;

@Entity
public class Nutricionista extends Pessoa{
    private String registroProfissional;

    public Nutricionista() {}

    public String getRegistroProfissional() {
        return registroProfissional;
    }

    public void setRegistroProfissional(String registroProfissional) {
        this.registroProfissional = registroProfissional;
    }
}
