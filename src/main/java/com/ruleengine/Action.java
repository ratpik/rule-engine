package com.ruleengine;

/**
 * Created by pmandrek on 7/1/14.
 */
public abstract class Action {

    private String message;
    private Class activity;
    private String bundle;

    //Perhaps message could be a resource reference int
    //Input could be a generic map
    public Action(String message, Class activity, String bundle){
        this.message = message;
        this.activity = activity;
        this.bundle  = bundle;
    }

    public abstract void execute();

}
