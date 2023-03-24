package main.servlet;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

// @WebFilter(urlPatterns = "/entrada")
public class MonitoramentoFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        System.out.println("MonitoramentoFilter");

        Long antes = System.currentTimeMillis();

        String acao = request.getParameter("acao");

        chain.doFilter(request, response);

        Long depois = System.currentTimeMillis();
        System.out.println("Tempo de execução da ação " + acao + " -> " + (depois - antes));


    }
}
