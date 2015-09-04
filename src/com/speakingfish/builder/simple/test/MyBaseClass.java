package com.speakingfish.builder.simple.test;

public class MyBaseClass {

    protected static class BuilderImpl {
        public int    first  = -1        ;
        public double second = Double.NaN;
        public String third  = null      ;
    }
    
    public static class Builder extends BuilderImpl {
        
        public MyBaseClass create() {
            return new MyBaseClass(
                first ,
                second,
                third
                );
        }
        
    }
    
    protected final int    first ;
    protected final double second;
    protected final String third ;
    
    protected MyBaseClass(
        int    first ,
        double second,
        String third
    ) {
        super();
        this.first = first ;
        this.second= second;
        this.third = third ;
    }

    public int    first () { return first ; }
    public double second() { return second; }
    public String third () { return third ; }
    
    @Override public String toString() {
        return "MyClass [first=" + first + ", second=" + second + ", third=" + third + "]";
    }

    public static void main(String[] args) {
        MyBaseClass my = new MyBaseClass.Builder(){{ first = 1; third = "3"; }}.create();
        System.out.println(my);
    }

}
