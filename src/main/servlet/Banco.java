package main.servlet;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Banco {

    private static List<Empresa> data = new ArrayList<>();
    private static Long chaveSequencial = 1L;

    static {
        Empresa alura = new Empresa("Alura");
        alura.setId(Banco.chaveSequencial++);
        Empresa caelum = new Empresa("Caelum");
        caelum.setId(Banco.chaveSequencial++);

        Banco.data.add(alura);
        Banco.data.add(caelum);
    }

    public void adiciona(Empresa empresa) {
        empresa.setId(Banco.chaveSequencial++);
        Banco.data.add(empresa);
    }

    public List<Empresa> getData() {
        return Banco.data;
    }

    public void removeEmpresa(Long id) {
        Iterator<Empresa> iterator = Banco.data.iterator();
        while(iterator.hasNext()) {
            Empresa emp = iterator.next();
            if (emp.getId() == id) {
                iterator.remove();
            }
        }

//        Banco.data.forEach(emp -> {
//            if (emp.getId() == id) {
//                Banco.data.remove(emp);
//            }
//        });
    }

    public Empresa selecionaEmpresa(Long id) throws Exception {
        try {
            Iterator<Empresa> iterator = Banco.data.iterator();

            while(iterator.hasNext()){
                Empresa emp = iterator.next();
                if(emp.getId() == id) {
                    return emp;
                }
            }
        } catch (Exception e) {
            throw new Exception("Empresa não encontrada");
        }
        return null;
    }
}
