package model;



import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

@DatabaseTable(tableName = "avioes")
public class Aviao extends Aeronave {
    @DatabaseField(generatedId = true)
    private int id;

    @DatabaseField(canBeNull = false)
    private String modelo;

    @DatabaseField(canBeNull = false)
    private int fileira;

    @DatabaseField(canBeNull = false)
    private int assento;
    
    @DatabaseField(foreign = true, foreignAutoRefresh = true)
    private Aviao aeronave;
    
    public Aviao() {
    }

    public Aviao(String modelo, int fileira, int assento) {
        this.modelo = modelo;
        this.fileira = fileira;
        this.assento = assento;
    }

    public int getId() {
        return id;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getFileira() {
        return fileira;
    }

    public void setFileira(int fileira) {
        this.fileira = fileira;
    }

    public int getAssento() {
        return assento;
    }

    public void setAssento(int assento) {
        this.assento = assento;
    }
    
    public void setAeronave(Aviao aeronave){
        this.aeronave = aeronave;
    }

    @Override
    public String toString() {
        return "Aviao [id=" + id + ", modelo=" + modelo + ", fileira=" + fileira + ", assento=" + assento + "]";
    }
}