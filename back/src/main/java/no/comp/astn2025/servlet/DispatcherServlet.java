package no.comp.astn2025.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import no.comp.astn2025.command.CommandProvider;
import no.comp.astn2025.command.impl.UserCommandProviderImpl;
import no.comp.astn2025.configuration.ConnectionPool;

import java.io.IOException;

@WebServlet(urlPatterns = {"/*"})
public class DispatcherServlet extends HttpServlet {
    CommandProvider commandProvider = new UserCommandProviderImpl();
    ConnectionPool connPool;

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        this.connPool = ConnectionPool.getInstance();
        System.out.println(req.getPathInfo());

        try {
            commandProvider.findCommand(req).execute(req, resp);
        } catch (Exception exc) { throw new RuntimeException(exc); }
    }
}
