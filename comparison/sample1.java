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
        this.first= builder.first;
        this.second= builder.second;
        this.third= builder.third;
    }

    public int first() { return first; }
    public double second() { return second; }
    public String third() { return third; }

    @Override public String toString() { return "" + getClass() + " - first: " + first + ", second: " + second + ", third: " + third; }

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

    @Override public String toString() { return super.toString() + ", fourth: " + fourth; }

    public static void main(String[] args) {
        System.out.println(new BaseClass.Builder(){{ first = 1; third = "3"; }}.create());
        System.out.println(new ChildClass.Builder(){{ first = 1; third = "3"; fourth = 4; }}.create());
    }

}