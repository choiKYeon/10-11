package org.example;
import java.util.HashMap;
import java.util.Map;
public class Request {
    private String actionCode;
    private Map<String, String> params = new HashMap<>();
    public Request(String command) {
        String[] commandBits = command.split("\\?", 2);
        // 삭제?id=1 & 삭제?id=2 & 삭제?id=3
        actionCode = commandBits[0];
        if (commandBits.length == 1) return;
        String[] paramsBits = commandBits[1].split("&");
        for (String paramStr : paramsBits) {
            String[] paramStrBits = paramStr.split("=",2);
            if (paramStrBits.length == 1) {
                continue;
            }
            String key = paramStrBits[0];
            String value = paramStrBits[1];
            params.put(key, value);
        }
    }
    public String getActionCode() {
        return this.actionCode;
    }
    public String getParam(String name) {
        return params.get(name);
    }

    public int getParam (String name, int defaultValue) {
        try {
            return Integer.parseInt(getParam(name));
        } catch (NumberFormatException e) {

        }
        return defaultValue;
    }
}