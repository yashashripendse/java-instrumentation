package com.github.yashashripendse;

import org.objectweb.asm.MethodVisitor;
import org.objectweb.asm.commons.AdviceAdapter;

public class RandomExceptionAdapter extends AdviceAdapter {

    private final String descriptor;

    protected RandomExceptionAdapter(int api, MethodVisitor methodVisitor, int access, String name, String descriptor) {
        super(api, methodVisitor, access, name, descriptor);
        this.descriptor = descriptor;

    }

    @Override
    protected void onMethodEnter() {
        super.onMethodEnter();
        System.out.println("method entered, " + descriptor);
    }
}
