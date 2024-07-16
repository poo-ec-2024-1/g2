package br.ufg.poo.g2;

import java.util.ArrayList;
import java.util.List;

public class PassageiroDAO {
    private List<Passageiro> passageiros;

    public PassageiroDAO() {
        passageiros = new ArrayList<>();
    }

    public void adicionarPassageiro(Passageiro passageiro) {
        passageiros.add(passageiro);
    }

    public Passageiro buscarPassageiroPorNome(String nome) {
        for (Passageiro passageiro : passageiros) {
            if (passageiro.getNome().equals(nome)) {
                return passageiro;
            }
        }
        return null; 
    }

    public boolean atualizarPassageiro(String nome, int novaIdade) {
        for (Passageiro passageiro : passageiros) {
            if (passageiro.getNome().equals(nome)) {
                passageiro.setIdade(novaIdade);
                return true; 
            }
        }
        return false; 
    }

    public boolean deletarPassageiro(String nome) {
        for (Passageiro passageiro : passageiros) {
            if (passageiro.getNome().equals(nome)) {
                passageiros.remove(passageiro);
                return true; 
            }
        }
        return false; 
    }

    public List<Passageiro> listarPassageiros() {
        return passageiros;
    }
}