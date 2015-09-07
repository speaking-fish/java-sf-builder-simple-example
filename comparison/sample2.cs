public class BaseClass {

    public const int DefaultFirst = -1;
    public const double DefaultSecond = double.NaN;
    public const string DefaultThird = null;

    public int First { get; }
    public double Second { get; }
    public string Third { get; }

    public BaseClass(int first = DefaultFirst, double second = DefaultSecond, string third = DefaultThird) {
        First = first;
        Second = second;
        Third = third;
    }

}

public class ChildClass : BaseClass {

    public const object DefaultFourth = null;

    public object Fourth { get; }

    public ChildClass(int first = DefaultFirst, double second = DefaultSecond, string third = DefaultThird, object fourth = DefaultFourth)
        : base(first, second, third) {
        Fourth = fourth;
    }

}