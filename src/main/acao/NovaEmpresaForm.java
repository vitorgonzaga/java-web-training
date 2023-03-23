package main.acao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class NovaEmpresaForm implements Acao {

    public String executa (HttpServletRequest req, HttpServletResponse resp) {

        return "forward:formNovaEmpresa.jsp";

    }

}
