package no.comp.astn2025.command;

import jakarta.servlet.http.HttpServletRequest;

public interface AttributeProvider {
    public default int getIntegerAttribute(String attributeName, HttpServletRequest request) {
        int result = 0;
        try {
            result = Integer.valueOf((String)request.getAttribute(attributeName));
        } catch (Exception exc) { exc.printStackTrace(); throw new RuntimeException(exc); }
        return result;
    }

    public default String getStringAttribute(String attributeName, HttpServletRequest request) {
        String result = "";
        result = (String)request.getAttribute(attributeName);
        return result;
    }
}
