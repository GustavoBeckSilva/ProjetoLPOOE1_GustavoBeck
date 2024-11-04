
import dao.JPAPersistence;
import model.Paciente;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ConnectionTest {
    static JPAPersistence jpa;

    @BeforeAll
    public static void setUpClass() {
        jpa = new JPAPersistence();
        assertTrue(jpa.openConnection(), "Erro ao abrir a conexão.");
    }

    @AfterAll
    public static void tearDownClass() {
        jpa.closeConnection();
    }

    @Test
    public void persistPacienteTest() {
        Paciente paciente = new Paciente();
        paciente.setNome("Ana Souza");
        paciente.setPeso(70);
        paciente.setAltura(1.65f);
        paciente.setPercentualGordura(25);
        paciente.setPercentualMassaMagra(75);

        try {
            jpa.persist(paciente);
            assertNotNull(paciente.getId(), "Paciente não foi persistido.");
        } catch (Exception e) {
            fail("Erro ao persistir Paciente: " + e.getMessage());
        }
    }
}
