package com.github.yashashripendse;

import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

public class YashashriClassFileTransformer implements ClassFileTransformer {

    @Override
    public byte[] transform(Module module, ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        if (className.equals("com/github/yashashripendse/App")){
            System.out.println("had a chance to transform, " + className);
        }
        return classfileBuffer;
    }
}
