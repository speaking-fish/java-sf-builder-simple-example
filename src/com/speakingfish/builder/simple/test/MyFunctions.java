package com.speakingfish.builder.simple.test;

import java.util.List;

import static java.util.Arrays.*;

/**
 * 
 * Micro builder samples
 *
 */
public class MyFunctions {

    /**
     * Abstract micro-builder sample
     */
    public static class fn {
        public int    first  = -1        ;
        public double second = Double.NaN;
        public String third  = null      ;
        
        public String invoke() { return "" + first + ", " + second + ", " + third; }
    }

    
    /**
     * Abstract micro-builder inheritance sample
     */
    
    public abstract static class fn_base_impl {
        public int    first  = -1        ;
        public double second = Double.NaN;
        public String third  = null      ;
        
        protected String invoke_fn() { return "" + first + ", " + second + ", " + third; }
    }
    
    public static class fn_base extends fn_base_impl {
        
        public String invoke() { return invoke_fn(); }
    }
    
    public static class fn_child_impl extends fn_base_impl {
        public Object fourth;
        protected StringBuilder invoke_fn_child() { return new StringBuilder(invoke_fn()).append(fourth); }
    }
    
    public static class fn_child extends fn_child_impl {
        public Object fourth;
        
        public StringBuilder invoke() { return invoke_fn_child(); }
    }


    /**
     * Parameterized micro-builder sample
     */
    public static class param<THIRD> {
        public int    first  = -1        ;
        public double second = Double.NaN;
        public THIRD  third  ; // parameterized fields can't have default value
        
        public String invoke() {  return "" + first + ", " + second + ", " + third; }
    }
    
    /**
     * More useful micro-builder sample 
     */
    public static class generateIntArray {
        public int[] appendTo  = null;
        public int   fill      = 0   ;
        public int   increment = 0   ;

        /**
         * @param count required parameter
         * @return
         */
        public int[] invoke(int count) {
            if(0 == count) {
                if(null == appendTo) {
                    return new int[0];
                } else {
                    return appendTo.clone();
                }
            } else {
                final int[] result;
                final int resultLength;
                final int startFrom;
                if(null == appendTo) {
                    result = new int[count];
                    resultLength = count;
                    startFrom = 0;
                } else {
                    startFrom = appendTo.length;
                    resultLength = startFrom + count;
                    result = new int[resultLength];
                    System.arraycopy(appendTo, 0, result, 0, startFrom);
                }
                if(0 == increment) {
                    fill(result, startFrom, result.length, fill);
                } else {
                    int value = fill;
                    for(int i = startFrom; i < resultLength; ++i, value+= increment) {
                        result[i] = value;
                    }
                }
                return result;
            }
        }
        
    }
    
    public static void main(String[] args) {
        
        String fn = new fn(){{ first = 1; third = "3"; }}.invoke();
        System.out.println(fn);

        String fn_base = new fn_base(){{ first = 1; third = "3"; }}.invoke();
        System.out.println(fn_base);
        
        StringBuilder fn_child = new fn_child(){{ first = 1; third = "3"; fourth = 4; }}.invoke();
        System.out.println(fn_child);
        
        String param = new param<List<String>>(){{ first = 1; third = asList("3", "4", "5"); }}.invoke();
        System.out.println(param);
        
        Object[] arrays = new Object[] {"\n",
            new generateIntArray(){{}}.invoke(10), "\n",
            new generateIntArray(){{ fill = 1; }}.invoke(10), "\n",
            new generateIntArray(){{ increment = 1; }}.invoke(10), "\n",
            new generateIntArray(){{ appendTo = new int[] {1,2,3}; }}.invoke(10), "\n",
            new generateIntArray(){{ appendTo = new int[] {1,2,3,4,5}; fill = 10; increment = 10; }}.invoke(10)
        };
        System.out.println(deepToString(arrays));
        
    }

}
