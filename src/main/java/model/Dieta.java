
package model;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "tb_dieta")
public class Dieta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Temporal(TemporalType.DATE)
    private Date dataInicio;
    @Temporal(TemporalType.DATE)
    private Date dataFim;
    @ManyToMany
    @JoinTable(name = "tb_dieta_refeicao",
               joinColumns = @JoinColumn(name = "dieta_id"),
               inverseJoinColumns = @JoinColumn(name = "refeicao_id"))
    private List<Refeicao> refeicoes = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }

    public List<Refeicao> getRefeicoes() {
        return refeicoes;
    }

    public void setRefeicoes(List<Refeicao> refeicoes) {
        this.refeicoes = refeicoes;
    }
    
    @Override
    public String toString() {
        return "Dieta{" +
                "id=" + id +
                ", dataInicio=" + dataInicio +
                ", dataFim=" + dataFim +
                ", refeicoes=" + refeicoes +
                '}';
    }
    
}
