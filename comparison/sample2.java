public class BaseClass {

    protected static class BuilderImpl { public int first = -1; public double second = Double.NaN; public String third = null; }

    public static class Builder extends BuilderImpl {
        public BaseClass create() { return new BaseClass(this); }
    }

    protected int first;
    protected double second;
    protected String third;

    protected BaseClass(BuilderImpl builder) {
        super();
        this.first = builder.first;
        this.second = builder.second;
        this.third = builder.third;
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

    protected ChildClass(BuilderImpl builder) {
        super(builder);
        this.fourth = builder.fourth;
    }

    public Object fourth() { return fourth; }

}