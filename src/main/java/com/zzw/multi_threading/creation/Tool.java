package com.zzw.multi_threading.creation;

import java.util.Optional;
import java.util.Random;

public class Tool {
    public static void randomPause(int time) {
        Random random = new Random();
        random.nextInt();
    }
}

class Test {
    public static void main(String[] args) {
        System.out.println(Optional.ofNullable("input")
                .map(Test::getOutput));
        System.out.println(Optional.ofNullable("input")
                .map(Test::getOutputOpt));

//        Optional<String> s = Optional.of("input");
//        System.out.println(s.map(Test::getOutput));
//        System.out.println(s.flatMap(Test::getOutputOpt));
    }

    static Optional<String> getOutputOpt(String input) {
        return input == null ? Optional.empty() : Optional.of("output for " + input);
    }

    static String getOutput(String input) {
        return input == null ? null : "output for " + input;
    }
}
