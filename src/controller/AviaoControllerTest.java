package controller;

import model.Aviao;
import controller.AviaoController;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.List;

/**
 * A classe de teste AviaoControllerTest.
 *
 * @author  (seu nome)
 * @version (um número da versão ou uma data)
 */
public class AviaoControllerTest
{
    /**
     * Construtor default para a classe de teste AviaoControllerTest
     */
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
    public void testCreateAviao() {
        aviaoController.createAviao("Boeing 737", 30, 6);
        List<Aviao> avioes = aviaoController.getAllAvioes();
        assertEquals(1, avioes.size());
        Aviao aviao = avioes.get(0);
        assertEquals("Boeing 737", aviao.getModelo());
        assertEquals(30, aviao.getFileira());
        assertEquals(6, aviao.getAssento());
    }

    @Test
    public void testGetAllAvioes() {
        aviaoController.createAviao("Boeing 737", 30, 6);
        aviaoController.createAviao("Airbus A320", 25, 4);
        List<Aviao> avioes = aviaoController.getAllAvioes();
        assertEquals(2, avioes.size());
    }

    @Test
    public void testGetAviao() {
        aviaoController.createAviao("Boeing 737", 30, 6);
        Aviao aviao = aviaoController.getAviao(0);
        assertNotNull(aviao);
        assertEquals("Boeing 737", aviao.getModelo());
    }

    @Test
    public void testUpdateAviao() {
        aviaoController.createAviao("Boeing 737", 30, 6);
        aviaoController.updateAviao(0, "Airbus A320", 25, 4);
        Aviao aviao = aviaoController.getAviao(0);
        assertEquals("Airbus A320", aviao.getModelo());
        assertEquals(25, aviao.getFileira());
        assertEquals(4, aviao.getAssento());
    }

    @Test
    public void testDeleteAviao() {
        aviaoController.createAviao("Boeing 737", 30, 6);
        aviaoController.deleteAviao(0);
        List<Aviao> avioes = aviaoController.getAllAvioes();
        assertEquals(0, avioes.size());
    }
}
