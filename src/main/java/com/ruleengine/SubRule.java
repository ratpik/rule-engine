package com.ruleengine;

/**
 * Created by pmandrek on 8/1/14.
 */
public class SubRule<Type> {
    //We do not care about subrule's actions

    private Constraint constraint;

    private Type param1;
    private Type param2;
    private InEqualityOperator operator;


    public SubRule(Type param1, InEqualityOperator operator, Type param2, Constraint constraint){

        this.constraint = constraint;

        this.param1 = param1;
        this.param2 = param2;
        this.operator = operator;

    }


    public boolean getResult(){
        return this.constraint.evaluate(param1, operator, param2);

    }


}
