package org.seminify.spring5fs;

public class Greeter {
    private String format;

    public void setFormat(String format) {
        this.format = format;
    }

    public String greet(String guest) {
        return String.format(format, guest);
    }
}
