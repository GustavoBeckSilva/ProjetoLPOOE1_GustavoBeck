
package model;

import jakarta.persistence.*;

@Entity
@Table(name = "tb_alimento")
public class Alimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 100, nullable = false)
    private String nome;

    public Alimento(String nome, float calorias, float fibras, float proteinas, float gorduras, float carboidratos, float porcao) {
        this.nome = nome;
        this.calorias = calorias;
        this.fibras = fibras;
        this.proteinas = proteinas;
        this.gorduras = gorduras;
        this.carboidratos = carboidratos;
        this.porcao = porcao;
    }

    private float calorias, fibras, proteinas, gorduras, carboidratos, porcao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getCalorias() {
        return calorias;
    }

    public void setCalorias(float calorias) {
        this.calorias = calorias;
    }

    public float getFibras() {
        return fibras;
    }

    public void setFibras(float fibras) {
        this.fibras = fibras;
    }

    public float getGorduras() {
        return gorduras;
    }

    public void setGorduras(float gorduras) {
        this.gorduras = gorduras;
    }

    public float getProteinas() {
        return proteinas;
    }

    public void setProteinas(float proteinas) {
        this.proteinas = proteinas;
    }

    public float getCarboidratos() {
        return carboidratos;
    }

    public void setCarboidratos(float carboidratos) {
        this.carboidratos = carboidratos;
    }

    public float getPorcao() {
        return porcao;
    }

    public void setPorcao(float porcao) {
        this.porcao = porcao;
    }
    
    @Override
public String toString() {
    return "Alimento{" +
            "id=" + id +
            ", nome='" + nome + '\'' +
            ", calorias=" + calorias +
            ", fibras=" + fibras +
            ", proteinas=" + proteinas +
            ", gorduras=" + gorduras +
            ", carboidratos=" + carboidratos +
            ", porcao=" + porcao +
            '}';
}
}
