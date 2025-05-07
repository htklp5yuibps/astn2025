package no.comp.astn2025.command.impl;

import no.comp.astn2025.command.AbstractCommandProvider;

import java.util.regex.Pattern;

public class UserCommandProviderImpl extends AbstractCommandProvider {
    public UserCommandProviderImpl() {
        this.addCommand(Pattern.compile("/users"), (request, response) -> {
            response.getWriter().write("Hello, world");
        });
    }
}
