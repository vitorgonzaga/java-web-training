package main.acao;

import main.modelo.Banco;
import main.modelo.Empresa;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class ListaEmpresas implements Acao {

    public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("ACAO :: listando empresas");
        Banco banco = new Banco();
        List<Empresa> empresas = banco.getData();
        req.setAttribute("empresas", empresas);

        return "forward:listaEmpresas.jsp";
    }
}
