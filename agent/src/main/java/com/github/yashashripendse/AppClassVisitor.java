package com.github.yashashripendse;

import org.objectweb.asm.ClassVisitor;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.MethodVisitor;

public class AppClassVisitor extends ClassVisitor {
    public AppClassVisitor(int api, ClassWriter classVisitor) {
        super(api, classVisitor);
    }

    @Override
    public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
        var methodVisitor = super.visitMethod(access, name, descriptor, signature, exceptions);
        System.out.println("had a chance to transform method: " + name);
        return methodVisitor;
    }
}
