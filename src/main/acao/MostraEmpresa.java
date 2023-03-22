package main.acao;

import main.modelo.Banco;
import main.modelo.Empresa;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MostraEmpresa {

    public void executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String paramId = req.getParameter("id");
        Long id = Long.parseLong(paramId);

        System.out.println("ACAO :: Mostrando a empresa de id: " + id);

        Banco banco = new Banco();
        Empresa empresa;
        try {
            empresa = banco.selecionaEmpresa(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println("ACAO :: Empresa selecionada: " + empresa.getNome());

        req.setAttribute("empresa", empresa);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/formAtualizaEmpresa.jsp");
        requestDispatcher.forward(req, resp);
    }

}
