package main.servlet;

import java.util.ArrayList;
import java.util.List;

public class Banco {

    private static List<Empresa> data = new ArrayList<>();

    static {
        Empresa alura = new Empresa("Alura");
        Empresa caelum = new Empresa("Caelum");

        Banco.data.add(alura);
        Banco.data.add(caelum);
    }

    public void adiciona(Empresa empresa) {
        Banco.data.add(empresa);
    }

    public List<Empresa> getData() {
        return Banco.data;
    }
}
