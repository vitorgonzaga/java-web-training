package main.acao;

import main.modelo.Banco;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RemoveEmpresa implements Acao {

    public String executa(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String paramId = req.getParameter("id");
        Long id = Long.parseLong(paramId);
        System.out.println("ACAO :: Deletando a empresa de id: " + id);

        Banco banco = new Banco();
        banco.removeEmpresa(id);

        return "redirect:entrada?acao=ListaEmpresas";

    }

}
