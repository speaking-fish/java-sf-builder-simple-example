package com.speakingfish.builder.simple.test;

public class MyChildClass extends MyBaseClass {

    protected static class BuilderImpl extends MyBaseClass.BuilderImpl {
        public Object fourth = null;
    }
    
    public static class Builder extends BuilderImpl {
        public MyChildClass create() {
            return new MyChildClass(
                first ,
                second,
                third ,
                fourth
                );
        }
        
    }
    
    
    protected final Object fourth;
    
    protected MyChildClass(
        int    first ,
        double second,
        String third ,
        Object fourth
    ) {
        super(
            first ,
            second,
            third
            );
        this.fourth = fourth;
    }

    public Object fourth() { return fourth; }

    @Override public String toString() {
        return "MyChildClass [first=" + first + ", second=" + second + ", third=" + third + ", fourth=" + fourth + "]";
    }

    public static void main(String[] args) {
        MyChildClass my = new MyChildClass.Builder(){{ first = 1; third = "3"; fourth = 4; }}.create();
        System.out.println(my);
    }

}
