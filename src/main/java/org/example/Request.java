package org.example;

import java.util.HashMap;
import java.util.Map;

public class Request {
    private String actionCode;
    private Map<String, String> params = new HashMap<>();

    public Request(String answer) {

        String[] answerbits = answer.split("\\?", 2);
        actionCode = answerbits[0];

        if (answerbits.length == 1) return;

        String[] paramsbits = new String[]{answerbits[1]};

        for (String splitanswers : paramsbits) {
            String[] splitparams = splitanswers.split("=", 2);
            String key = splitparams[0];
            String value = splitparams[1];
            params.put(key, value);
        }
    }
    public String getActioncode() {
        return actionCode;
    }
    public String getParam(String name){
        return params.get(name);
    }
    public int getIntParams(String name, int defaultValue){
        try {
            return Integer.parseInt(params.get(name));
        }catch (NumberFormatException e){

        }
        return defaultValue;
    }
}
