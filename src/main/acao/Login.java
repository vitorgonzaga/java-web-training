package main.acao;

import main.modelo.Banco;
import main.modelo.Usuario;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.NoSuchElementException;

public class Login implements Acao {

    @Override
    public String executa(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String login = req.getParameter("login");
        String senha = req.getParameter("senha");
        // Usuario usuarioLogin = new Usuario(login, senha);

        System.out.println("logando " + login);

        Banco banco = new Banco();
        try {
            Usuario usuario = banco.buscaUsuario(login, senha);
            HttpSession session = req.getSession();
            session.setAttribute("usuarioLogado", usuario);
            System.out.println(usuario);
        } catch (NoSuchElementException e) {
            req.setAttribute("loginError", "true");
            // return "forward:formLogin.jsp";
            return "redirect:entrada?acao=LoginForm";
        }

        return "redirect:entrada?acao=ListaEmpresas";

    }
}
