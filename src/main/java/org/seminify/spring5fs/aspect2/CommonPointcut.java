package org.seminify.spring5fs.aspect2;

import org.aspectj.lang.annotation.Pointcut;

public class CommonPointcut {
    @Pointcut("execution(public * org.seminify.spring5fs.spring..*(..))")
    public void commonTarget() {
    }
}
