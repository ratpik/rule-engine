package com.ruleengine;

/**
 * Created by pmandrek on 7/1/14.
 */



public class Rule<Type> {

    private Constraint constraint;
    private Action action;

    private Type param1;
    private Type param2;
    private InEqualityOperator operator;


    public Rule(Type param1, InEqualityOperator operator, Type param2, Constraint constraint, Action action){

        this.constraint = constraint;
        this.action = action;

        this.param1 = param1;
        this.param2 = param2;
        this.operator = operator;

    }

    public static boolean getResult(LogicalOperator operator, Action action, SubRule ... subRules){

        if(subRules == null || subRules.length ==0){
            return Boolean.FALSE;
        }

        boolean result = subRules[0].getResult();

        for(int i= 1; i < subRules.length; i++){
            result = operator.apply(result, subRules[i].getResult());
        }

        return result;
    }

    public boolean getResult(){
        return this.constraint.evaluate(param1, operator, param2);
        //return operator.apply(param1, param2);
    }

    public Action getAction(){
        return this.action;
    }




    public static void main(String[] args){


        Constraint doubleConstraint = new Constraint<Double>() {
            @Override
            public Boolean evaluate(Double value1, InEqualityOperator operator, Double value2) {
                return operator.apply(value1, value2);
            }
        };

        Action action = new Action("Hello", Rule.class, null){

            @Override
            public void execute() {
                System.out.println("Executing action");
            }
        };

        Rule r = new Rule<Double>(2.0, InEqualityOperator.EQUAL, 2.0, doubleConstraint, action);
        Boolean result = r.getResult();
        if(result == Boolean.TRUE){
            r.getAction().execute();
        }

        System.out.print("Result " + result);

        SubRule<Double> s1 = new SubRule<Double>(2.0, InEqualityOperator.EQUAL, 3.0, doubleConstraint);
        SubRule<Double> s2 = new SubRule<Double>(2.0, InEqualityOperator.LESSTHANEQUAL, 3.0, doubleConstraint);

        result = Rule.getResult(LogicalOperator.OR, action, s1, s2);

        System.out.println("Result from subrules " + result);

    }


}
