package com.github.yashashripendse;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

public class AppClassVisitor extends ClassVisitor {
    private final int api;
    public AppClassVisitor(int api, ClassWriter classVisitor) {
        super(api, classVisitor);
        this.api = api;
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
        var methodVisitor = super.visitMethod(access, name, descriptor, signature, exceptions);
        if (name.equals("main")){
            return new RandomExceptionAdapter(api, methodVisitor, access, name, descriptor);
        }
        return methodVisitor;
    }
}
