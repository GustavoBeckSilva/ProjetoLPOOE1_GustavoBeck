package model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "tb_nutricionista")
public class Nutricionista extends Pessoa {

    @Column(length = 20, nullable = false)
    private String registroProfissional;

    public Nutricionista() {}

    public String getRegistroProfissional() {
        return registroProfissional;
    }

    public void setRegistroProfissional(String registroProfissional) {
        this.registroProfissional = registroProfissional;
    }

    // Método para cadastrar um novo paciente
    public Paciente cadastrarPaciente(String nome, Date dataNascimento, String sexo, float peso, float altura) {
        Paciente paciente = new Paciente();
        paciente.setNome(nome);
        paciente.setDataNascimento(dataNascimento);
        paciente.setSexo(sexo);
        paciente.setPeso(peso);
        paciente.setAltura(altura);
        return paciente;
    }

    // Método para realizar exame de dobras cutâneas
    public ExameDobrasCutaneas realizarExame(float triceps, float peito, float subaxilar, float subescapular,
                                             float abdominal, float supraliliaca, float coxa, Paciente paciente) {
        ExameDobrasCutaneas exame = new ExameDobrasCutaneas();
        exame.setTriceps(triceps);
        exame.setPeito(peito);
        exame.setSubaxilar(subaxilar);
        exame.setSubescapular(subescapular);
        exame.setAbdominal(abdominal);
        exame.setSupraliliaca(supraliliaca);
        exame.setCoxa(coxa);
        exame.setPaciente(paciente);
        exame.setNutricionista(this);
        paciente.getExames().add(exame);
        return exame;
    }

    // Método para criar uma nova refeição
    public Refeicao criarRefeicao(TipoRefeicao tipo, List<Alimento> alimentos) {
        Refeicao refeicao = new Refeicao();
        refeicao.setTipo(tipo);
        refeicao.setAlimentos(alimentos);
        refeicao.calcularMacrosTotais();
        return refeicao;
    }

    // Método para criar uma nova dieta associada a um paciente
    public Dieta criarDieta(Date dataInicio, Date dataFim, List<Refeicao> refeicoes) {
        Dieta dieta = new Dieta();
        dieta.setDataInicio(dataInicio);
        dieta.setDataFim(dataFim);
        dieta.setRefeicoes(refeicoes);
        return dieta;
    }

    @Override
    public String toString() {
        return "Nutricionista{" +
                "nome=" + getNome() +
                ", registroProfissional='" + registroProfissional + '\'' +
                '}';
    }
}
