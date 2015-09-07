public class BaseClass {

    protected static class BuilderImpl { public int first = -1; public double second = Double.NaN; public String third = null; }

    public static class Builder extends BuilderImpl {
        public BaseClass create() { return new BaseClass(this); }
    }

    protected int first;
    protected double second;
    protected String third;

    protected BaseClass(BuilderImpl src) {
        first = src.first;
        second = src.second;
        third = src.third;
    }

    public int first() { return first; }
    public double second() { return second; }
    public String third() { return third; }

}

public class ChildClass extends BaseClass {

    protected static class BuilderImpl extends BaseClass.BuilderImpl { public Object fourth = null; }

    public static class Builder extends BuilderImpl {
        public ChildClass create() { return new ChildClass(this); }
    }

    protected Object fourth;

    protected ChildClass(BuilderImpl src) {
        super(src);
        fourth = src.fourth;
    }

    public Object fourth() { return fourth; }

}