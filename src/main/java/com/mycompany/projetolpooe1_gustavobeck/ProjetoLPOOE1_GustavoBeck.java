
package com.mycompany.projetolpooe1_gustavobeck;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import model.*;

public class ProjetoLPOOE1_GustavoBeck {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetoLPOOE1PU");
        EntityManager em = emf.createEntityManager();
        
        try {
            em.getTransaction().begin();

            // Criando um nutricionista
            Nutricionista nutricionista = new Nutricionista();
            nutricionista.setNome("Dr. Andre");
            nutricionista.setRegistroProfissional("12345");
            nutricionista.setDataNascimento(new Date());
            nutricionista.setSexo("M");
            em.persist(nutricionista);

            // Cadastrando um paciente usando o método do Nutricionista
            Paciente paciente = nutricionista.cadastrarPaciente("Carlos Silva", new Date(), "M", 80.5f, 1.75f);
            em.persist(paciente);

            // Criando um alimento para adicionar à refeição
            Alimento alimento1 = new Alimento("Arroz Integral", 130, 2, 3, 1, 28, 100);
            Alimento alimento2 = new Alimento("Peito de Frango", 165, 0, 31, 3, 0, 100);
            em.persist(alimento1);
            em.persist(alimento2);

            // Criando uma refeição usando o método do Nutricionista
            List<Alimento> alimentos = Arrays.asList(alimento1, alimento2);
            Refeicao refeicao = nutricionista.criarRefeicao(TipoRefeicao.ALMOCO, alimentos);
            em.persist(refeicao);

            // Criando uma dieta e associando-a ao paciente
            List<Refeicao> refeicoes = Arrays.asList(refeicao);
            Dieta dieta = nutricionista.criarDieta(new Date(), new Date(System.currentTimeMillis() + (1000L * 60 * 60 * 24 * 30)), refeicoes);
            em.persist(dieta);

            // Associando a dieta ao paciente
            paciente.getDietas().add(dieta);
            em.merge(paciente);

            // Realizando um exame de dobras cutâneas no paciente
            ExameDobrasCutaneas exame = nutricionista.realizarExame(12.5f, 10.0f, 8.5f, 7.0f, 15.0f, 9.0f, 11.0f, paciente);
            em.persist(exame);

            em.getTransaction().commit();
            
            System.out.println("Dados persistidos com sucesso!");

        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
}
