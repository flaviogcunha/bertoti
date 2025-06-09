package mvc.composite;

import java.util.*;

public class Categoria implements Item {
    private String nome;
    private List<Item> itens = new ArrayList<>();

    public Categoria(String nome) {
        this.nome = nome;
    }

    public void adicionar(Item item) {
        itens.add(item);
    }

    public void exibir() {
        System.out.println("Categoria: " + nome);
        for (Item i : itens) {
            i.exibir();
        }
    }
}