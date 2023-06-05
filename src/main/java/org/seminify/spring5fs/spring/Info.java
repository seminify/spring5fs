package org.seminify.spring5fs.spring;

import org.springframework.beans.factory.annotation.Value;

public class Info {
    @Value("${info.version}")
    private String version;

    public void setVersion(String version) {
        this.version = version;
    }

    public void printinfo() {
        System.out.println("version = " + version);
    }
}
