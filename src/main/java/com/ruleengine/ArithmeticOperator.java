package com.ruleengine;

/**
 * Created by pmandrek on 7/1/14.
 * Ref http://stackoverflow.com/questions/2902458/is-it-possible-to-pass-arithmetic-operators-to-a-method-in-java
 */
public enum ArithmeticOperator
{
    ADDITION("+") {
        @Override public double apply(double x1, double x2) {
            return x1 + x2;
        }
    },
    SUBTRACTION("-") {
        @Override public double apply(double x1, double x2) {
            return x1 - x2;
        }

    };



    // You'd include other operators too...

    private final String text;

    private ArithmeticOperator(String text) {
        this.text = text;
    }

    // Yes, enums *can* have abstract methods. This code compiles...
    public abstract double apply(double x1, double x2);


    @Override public String toString() {
        return text;
    }
}