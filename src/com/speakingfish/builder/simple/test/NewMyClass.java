package com.speakingfish.builder.simple.test;

public class NewMyClass {

    public static class Builder {
        public int    first  = -1        ;
        public double second = Double.NaN;
        public String third  = null      ;
        
        public NewMyClass create() { return new NewMyClass(this); }
        
    }
    
    protected final int    first ;
    protected final double second;
    protected final String third ;
    
    protected NewMyClass(Builder builder) {
        super();
        this.first = builder.first ;
        this.second= builder.second;
        this.third = builder.third ;
    }

    public int    first () { return first ; }
    public double second() { return second; }
    public String third () { return third ; }
    
    @Override public String toString() {
        return "MyClass [first=" + first + ", second=" + second + ", third=" + third + "]";
    }

    public static void main(String[] args) {
        NewMyClass my = new NewMyClass.Builder(){{ first = 1; third = "3"; }}.create();
        System.out.println(my);
    }

}
