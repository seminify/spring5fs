package org.seminify.spring5fs.typehier;

public class ConsolePrinter implements Printer {
    @Override
    public void print(String msg) {
        System.out.println(msg);
    }
}
