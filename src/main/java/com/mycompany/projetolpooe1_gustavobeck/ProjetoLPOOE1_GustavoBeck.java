
package com.mycompany.projetolpooe1_gustavobeck;

import jakarta.persistence.*;
import java.util.Date;
import model.*;

public class ProjetoLPOOE1_GustavoBeck {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjetoLPOOE1PU");
        EntityManager em = emf.createEntityManager();

        try {
            em.getTransaction().begin();

            Nutricionista nutricionista = new Nutricionista();
            nutricionista.setNome("João Silva");
            nutricionista.setDataNascimento(new Date());
            nutricionista.setSexo("Masculino");
            nutricionista.setRegistroProfissional("123456");

            em.persist(nutricionista);

            Paciente paciente = new Paciente();
            paciente.setNome("Maria Oliveira");
            paciente.setDataNascimento(new Date());
            paciente.setSexo("Feminino");
            paciente.setPeso(70);
            paciente.setAltura(1.65f);
            paciente.setPercentualGordura(25);
            paciente.setPercentualMassaMagra(75);

            em.persist(paciente);

            em.getTransaction().commit();

            System.out.println("Nutricionista e Paciente persistidos com sucesso!");
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            em.close();
            emf.close();
        }
    }
    }

