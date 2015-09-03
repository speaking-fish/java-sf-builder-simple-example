package com.speakingfish.builder.simple.test;

public class MyClass {

    public static class Builder {
        public int    first  = -1        ;
        public double second = Double.NaN;
        public String third  = null      ;
        
        public MyClass create() {
            return new MyClass(
                first ,
                second,
                third
                );
        }
        
    }
    
    protected final int    first ;
    protected final double second;
    protected final String third ;
    
    protected MyClass(
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
        MyClass my = new MyClass.Builder(){{ first = 1; third = "3"; }}.create();
        System.out.println(my);
    }

}
