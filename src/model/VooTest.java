package model;



import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * A classe de teste VooTest.
 *
 * @author  (seu nome)
 * @version (um número da versão ou uma data)
 */
public class VooTest
{
    /**
     * Construtor default para a classe de teste VooTest
     */
    private Voo voo;
    private Aviao aviao;
    private Passageiro passageiro;
    

    /**
     * Define a 'fixture' do teste.
     *
     * Chamado antes de cada método de caso de teste.
     */
    @BeforeEach
    public void setUp()
    {
        aviao = new Aviao();
        passageiro = new Passageiro("João", "123456789");
        voo = new Voo(aviao, 1234, "2024-10-12", "19:20");
    }

    @AfterEach
    public void tearDown()
    {
    }

    @Test
    public void testGetAviao() {
        assertEquals(aviao, voo.getAviao());
    }

    @Test
    public void testGetNumeroVoo() {
        assertEquals(1234, voo.getNumeroVoo());
    }

    @Test
    public void testGetData() {
        assertEquals("2024-10-12", voo.getData());
    }

    @Test
    public void testGetHora() {
        assertEquals("19:20", voo.getHora());
    }

    @Test
    public void testAddReserva() {
        voo.addReserva(passageiro, 10, 5);
        assertEquals("Fileira 10, Assento 5", voo.getReservas().get(passageiro));
    }

    @Test
    public void testSetNumeroVoo() {
        voo.setNumeroVoo(5982);
        assertEquals(5982, voo.getNumeroVoo());
    }

    @Test
    public void testSetData() {
        voo.setData("2024-12-10");
        assertEquals("2024-12-10", voo.getData());
    }

    @Test
    public void testSetHora() {
        voo.setHora("18:00");
        assertEquals("18:00", voo.getHora());
    }

    @Test
    public void testSetAeronave() {
        Aviao novoAviao = new Aviao();
        voo.setAeronave(novoAviao);
        assertEquals(novoAviao, voo.getAviao());
    }

    @Test
    public void testToString() {
        String expected = "Voo{numero=1234, data='2024-10-12', hora='19:20', aviao=" + aviao + "}";
        assertEquals(expected, voo.toString());
    }
}
