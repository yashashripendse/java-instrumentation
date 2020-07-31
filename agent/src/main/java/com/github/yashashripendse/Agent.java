package com.github.yashashripendse;

import java.lang.instrument.Instrumentation;

public class Agent {

    public static void premain (String agent_args, Instrumentation inst){
        System.out.println("hello world from our agent");
    }
}
