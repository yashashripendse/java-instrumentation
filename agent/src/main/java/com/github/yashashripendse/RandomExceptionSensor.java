package com.github.yashashripendse;

public class RandomExceptionSensor {

    /** invoked via instrumentation */
    @SuppressWarnings("unused")
    public static void randomBlowup() {
        if (Math.random() < 0.5) {
            final var boomMessage = "Boom :💥";
            System.out.println(boomMessage);
            //throw new RuntimeException(boomMessage);
        } else {
            System.out.println("Safe :✅");
        }
    }

}
