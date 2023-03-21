package main.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(urlPatterns = "/novaempresa")
public class NovaEmpresaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Cadastrando uma nova empresa");
        String nomeEmpresa = req.getParameter("nome");
        String paramDataEmpresa = req.getParameter("data");

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

        resp.sendRedirect("listaempresas");

        // chamar o jsp
        // RequestDispatcher requestDispatcher = req.getRequestDispatcher("/NovaEmpresaCriada.jsp");
        // req.setAttribute("nomeEmpresa", empresa.getNome());
        // requestDispatcher.forward(req, resp);

        // PrintWriter writer = resp.getWriter();
        // writer.println("<html><body>Empresa " + nomeEmpresa + " cadastrada com sucesso!</body></html>");
    }
}
