package mvc.view;

import mvc.model.*;
import mvc.composite.*;

public class CatalogoView implements CatalogoModel.Observer {
    private CatalogoModel model;

    public CatalogoView(CatalogoModel model) {
        this.model = model;
        model.adicionarObservador(this);
    }

    public void atualizar() {
        System.out.println("--- Catálogo Atualizado ---");
        for (Item item : model.getItens()) {
            item.exibir();
        }
    }
}