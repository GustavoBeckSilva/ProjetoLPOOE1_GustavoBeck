import dao.JPAPersistence;
import model.*;
import org.junit.jupiter.api.*;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class PersistenceTest {

    private JPAPersistence jpa;
    private Nutricionista nutricionista;

    @BeforeEach
    public void setUp() {
        jpa = new JPAPersistence();
        assertTrue(jpa.openConnection(), "Falha ao abrir conexão com o banco de dados");
        
        // Persistindo um nutricionista para ser utilizado em outros testes
        nutricionista = new Nutricionista();
        nutricionista.setNome("Dr. Andre");
        nutricionista.setRegistroProfissional("12345");
        nutricionista.setDataNascimento(new Date());
        nutricionista.setSexo("M");
        jpa.persist(nutricionista);
        assertNotNull(nutricionista.getId(), "Nutricionista não foi persistido corretamente.");
    }

    @AfterEach
    public void tearDown() {
        jpa.closeConnection();
    }

    @Test
    public void testCriarDietaAssociarPaciente() {
        // Criando e persistindo um paciente e uma refeição
        Paciente paciente = nutricionista.cadastrarPaciente("Carlos Silva", new Date(), "M", 80.5f, 1.75f);
        Alimento alimento = new Alimento("Arroz Integral", 130, 2, 3, 1, 28, 100);
        jpa.persist(paciente);
        jpa.persist(alimento);

        List<Alimento> alimentos = Arrays.asList(alimento);
        Refeicao refeicao = nutricionista.criarRefeicao(TipoRefeicao.ALMOCO, alimentos);
        jpa.persist(refeicao);

        // Criando dieta com a refeição
        List<Refeicao> refeicoes = Arrays.asList(refeicao);
        Dieta dieta = nutricionista.criarDieta(new Date(), new Date(System.currentTimeMillis() + (1000L * 60 * 60 * 24 * 30)), refeicoes);
        jpa.persist(dieta);

        // Associando a dieta ao paciente diretamente
        paciente.getDietas().add(dieta);
        jpa.persist(paciente);  // Persistindo o paciente com a dieta associada

        // Paciente pacientePersistido = jpa.find(Paciente.class, paciente.getId());
        // assertTrue(pacientePersistido.getDietas().contains(dieta), "Dieta não foi associada corretamente ao paciente.");
    }
}
