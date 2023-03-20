package main.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/novaempresa")
public class NovaEmpresaServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("Cadastrando uma nova empresa");
        String nomeEmpresa = req.getParameter("nome");

        Empresa empresa = new Empresa(nomeEmpresa);

        Banco banco = new Banco();
        banco.adiciona(empresa);

        // chamar o jsp
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/NovaEmpresaCriada.jsp");
        req.setAttribute("nomeEmpresa", empresa.getNome());
        requestDispatcher.forward(req, resp);

        // PrintWriter writer = resp.getWriter();
        // writer.println("<html><body>Empresa " + nomeEmpresa + " cadastrada com sucesso!</body></html>");
    }
}
