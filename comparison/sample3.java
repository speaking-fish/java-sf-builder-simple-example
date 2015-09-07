public class BaseClass {

    protected static class BuilderImpl { public int first = -1; public double second = Double.NaN; public String third = null; }

    public static class Builder extends BuilderImpl {
        public BaseClass create() { return new BaseClass(this); }
    }

// skip fields and getters

    protected BaseClass(BuilderImpl builder) {
        super();
        this.first = builder.first;
        this.second = builder.second;
        this.third = builder.third;
    }

}

public class ChildClass extends BaseClass {

    protected static class BuilderImpl extends BaseClass.BuilderImpl { public Object fourth = null; }

    public static class Builder extends BuilderImpl {
        public ChildClass create() { return new ChildClass(this); }
    }

// skip fields and getters

    protected ChildClass(BuilderImpl builder) {
        super(builder);
        this.fourth = builder.fourth;
    }

    public Object fourth() { return fourth; }

}