package br.ufg.poo.g2;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DadosDeCadastro {

	private String nome;
	private String CPF;
	private Date nascimento;
	
	private static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	
	public DadosDeCadastro() {
	}
	
	public DadosDeCadastro(String nome, String CPF, Date nascimento) {
		this.nome = nome;
		this.CPF = CPF;
		this.nascimento = nascimento;
	}


	
	public String getCPF() {
		return CPF;
	}

	public Date getNascimento() {
		return nascimento;
	}

	@Override
	public String toString() {
		return "\nNome: "
			+ nome +"\n"
			+ "CPF: "
			+ CPF +"\n"
			+ "Nascimento: "
			+ sdf.format(nascimento) +"\n";
	}
	
}
