package main.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/mostraempresa")
public class MostraEmpresaServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String paramId = req.getParameter("id");
        Long id = Long.parseLong(paramId);

        Banco banco = new Banco();
        Empresa empresa;
        try {
            empresa = banco.selecionaEmpresa(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println(empresa.getNome());

        req.setAttribute("empresa", empresa);

        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/formAtualizaEmpresa.jsp");
        requestDispatcher.forward(req, resp);

        // resp.sendRedirect("atualizaempresa");

    }
}
