package no.comp.astn2025.command;

import jakarta.servlet.http.HttpServletRequest;

import java.util.regex.Pattern;

public interface CommandProvider {
    public Command findCommand(HttpServletRequest request);
    public void addCommand(Pattern pattern, Command command);
    public void addCommand(HttpMethod method, Pattern pattern, Command command);

    enum HttpMethod {
        GET, POST, PUT, DELETE
    }
}
