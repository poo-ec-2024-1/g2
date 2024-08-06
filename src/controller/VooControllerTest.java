package controller;

import model.Aviao;
import model.Voo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * A classe de teste VooControllerTest.
 *
 * @author  (seu nome)
 * @version (um número da versão ou uma data)
 */
public class VooControllerTest{
    /**
     * Construtor default para a classe de teste VooControllerTest
     */
    
    private VooController vooController;
    private AviaoController aviaoController;

    /**
     * Define a 'fixture' do teste.
     *
     * Chamado antes de cada método de caso de teste.
     */
    @BeforeEach
    public void setUp()
    {
        aviaoController = new AviaoController();
        vooController = new VooController(aviaoController);

        aviaoController.createAviao("Boeing 737", 30, 6);
        aviaoController.createAviao("Airbus A320", 25, 5);
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
    public void testCreateVoo() {
        vooController.createVoo(101, "2024-08-01", "10:00", 0);
        List<Voo> voos = vooController.getAllVoos();

        assertEquals(1, voos.size());
        Voo voo = voos.get(0);
        assertEquals(101, voo.getNumeroVoo());
        assertEquals("2024-08-01", voo.getData());
        assertEquals("10:00", voo.getHora());
        assertNotNull(voo.getAviao());
        assertEquals("Boeing 737", voo.getAviao().getModelo());
    }

    @Test
    public void testUpdateVoo() {
        vooController.createVoo(102, "2024-08-02", "15:00", 1);
        vooController.updateVoo(0, 103, "2024-08-03", "18:00", 1);

        Voo voo = vooController.getVoo(0);
        assertNotNull(voo);
        assertEquals(103, voo.getNumeroVoo());
        assertEquals("2024-08-03", voo.getData());
        assertEquals("18:00", voo.getHora());
        assertEquals("Airbus A320", voo.getAviao().getModelo());
    }

    @Test
    public void testDeleteVoo() {
        vooController.createVoo(104, "2024-08-04", "20:00", 0);
        vooController.deleteVoo(0);

        List<Voo> voos = vooController.getAllVoos();
        assertTrue(voos.isEmpty());
    }

    @Test
    public void testGetVoo() {
        vooController.createVoo(105, "2024-08-05", "22:00", 0);
        Voo voo = vooController.getVoo(0);

        assertNotNull(voo);
        assertEquals(105, voo.getNumeroVoo());
        assertEquals("2024-08-05", voo.getData());
        assertEquals("22:00", voo.getHora());
    }
}

