package main.servlet;

import main.acao.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		String paramAcao = req.getParameter("acao");
		
		if(paramAcao.equals("listaempresas")) {
			ListaEmpresas acao = new ListaEmpresas();
			acao.executa(req, resp);
		} else if (paramAcao.equals("removeempresa")) {
			RemoveEmpresa acao = new RemoveEmpresa();
			acao.executa(req, resp);
		} else if (paramAcao.equals("mostraempresa")) {
			MostraEmpresa acao = new MostraEmpresa();
			acao.executa(req, resp);
		} else if (paramAcao.equals("alteraempresa")) {
			AlteraEmpresa acao = new AlteraEmpresa();
			acao.executa(req,resp);
		} else if (paramAcao.equals("novaempresa")) {
			NovaEmpresa acao = new NovaEmpresa();
			acao.executa(req, resp);
		}

	}

}
