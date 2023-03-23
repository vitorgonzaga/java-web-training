package main.servlet;

import main.acao.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/entrada")
public class UnicaEntradaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String paramAcao = req.getParameter("acao");
		System.out.println(paramAcao);

		HttpSession session = req.getSession();
		Boolean usuarioNaoEstaLogado = session.getAttribute("usuarioLogado") == null;
		Boolean ehUmaAcaoProtegida = !(paramAcao.equals("Login") || paramAcao.equals("LoginForm"));

		if(ehUmaAcaoProtegida && usuarioNaoEstaLogado) {
			resp.sendRedirect("entrada?acao=LoginForm");
			return;
		}


		String nomeDaClasse = "main.acao." + paramAcao;

		String path = null;
		try {
			Class classe = Class.forName(nomeDaClasse);
			Acao acao = (Acao) classe.newInstance();
			path = acao.executa(req, resp);
		} catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
			throw new ServletException(e);
		}

		String[] tipoEEndereco = path.split(":");

		if(tipoEEndereco[0].equals("forward")) {
			RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/view/" + tipoEEndereco[1]);
			requestDispatcher.forward(req, resp);
		} else {
			resp.sendRedirect(tipoEEndereco[1]);
		}

//		String path = null;
//
//		if(paramAcao.equals("listaempresas")) {
//			ListaEmpresas acao = new ListaEmpresas();
//			path = acao.executa(req, resp);
//		} else if (paramAcao.equals("removeempresa")) {
//			RemoveEmpresa acao = new RemoveEmpresa();
//			path = acao.executa(req, resp);
//		} else if (paramAcao.equals("mostraempresa")) {
//			MostraEmpresa acao = new MostraEmpresa();
//			path = acao.executa(req, resp);
//		} else if (paramAcao.equals("alteraempresa")) {
//			AlteraEmpresa acao = new AlteraEmpresa();
//			path = acao.executa(req,resp);
//		} else if (paramAcao.equals("novaempresa")) {
//			NovaEmpresa acao = new NovaEmpresa();
//			path = acao.executa(req, resp);
//		} else if (paramAcao.equals("novaempresaform")) {
//			NovaEmpresaForm acao = new NovaEmpresaForm();
//			path = acao.executa(req, resp);
//		}




	}

}
