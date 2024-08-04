package controller;

import java.util.ArrayList;
import java.util.List;

import model.Aviao;
import model.Voo;

public class VooController {
    private List<Voo> voos;
    private AviaoController aviaoController;

    public VooController(AviaoController aviaoController) {
        this.voos = new ArrayList<>();
        this.aviaoController = aviaoController;
    }

    public void createVoo(int numeroVoo, String data, String hora, int aviaoIndex) {
        Aviao aviao = aviaoController.getAviao(aviaoIndex);
        if (aviao != null) {
            Voo voo = new Voo(aviao, numeroVoo, data, hora);
            voos.add(voo);
        }
    }

    public List<Voo> getAllVoos() {
        return voos;
    }

    public Voo getVoo(int index) {
        if (index >= 0 && index < voos.size()) {
            return voos.get(index);
        }
        return null;
    }

    public void updateVoo(int index, int numeroVoo, String data, String hora, int aviaoIndex) {
        if (index >= 0 && index < voos.size()) {
            Voo voo = voos.get(index);
            Aviao aviao = aviaoController.getAviao(aviaoIndex);
            if (aviao != null) {
                voo.setNumeroVoo(numeroVoo);
                voo.setData(data);
                voo.setHora(hora);
                voo.setAeronave(aviao);
            }
        }
    }

    public void deleteVoo(int index) {
        if (index >= 0 && index < voos.size()) {
            voos.remove(index);
        }
    }
}
