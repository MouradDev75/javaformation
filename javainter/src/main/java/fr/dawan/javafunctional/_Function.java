package fr.dawan.javafunctional;

import java.util.function.Function;

public class _Function {
    public static void main(String[] args) {

        int r1 = incrementByOne(10);
        int r2 = incrementByOneFunction.apply(10);



    }

    static int incrementByOne(int x){
        return x+1;
    }

    static Function<Integer, Integer> incrementByOneFunction = (x) -> x+1;
}
