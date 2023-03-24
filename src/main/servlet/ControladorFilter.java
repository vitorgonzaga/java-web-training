package main.servlet;

import main.acao.Acao;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

// @WebFilter(urlPatterns = "/entrada")
public class ControladorFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain chain) throws IOException, ServletException {

        System.out.println("ControladorFilter");

        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        String paramAcao = request.getParameter("acao");

        String nomeDaClasse = "main.acao." + paramAcao;

        String path = null;
        try {
            Class classe = Class.forName(nomeDaClasse);
            Acao acao = (Acao) classe.newInstance();
            path = acao.executa(request, response);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            throw new ServletException(e);
        }

        String[] tipoEEndereco = path.split(":");

        if(tipoEEndereco[0].equals("forward")) {
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/view/" + tipoEEndereco[1]);
            requestDispatcher.forward(request, response);
        } else {
            response.sendRedirect(tipoEEndereco[1]);
        }


    }
}
