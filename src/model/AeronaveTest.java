package model;



import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * A classe de teste AeronaveTest.
 *
 * @author  (seu nome)
 * @version (um número da versão ou uma data)
 */
public class AeronaveTest
{
    /**
     * Construtor default para a classe de teste AeronaveTest
     */
    public AeronaveTest()
    {
    }

    /**
     * Define a 'fixture' do teste.
     *
     * Chamado antes de cada método de caso de teste.
     */
    @BeforeEach
    public void setUp()
    {
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
    public void testGetAndSetModelo() {
        Aeronave aeronave = new Aeronave();
        String modelo = "Airbus A340";
        aeronave.setModelo(modelo);
        assertEquals(modelo, aeronave.getModelo());
    }
    
    @Test
    public void testDefaultConstructor() {
        Aeronave aeronave = new Aeronave();
        assertEquals(null, aeronave.getModelo());
    }
}

