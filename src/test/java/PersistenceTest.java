
import dao.JPAPersistence;
import model.Paciente;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersistenceTest {
    JPAPersistence jpa = new JPAPersistence();

    @BeforeEach
    public void setUp() {
        assertTrue(jpa.openConnection(), "Falha ao abrir conexão com o banco de dados");
    }

    @AfterEach
    public void tearDown() {
        jpa.closeConnection();
    }

    @Test
    public void persistenceTest() {
        Paciente paciente = new Paciente();
        paciente.setNome("Carlos Silva");
        paciente.setPeso(80);
        paciente.setAltura(1.75f);
        paciente.setPercentualGordura(20);
        paciente.setPercentualMassaMagra(80);

        try {
            jpa.persist(paciente);
            assertNotNull(paciente.getId(), "Paciente não foi persistido corretamente.");
        } catch (Exception e) {
            fail("Exceção ao persistir Paciente: " + e.getMessage());
        }
    }
}
