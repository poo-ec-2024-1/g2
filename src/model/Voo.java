package model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;
import java.util.HashMap;
import java.util.Map;

@DatabaseTable(tableName = "voos")
public class Voo {
    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Aviao aviao;

    @DatabaseField
    private int numeroVoo;

    @DatabaseField
    private String data;

    @DatabaseField
    private String hora;

    // Este mapa armazena reservas associando Passageiros aos seus assentos
    private Map<Passageiro, String> reservas;

    public Voo() {
        // ORMLite needs a no-arg constructor
    }

    public Voo(Aviao aviao, int numeroVoo, String data, String hora) {
        this.aviao = aviao;
        this.numeroVoo = numeroVoo;
        this.data = data;
        this.hora = hora;
        this.reservas = new HashMap<>();
    }

    public int getId() {
        return id;
    }

    public Aviao getAviao() {
        return aviao;
    }

    public int getNumeroVoo() {
        return numeroVoo;
    }

    public String getData() {
        return data;
    }

    public String getHora() {
        return hora;
    }

    public Map<Passageiro, String> getReservas() {
        return reservas;
    }

    public void addReserva(Passageiro passageiro, int fileira, int assento) {
        String assentoStr = "Fileira " + fileira + ", Assento " + assento;
        reservas.put(passageiro, assentoStr);
    }
    
    public void setNumeroVoo(int numeroVoo){
        this.numeroVoo = numeroVoo;
    }
    
    public void setData(String data){
        this.data = data;
    }
    
    public void setHora(String hora){
        this.hora = hora;
    }
    
    public void setAeronave(Aviao aviao){
        this.aviao = aviao;
    }
    
    @Override
    public String toString() {
        return "Voo{" +
                "numero=" + numeroVoo +
                ", data='" + data + '\'' +
                ", hora='" + hora + '\'' +
                ", aviao=" + aviao +
                '}';
    }
}

