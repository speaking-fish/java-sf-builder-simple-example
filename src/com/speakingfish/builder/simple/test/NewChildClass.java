package com.speakingfish.builder.simple.test;

public class NewChildClass extends NewBaseClass {

    protected static class BuilderImpl extends NewBaseClass.BuilderImpl {
        public Object fourth = null;
    }
    
    public static class Builder extends BuilderImpl {
        public NewChildClass create() { return new NewChildClass(this); }
    }
    
    protected final Object fourth;
    
    protected NewChildClass(BuilderImpl builder) {
        super(builder);
        this.fourth = builder.fourth;
    }

    public Object fourth() { return fourth; }

    @Override public String toString() {
        return "MyChildClass [first=" + first + ", second=" + second + ", third=" + third + ", fourth=" + fourth + "]";
    }

    public static void main(String[] args) {
        NewChildClass my = new NewChildClass.Builder(){{ first = 1; third = "3"; fourth = 4; }}.create();
        System.out.println(my);
    }

}
