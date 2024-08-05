package controller;

import java.util.ArrayList;
import java.util.List;

import model.Aviao;

public class AviaoController {
    private List<Aviao> avioes;

    public AviaoController() {
        avioes = new ArrayList<>();
    }

    public void createAviao(String modelo, int fileira, int assento) {
        Aviao aviao = new Aviao(modelo, fileira, assento);
        avioes.add(aviao);
    }

    public List<Aviao> getAllAvioes() {
        return avioes;
    }

    public Aviao getAviao(int index) {
        if (index >= 0 && index < avioes.size()) {
            return avioes.get(index);
        }
        return null;
    }

    public void updateAviao(int index, String modelo, int fileira, int assento) {
        if (index >= 0 && index < avioes.size()) {
            Aviao aviao = avioes.get(index);
            aviao.setModelo(modelo);
            aviao.setFileira(fileira);
            aviao.setAssento(assento);
        }
    }

    public void deleteAviao(int index) {
        if (index >= 0 && index < avioes.size()) {
            avioes.remove(index);
        }
    }
}
