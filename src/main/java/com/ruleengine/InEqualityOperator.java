package com.ruleengine;

/**
 * Created by pmandrek on 7/1/14.
 */
public enum InEqualityOperator {

    LESSTHANEQUAL("<=") {
        @Override public Boolean apply(double x1, double x2) {
            return x1 <= x2;
        }
    },
    EQUAL("==") {
        @Override public Boolean apply(double x1, double x2) {
            return x1 == x2;
        }

    };



    // You'd include other operators too...

    private final String text;

    private InEqualityOperator(String text) {
        this.text = text;
    }

    // Yes, enums *can* have abstract methods. This code compiles...
    public abstract Boolean apply(double x1, double x2);


    @Override public String toString() {
        return text;
    }

}
