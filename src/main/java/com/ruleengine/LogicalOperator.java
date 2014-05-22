package com.ruleengine;

/**
 * Created by pmandrek on 8/1/14.
 */
public enum LogicalOperator {

    AND("&&") {
        @Override public Boolean apply(Boolean x1, Boolean x2) {
            return x1 && x2;
        }
    },
    OR("||") {
        @Override public Boolean apply(Boolean x1, Boolean x2) {
            return x1 || x2;
        }

    };



    // You'd include other operators too...

    private final String text;

    private LogicalOperator(String text) {
        this.text = text;
    }

    // Yes, enums *can* have abstract methods. This code compiles...
    public abstract Boolean apply(Boolean x1, Boolean x2);


    @Override public String toString() {
        return text;
    }

}
