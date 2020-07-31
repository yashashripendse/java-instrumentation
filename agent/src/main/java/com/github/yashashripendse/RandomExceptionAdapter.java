package com.github.yashashripendse;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.Type;
import org.objectweb.asm.commons.AdviceAdapter;
import org.objectweb.asm.commons.Method;

public class RandomExceptionAdapter extends AdviceAdapter {

    private final String descriptor;

    protected RandomExceptionAdapter(int api, MethodVisitor methodVisitor, int access, String name, String descriptor) {
        super(api, methodVisitor, access, name, descriptor);
        this.descriptor = descriptor;
    }

    @Override
    protected void onMethodEnter() {
        super.onMethodEnter();
        Method method = Method.getMethod("void randomBlowup()");
        invokeStatic(Type.getType(RandomExceptionSensor.class), method);
    }
}
