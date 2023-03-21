package main.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/listaempresas")
public class ListaEmpresasServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Banco banco = new Banco();
        List<Empresa> empresas = banco.getData();
        req.setAttribute("empresas", empresas);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/listaEmpresas.jsp");
        requestDispatcher.forward(req, resp);


    }
}
