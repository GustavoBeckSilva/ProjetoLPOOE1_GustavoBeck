
package com.mycompany.projetolpooe1_gustavobeck;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import model.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class ProjetoLPOOE1_GustavoBeck {
    public static void main(String[] args) {
        // Configuração inicial do EntityManager
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetoLPOOE1PU");
        EntityManager em = emf.createEntityManager();

        // Inicia uma transação
        em.getTransaction().begin();

        try {
            // Criar um nutricionista
            Nutricionista nutricionista = new Nutricionista();
            nutricionista.setNome("Dr. João Nutri");
            nutricionista.setDataNascimento(new Date(1980 - 1900, 1 - 1, 15));  // Data fictícia
            nutricionista.setSexo("Masculino");
            nutricionista.setRegistroProfissional("CRN-12345");
            em.persist(nutricionista);

            // Criar um paciente
            Paciente paciente = nutricionista.cadastrarPaciente("Maria Silva", new Date(1990 - 1900, 5 - 1, 10), "Feminino", 65.0f, 1.70f);
            paciente.setPercentualGordura(20);
            paciente.setPercentualMassaMagra(35);
            em.persist(paciente);

            // Criar alimentos
            Alimento arroz = new Alimento("Arroz", 130.0f, 0.2f, 2.5f, 0.3f, 28.0f, 100.0f);
            Alimento feijao = new Alimento("Feijão", 95.0f, 8.0f, 6.0f, 0.5f, 15.0f, 100.0f);
            Alimento frango = new Alimento("Frango", 165.0f, 0.0f, 31.0f, 3.6f, 0.0f, 100.0f);
            em.persist(arroz);
            em.persist(feijao);
            em.persist(frango);

            // Criar refeição com alimentos
            List<Alimento> alimentosAlmoco = Arrays.asList(arroz, feijao, frango);
            Refeicao almoco = nutricionista.criarRefeicao(TipoRefeicao.ALMOCO, alimentosAlmoco);
            em.persist(almoco);

            // Criar dieta com a refeição
            List<Refeicao> refeicoes = new ArrayList<>();
            refeicoes.add(almoco);
            Dieta dieta = nutricionista.criarDieta(new Date(), new Date(2024 - 1900, 11 - 1, 30), refeicoes);
            paciente.getDietas().add(dieta);
            em.persist(dieta);

            // Realizar um exame de dobras cutâneas
            ExameDobrasCutaneas exame = nutricionista.realizarExame(10.0f, 20.0f, 12.0f, 14.0f, 18.0f, 15.0f, 30.0f, paciente);
            exame.setIdade(34);
            exame.setPercentualGordura(20.0f);  // Exemplo de cálculo de gordura
            em.persist(exame);

            // Finalizar a transação
            em.getTransaction().commit();

            System.out.println("Dados persistidos com sucesso!");

        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
            emf.close();
        }
    }
}
