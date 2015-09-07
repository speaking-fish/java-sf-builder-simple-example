public class BaseClass {

    public const int DefaultFirst = -1;
    public const double DefaultSecond = double.NaN;
    public const string DefaultThird = null;

// skip fields and getters

    public BaseClass(int first = DefaultFirst, double second = DefaultSecond, string third = DefaultThird) {
        First = first;
        Second = second;
        Third = third;
    }

}

public class ChildClass : BaseClass {

    public const object DefaultFourth = null;

// skip fields and getters

    public ChildClass(int first = DefaultFirst, double second = DefaultSecond, string third = DefaultThird, object fourth = DefaultFourth)
        : base(first, second, third) {
        Fourth = fourth;
    }

}