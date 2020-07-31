package com.github.yashashripendse;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.lang.instrument.ClassFileTransformer;
import java.lang.instrument.IllegalClassFormatException;
import java.security.ProtectionDomain;

public class YashashriClassFileTransformer implements ClassFileTransformer {

    @Override
    public byte[] transform(Module module, ClassLoader loader, String className, Class<?> classBeingRedefined, ProtectionDomain protectionDomain, byte[] classfileBuffer) throws IllegalClassFormatException {
        if (className.equals("com/github/yashashripendse/App")){
            final ClassReader classReader;
            try {
                classReader = new ClassReader(new ByteArrayInputStream(classfileBuffer));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            final ClassWriter classWriter = new ClassWriter(ClassWriter.COMPUTE_MAXS);
            classReader.accept(new AppClassVisitor(Opcodes.ASM8, classWriter), 0);
            return classWriter.toByteArray();
        }
        return classfileBuffer;
    }

}
