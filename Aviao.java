public class Aviao extends Aeronave{
	
	public Passageiro lugares[][];
	private int fileira;
	private int assento;
	
	public Aviao() {
	}
	
	public Aviao(String modelo, int fileira, int assento) {
		super(modelo);
		this.lugares = new Passageiro[fileira][assento];
		this.fileira = fileira;
		this.assento = assento;
	}
	
	public boolean verificaPoltrona(int fileira, int assento) {
		if(lugares[fileira][assento] != null)
			return true;
		else
			return false;
	}
	public Passageiro getPassageiro(int fileira, int assento) {
		if(lugares[fileira][assento] != null)
			return lugares[fileira][assento];
		else
			return null;
	}
	public void setPassageiro(int fileira, int assento, Passageiro passageiro) {
		this.lugares[fileira][assento] = passageiro;
	}
	public int getFileira() {
		return fileira;
	}

	public void setFileira(int fileira) {
		this.fileira = fileira;
	}

	public int getAssentos() {
		return assentos;
	}

	public void setAssentos(int assentos) {
		this.assentos = assentos;
	}
	@Override
	public String toString() {
		return "Aviao [fileira=" + fileira + ", assentos=" + assentos
				+ ", modelo=" + modelo + "]";
	}
}
