package no.comp.astn2025.command;

import jakarta.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class AbstractCommandProvider implements CommandProvider, JSONMapper, AttributeProvider {
    private Map<CommandProvider.HttpMethod, Map<Pattern, Command>> commands = new HashMap<>();

    @Override
    public Command findCommand(HttpServletRequest request) {
        Map<Pattern, Command> methodGrouppedCommands = this.commands.get(HttpMethod.valueOf(request.getMethod()));

        for (Pattern pattern: methodGrouppedCommands.keySet()) {
            Matcher matcher = pattern.matcher(request.getPathInfo());
            if (matcher.matches()) {
                Pattern groupNames = Pattern.compile("\\(\\?<([a-zA-Z][a-zA-Z0-9]*)>");
                Matcher groupNamesMatcher = groupNames.matcher(pattern.toString());

                while (groupNamesMatcher.find()) {
                    String groupName = groupNamesMatcher.group(1);
                    String value = matcher.group(groupName);
                    request.setAttribute(groupName, value);
                }

                return methodGrouppedCommands.get(pattern);
            }
        }

        return null;
    }

    @Override
    public void addCommand(Pattern pattern, Command command) {
        this.addCommand(HttpMethod.GET, pattern, command);
    }

    @Override
    public void addCommand(HttpMethod method, Pattern pattern, Command command) {
        if (!this.commands.containsKey(method)) {
            this.commands.put(method, new HashMap<>());
        }

        this.commands.get(method).put(pattern, command);
    }
}
