package main.acao;

import main.modelo.Banco;
import main.modelo.Empresa;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class NovaEmpresa implements Acao {

    public String executa(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String nomeEmpresa = req.getParameter("nome");
        String paramDataEmpresa = req.getParameter("data");

        System.out.println("ACAO :: Cadastrando empresa: " + nomeEmpresa);

        SimpleDateFormat dateFormatter = new SimpleDateFormat("dd/MM/yyyy");
        Date dataAbertura;

        try {
            dataAbertura = dateFormatter.parse(paramDataEmpresa);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        Empresa empresa = new Empresa(nomeEmpresa);
        empresa.setDataAbertura(dataAbertura);

        Banco banco = new Banco();
        banco.adiciona(empresa);

        return "redirect:entrada?acao=ListaEmpresas";
    }

}
