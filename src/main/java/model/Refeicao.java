
package model;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "tb_refeicao")
public class Refeicao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Enumerated(EnumType.STRING)
    private TipoRefeicao tipo;

    @ManyToMany
    @JoinTable(name = "tb_refeicao_alimento",
               joinColumns = @JoinColumn(name = "refeicao_id"),
               inverseJoinColumns = @JoinColumn(name = "alimento_id"))
    private List<Alimento> alimentos;

    private double caloriasTotais, proteinas, carboidratos, fibras, gorduras;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TipoRefeicao getTipo() {
        return tipo;
    }

    public void setTipo(TipoRefeicao tipo) {
        this.tipo = tipo;
    }

    public List<Alimento> getAlimentos() {
        return alimentos;
    }

    public void setAlimentos(List<Alimento> alimentos) {
        this.alimentos = alimentos;
    }

    public double getCaloriasTotais() {
        return caloriasTotais;
    }

    public void setCaloriasTotais(double caloriasTotais) {
        this.caloriasTotais = caloriasTotais;
    }

    public double getFibras() {
        return fibras;
    }

    public void setFibras(double fibras) {
        this.fibras = fibras;
    }

    public double getProteinas() {
        return proteinas;
    }

    public void setProteinas(double proteinas) {
        this.proteinas = proteinas;
    }

    public double getGorduras() {
        return gorduras;
    }

    public void setGorduras(double gorduras) {
        this.gorduras = gorduras;
    }

    public double getCarboidratos() {
        return carboidratos;
    }

    public void setCarboidratos(double carboidratos) {
        this.carboidratos = carboidratos;
    }
    
    public void calcularMacrosTotais() {
        this.caloriasTotais = alimentos.stream().mapToDouble(Alimento::getCalorias).sum();
        this.proteinas = alimentos.stream().mapToDouble(Alimento::getProteinas).sum();
        this.carboidratos = alimentos.stream().mapToDouble(Alimento::getCarboidratos).sum();
        this.fibras = alimentos.stream().mapToDouble(Alimento::getFibras).sum();
        this.gorduras = alimentos.stream().mapToDouble(Alimento::getGorduras).sum();
}
    
    @Override
public String toString() {
    return "Refeicao{" +
            "id=" + id +
            ", tipo=" + tipo +
            ", alimentos=" + alimentos +
            ", caloriasTotais=" + caloriasTotais +
            ", proteinas=" + proteinas +
            ", carboidratos=" + carboidratos +
            ", fibras=" + fibras +
            ", gorduras=" + gorduras +
            '}';
}
}
