public class BaseClass {

    protected static class BuilderImpl { public int first = -1; public double second = Double.NaN; public String third = null; }

    public static class Builder extends BuilderImpl {
        public BaseClass create() { return new BaseClass(this); }
    }

    protected BaseClass(BuilderImpl src) {
        first = src.first;
        second = src.second;
        third = src.third;
    }

}

public class ChildClass extends BaseClass {

    protected static class BuilderImpl extends BaseClass.BuilderImpl { public Object fourth = null; }

    public static class Builder extends BuilderImpl {
        public ChildClass create() { return new ChildClass(this); }
    }

    protected ChildClass(BuilderImpl src) {
        super(src);
        fourth = src.fourth;
    }

    public Object fourth() { return fourth; }

}