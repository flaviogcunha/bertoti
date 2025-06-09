package mvc.model;

import mvc.composite.*;
import java.util.*;

public class CatalogoModel {
    private List<Item> itens = new ArrayList<>();
    private List<Observer> observadores = new ArrayList<>();

    public void adicionar(Item item) {
        itens.add(item);
        notificar();
    }

    public List<Item> getItens() {
        return itens;
    }

    public void adicionarObservador(Observer o) {
        observadores.add(o);
    }

    private void notificar() {
        for (Observer o : observadores) {
            o.atualizar();
        }
    }

    public interface Observer {
        void atualizar();
    }
}