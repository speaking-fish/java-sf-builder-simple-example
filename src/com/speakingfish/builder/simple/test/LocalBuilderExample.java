package com.speakingfish.builder.simple.test;

/**
 * Sample of some additional builder initialization.
 * Who can not be put in NewBaseClass constructor or NewBaseClass.Builder.
 */
public class LocalBuilderExample {
    
    protected final double base;
    
    public LocalBuilderExample(double base) {
        super();
        this.base = base;
    }

    public class BaseBuilder extends NewBaseClass.BuilderImpl {
        
        public NewBaseClass create() {
            if(!Double.isNaN(base)) {
                first  = (int) Math.round(base) + first;
                if(!Double.isNaN(base)) {
                    second = base + second;
                } else {
                    second = base;
                }
            }
            return new NewBaseClass(this);
        };
        
    }
    
    public static void main(String[] args) {
        LocalBuilderExample context = new LocalBuilderExample(100);
        NewBaseClass result = context.new BaseBuilder(){{first = 5; second = 9.5;}}.create();
        System.out.println(result);
    }    

}
