package main.servlet;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;
import main.modelo.Banco;
import main.modelo.Empresa;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/empresas")
public class EmpresasService extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<Empresa> empresas = new Banco().getData();

        /*
        // Returning json type
        Gson gson = new Gson();
        String json = gson.toJson(empresas);

        resp.setContentType("application/json");
        resp.getWriter().print(json);
        */

        // Returning xml type
        XStream xstream = new XStream();
        xstream.alias("empresa", Empresa.class);
        String xml = xstream.toXML(empresas);

        resp.setContentType("application/xml");
        resp.getWriter().print(xml);

    }
}
