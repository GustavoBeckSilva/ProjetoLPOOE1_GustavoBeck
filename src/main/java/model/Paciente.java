package model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_paciente")
public class Paciente extends Pessoa {

    @Column(nullable = false)
    private int percentualGordura;

    @Column(nullable = false)
    private int percentualMassaMagra;

    @Column(nullable = false)
    private float peso;

    @Column(nullable = false)
    private float altura;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "paciente")
    private List<ExameDobrasCutaneas> exames;

    @ManyToMany
    @JoinTable(
        name = "tb_paciente_dieta",
        joinColumns = @JoinColumn(name = "paciente_id"),
        inverseJoinColumns = @JoinColumn(name = "dieta_id")
    )
    private List<Dieta> dietas;

    // Construtor
    public Paciente() {
    this.exames = new ArrayList<>(); // Inicializa a lista de exames
    this.dietas = new ArrayList<>(); // Inicializa a lista de dietas
}

    // Getters e Setters
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

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }

    public List<ExameDobrasCutaneas> getExames() {
        return exames;
    }

    public void setExames(List<ExameDobrasCutaneas> exames) {
        this.exames = exames;
    }

    public List<Dieta> getDietas() {
        return dietas;
    }

    public void setDietas(List<Dieta> dietas) {
        this.dietas = dietas;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "percentualGordura=" + percentualGordura +
                ", percentualMassaMagra=" + percentualMassaMagra +
                ", peso=" + peso +
                ", altura=" + altura +
                ", nome='" + getNome() + '\'' +
                '}';
    }
}
