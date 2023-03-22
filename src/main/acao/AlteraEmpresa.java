package main.acao;

import main.modelo.Banco;
import main.modelo.Empresa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AlteraEmpresa {

    public void executa(HttpServletRequest req, HttpServletResponse resp) throws IOException {

        String paramNomeEmpresa = req.getParameter("nome");
        String paramDataEmpresa = req.getParameter("data");
        String paramId = req.getParameter("id");
        Long id = Long.parseLong(paramId);

        System.out.println("ACAO :: Atualizando empresa: " + paramDataEmpresa + " - id: " + paramId);

        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        Date dataAbertura;

        try {
            dataAbertura = dateFormatter.parse(paramDataEmpresa);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        Banco banco = new Banco();

        try {
            Empresa empresa = banco.selecionaEmpresa(id);
            empresa.setNome(paramNomeEmpresa);
            empresa.setDataAbertura(dataAbertura);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        resp.sendRedirect("entrada?acao=listaempresas");

    }

}
