
package model;

import jakarta.persistence.*;

@Entity
public class Paciente extends Pessoa{
    private int percentualGordura;
    private int percentualMassaMagra;
    private int peso;
    private float altura;

    public Paciente() {}

    public int getPercentualGordura() {
        return percentualGordura;
    }

    public void setPercentualGordura(int percentualGordura) {
        this.percentualGordura = percentualGordura;
    }

    public int getPercentualMassaMagra() {
        return percentualMassaMagra;
    }

    public void setPercentualMassaMagra(int percentualMassaMagra) {
        this.percentualMassaMagra = percentualMassaMagra;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }
}
