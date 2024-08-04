package model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "voos")
public class Voo {
    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Aviao aviao;

    @DatabaseField(canBeNull = false)
    private int numeroVoo;

    @DatabaseField(canBeNull = false)
    private String data;

    @DatabaseField(canBeNull = false)
    private String hora;
    
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Aviao aeronave;

    public Voo() {
    }

    public Voo(Aviao aviao, int numeroVoo, String data, String hora) {
        this.aviao = aviao;
        this.numeroVoo = numeroVoo;
        this.data = data;
        this.hora = hora;
    }

    public int getId() {
        return id;
    }

    public Aviao getAviao() {
        return aviao;
    }

    public void setAviao(Aviao aviao) {
        this.aviao = aviao;
    }
    
    public void setAeronave(Aviao aeronave) {
        this.aeronave = aeronave;
    }

    public int getNumeroVoo() {
        return numeroVoo;
    }

    public void setNumeroVoo(int numeroVoo) {
        this.numeroVoo = numeroVoo;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    @Override
    public String toString() {
        return "Voo [id=" + id + ", aviao=" + aviao + ", numeroVoo=" + numeroVoo + ", data=" + data + ", hora=" + hora + "]";
    }
}
