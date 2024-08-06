package model;



import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * A classe de teste PassageiroTest.
 *
 * @author  (seu nome)
 * @version (um número da versão ou uma data)
 */
public class PassageiroTest
{
    /**
     * Construtor default para a classe de teste PassageiroTest
     */
    private Passageiro passageiro;

    /**
     * Define a 'fixture' do teste.
     *
     * Chamado antes de cada método de caso de teste.
     */
    @BeforeEach
    public void setUp()
    {
        passageiro = new Passageiro("João Pedro", "123.456.789-00");
    }

    /**
     * Desfaz a 'fixture' do teste.
     *
     * Chamado após cada método de teste de caso.
     */
    @AfterEach
    public void tearDown()
    {
    }
    
    @Test
    public void testPassageiroCreation() {
        assertEquals("João Pedro", passageiro.getNome());
        assertEquals("123.456.789-00", passageiro.getCpf());
    }

    @Test
    public void testDefaultConstructor() {
        Passageiro defaultPassageiro = new Passageiro();
        assertNull(defaultPassageiro.getNome());
        assertNull(defaultPassageiro.getCpf());
    }

    @Test
    public void testToString() {
        String expected = "Passageiro{nome='João Pedro', cpf='123.456.789-00'}";
        assertEquals(expected, passageiro.toString());
    }

    @Test
    public void testSettersAndGetters() {
        passageiro = new Passageiro();
        passageiro.setNome("Juliana");
        passageiro.setCpf("987.654.321-00");

        assertEquals("Juliana", passageiro.getNome());
        assertEquals("987.654.321-00", passageiro.getCpf());
    }
}
