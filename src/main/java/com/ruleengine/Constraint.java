package com.ruleengine;

/**
 * Created by pmandrek on 7/1/14.
 */
public interface Constraint<Type> {
    Boolean evaluate(Type value1, InEqualityOperator operator, Type value2);
}
