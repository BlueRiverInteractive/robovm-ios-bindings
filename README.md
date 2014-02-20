robovm-ios-bindings
===================

A collection of third party bindings for RoboVM iOS.

## How do I create a binding?

A good starter tutorial can be found here:
http://www.sevenarmedsquid.com/help/robovmbinding

Also check out the existing bindings. You will clearly find out a pattern that is common across all bound obj-c classes, blocks and delegates. Just take a look at these classes.

When you submit a binding as a pull request be sure to use the following namespace:
> org.robovm.bindings.*bindingname*

Also please try to use Java naming conventions were applicable.
For example:

```objc
typedef enum FBErrorCode {
    FBErrorInvalid = 0,
    FBErrorOperationCancelled,
} FBErrorCode;
```
becomes:
```Java
public enum FBErrorCode implements ValuedEnum {
    Invalid(0),
    OperationCancelled(1);

    private final long n;

    private FBErrorCode (long n) {
        this.n = n;
    }

    @Override
    public long value () {
        return n;
    }
}
```