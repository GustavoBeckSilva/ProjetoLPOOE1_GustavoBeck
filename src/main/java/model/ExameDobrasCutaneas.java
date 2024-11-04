package model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_exameDobrasCutaneas")
public class ExameDobrasCutaneas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private float triceps;
    private float peito;
    private float subaxilar;
    private float subescapular;
    private float abdominal;
    private float supraliliaca;
    private float coxa;
    private int idade;
    private float percentualGordura;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)  // A relação é obrigatória
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "nutricionista_id", nullable = false)  // Adicionando a anotação ManyToOne
    private Nutricionista nutricionista;

    // Getters e Setters
    public int getId() {
        return id;  // Alterado para int
    }

    public void setId(int id) {  // Alterado para int
        this.id = id;
    }

    public float getTriceps() {
        return triceps;
    }

    public void setTriceps(float triceps) {
        this.triceps = triceps;
    }

    public float getPeito() {
        return peito;
    }

    public void setPeito(float peito) {
        this.peito = peito;
    }

    public float getSubaxilar() {
        return subaxilar;
    }

    public void setSubaxilar(float subaxilar) {
        this.subaxilar = subaxilar;
    }

    public float getSubescapular() {
        return subescapular;
    }

    public void setSubescapular(float subescapular) {
        this.subescapular = subescapular;
    }

    public float getAbdominal() {
        return abdominal;
    }

    public void setAbdominal(float abdominal) {
        this.abdominal = abdominal;
    }

    public float getSupraliliaca() {
        return supraliliaca;
    }

    public void setSupraliliaca(float supraliliaca) {
        this.supraliliaca = supraliliaca;
    }

    public float getCoxa() {
        return coxa;
    }

    public void setCoxa(float coxa) {
        this.coxa = coxa;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public float getPercentualGordura() {
        return percentualGordura;
    }

    public void setPercentualGordura(float percentualGordura) {
        this.percentualGordura = percentualGordura;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    public Nutricionista getNutricionista() {
        return nutricionista;
    }

    public void setNutricionista(Nutricionista nutricionista) {
        this.nutricionista = nutricionista;
    }

    /// Quero um método para calcular percentual de gordura a partir do exame
    /// Quero um método para calcular percentual de massa muscular a partir do exame
    
    @Override
public String toString() {
    return "ExameDobrasCutaneas{" +
            "id=" + id +
            ", triceps=" + triceps +
            ", peito=" + peito +
            ", subaxilar=" + subaxilar +
            ", subescapular=" + subescapular +
            ", abdominal=" + abdominal +
            ", supraliliaca=" + supraliliaca +
            ", coxa=" + coxa +
            ", idade=" + idade +
            ", percentualGordura=" + percentualGordura +
            ", paciente=" + paciente +
            ", nutricionista=" + nutricionista +
            '}';
}



}

