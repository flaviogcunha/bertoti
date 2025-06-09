package mvc;

import mvc.model.*;
import mvc.view.*;
import mvc.controller.*;
import mvc.composite.*;

public class Main {
    public static void main(String[] args) {
        CatalogoModel model = new CatalogoModel();
        CatalogoView view = new CatalogoView(model);
        CatalogoController controller = new CatalogoController(model);

        Produto p1 = new Produto("Notebook");
        Produto p2 = new Produto("Mouse");

        Categoria perifericos = new Categoria("Periféricos");
        perifericos.adicionar(p2);

        controller.adicionarItem(p1);
        controller.adicionarItem(perifericos);
    }
}
