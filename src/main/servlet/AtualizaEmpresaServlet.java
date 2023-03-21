package main.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(urlPatterns = "/atualizaempresa")
public class AtualizaEmpresaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String paramNomeEmpresa = req.getParameter("nome");
        String paramDataEmpresa = req.getParameter("data");
        String paramId = req.getParameter("id");
        Long id = Long.parseLong(paramId);

        System.out.println("Atualizando empresa: " + paramDataEmpresa + " - id: " + paramId);

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

        resp.sendRedirect("listaempresas");

    }
}
