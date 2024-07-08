public class Voo {
	private Aviao aeronave;
	private int nroVoo;
	private String data;
	private String hora;
	
	public Voo() {
	}
	
	public Voo(int nroVoo, String data, String hora) {
		this.nroVoo = nroVoo;
		this.data = data;
		this.hora = hora;
	}
	
	public Voo(Aviao aeronave, int nroVoo, String data, String hora) {
		this.aeronave = aeronave;
		this.nroVoo = nroVoo;
		this.data = data;
		this.hora = hora;
	}
	
	public int getNroVoo() {
		return nroVoo;
	}
	public void setNroVoo(int nroVoo) {
		this.nroVoo = nroVoo;
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
		return "\nNúmero do Voo: "+ nroVoo + "\nData: " + data + "\nHora: " + hora + "\n" + aeronave;
	}
	
	
}