package main.modelo;

import java.util.*;

public class Banco {

    private static List<Empresa> data = new ArrayList<>();
    private static List<Usuario> listaUsuarios = new ArrayList<>();

    private static Long chaveSequencial = 1L;

    static {
        Empresa alura = new Empresa("Alura");
        alura.setId(Banco.chaveSequencial++);
        Empresa caelum = new Empresa("Caelum");
        caelum.setId(Banco.chaveSequencial++);

        Banco.data.add(alura);
        Banco.data.add(caelum);

        Usuario u1 = new Usuario();
        u1.setLogin("vitor");
        u1.setSenha("12345");

        Usuario u2 = new Usuario();
        u2.setLogin("pamela");
        u2.setSenha("12345");

        listaUsuarios.add(u1);
        listaUsuarios.add(u2);

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

    public Usuario buscaUsuario(String login, String senha) {
        Usuario usuario = new Usuario(login, senha);
        Optional<Usuario> result = Banco.listaUsuarios.stream().filter(user -> user.equals(usuario)).findFirst();
        // try {
            if (result.isPresent()) {
                return result.get();
            } else {
                throw new NoSuchElementException("usuário não encontrado");
            }
        // } catch (Exception e) {
            // throw new NoSuchElementException("usuário não encontrado");
        // }

        // return new Usuario();
    }
}
