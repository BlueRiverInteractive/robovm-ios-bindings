RoboVM iOS Bindings
===================

A collection of third party bindings for RoboVM iOS.

## How do I use these bindings?

1. Fetch this repository or download it as a zip.

2. Import the project of the binding you want into Eclipse.

3. Add that project to the build path of your main RoboVM project.

4. Open the robovm.xml file of the binding and your main RoboVM project.

5. Copy the <libs>, <frameworks>, <weakFrameworks> and <resources> section to your project’s robovm.xml file and update the paths to correctly point to the linked files.

6. To find out how to use the binding take a look at its Sample class for basic usage.

## How do I create a binding?

When you want to create a binding, you should have a basic knowledge of the syntax of Objective-C. Also it wouldn’t hurt if you know how to use Xcode and how static libraries work.
This tutorial will guide you in creating a fully working binding of the Facebook iOS SDK.

# Analyzing the framework or SDK

XX

# Creating a binding project


# A new Java class for each Objective-C class


# Binding methods


# Binding properties


# Binding blocks


# Binding delegates






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