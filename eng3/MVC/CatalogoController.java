package mvc.controller;

import mvc.model.*;
import mvc.composite.*;

public class CatalogoController {
    private CatalogoModel model;

    public CatalogoController(CatalogoModel model) {
        this.model = model;
    }

    public void adicionarItem(Item item) {
        model.adicionar(item);
    }
}