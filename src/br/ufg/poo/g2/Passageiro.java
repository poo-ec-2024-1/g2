package br.ufg.poo.g2;

public class Passageiro {
	private String nome;
	private String cpf;
	private Integer idade;
	
	public Passageiro(String nome, String cpf, Integer idade) {
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
	}
	public String getNome() {
		return nome;
	}

	public String getCpf() {
		return cpf;
	}
	
	public Integer getIdade() {
		return idade;
	}
	
	public void setIdade(Integer idade) {
		this.idade = idade;
	}
	@Override
	public String toString() {
		return "\nNome:"+ nome + 
				"\nCpf:" + cpf 
				;
	}
}