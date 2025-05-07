package no.comp.astn2025.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import no.comp.astn2025.command.Command;
import no.comp.astn2025.command.CommandProvider;
import no.comp.astn2025.command.impl.UserCommandProviderImpl;

import java.io.IOException;

@WebServlet(urlPatterns = {"/*"})
public class DispatcherRervlet extends HttpServlet {

    CommandProvider commandProvider = new UserCommandProviderImpl();

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            commandProvider.findCommand(req).execute(req, resp);
        } catch (Exception exc) { throw new RuntimeException(); }
    }
}
