package model;



import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AviaoTest {

    private Aviao aviao;

    @BeforeEach
    public void setUp() {
        aviao = new Aviao("Boeing", 5, 300);
    }

    @Test
    public void testConstructor() {
        assertEquals("Boeing", aviao.getModelo());
        assertEquals(5, aviao.getFileira());
        assertEquals(300, aviao.getAssento());
    }

    @Test
    public void testSetAndGetModelo() {
        aviao.setModelo("Airbus A340");
        assertEquals("Airbus A340", aviao.getModelo());
    }

    @Test
    public void testSetAndGetFileira() {
        aviao.setFileira(25);
        assertEquals(25, aviao.getFileira());
    }

    @Test
    public void testSetAndGetAssento() {
        aviao.setAssento(200);
        assertEquals(200, aviao.getAssento());
    }

    @Test
    public void testToString() {
        String expected = "Aviao [id=0, modelo=Boeing, fileira=5, assento=300]";
        assertEquals(expected, aviao.toString());
    }
}

