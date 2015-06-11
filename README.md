RoboVM iOS Bindings
===================

### NOTE: These bindings are going to be deprecated in favor of [RoboPods](https://github.com/robovm/robovm-robopods)



A collection of third party bindings for RoboVM iOS.

## How do I use these bindings?

1. Fetch this repository or download it as a zip.

2. Import the project of the binding you want into Eclipse.

3. Add that project to the build path of your main RoboVM project.

4. Open the `robovm.xml` file of the binding and your main RoboVM project.

5. Copy the `<libs>`, `<frameworks>`, `<weakFrameworks>` and `<resources>` section to your project’s `robovm.xml` file and update the paths to correctly point to the linked files.

6. To find out how to use the binding take a look at its Sample class for basic usage and take a look at the original documentation of the framework or SDK.

## How do I use these bindings with LibGDX 1.x?

1. Go to http://libgdx.badlogicgames.com/robovm-ios-bindings/ and download the JAR file for the binding you want to use

2. Put the JAR file into the `ios/libs` folder of your LibGDX project (create it if need be)

3. Open the `/build.gradle` file and look for the section starting with `project(":ios")`.

4. Look for the `dependencies` section and add the following line:
   ```
   compile fileTree(dir: 'libs', include: '*.jar')
   ```
5. Save and refresh gradle, per usual. (E.g. in Eclipse, right-click on the `-ios` project and choose Gradle -> Refresh All)

Those bindings will now be available within your project as needed. Be sure to download updated JAR files at regular intervals if you want the latest updates.

## How do I create a binding?

When you want to create a binding, you should have a basic knowledge of the syntax of Objective-C. Also it wouldn’t hurt if you know how to use Xcode and how static libraries work.  
This tutorial will guide you in creating a fully working binding of the Google Mobile Ads iOS SDK.

### Analyzing the framework or SDK

First of all, let’s get the AdMob iOS SDK from here: https://developers.google.com/mobile-ads-sdk/download#downloadios.  
Unpack the zip file and check it’s contents. You will see lots of .h files and one .a file.  
The .h files are header files, which expose all accessible interfaces, methods and properties. We will use these files to create our bindings.  
The .a file is comparable to an archive file. It contains multiple versions of the static library for the Ads SDK.  
There is also an additional add-ons folder with more header and library files that we can create bindings for.  
Also check the readme file, which gives you a clue on the required iOS version and where you can find more info on using the library.

### Creating a binding project

Now that you have the necessary files and information, you can start creating the binding project.  
In Eclipse create a new RoboVM iOS project called „admob-ios“. You can now specify the main class, app name and app id for the project. We will create a sample class to test the binding, so let’s specify `org.robovm.bindings.admob.sample.Sample` under main class.

Please always adopt the RoboVM bindings namespace for consistency:

> org.robovm.bindings.*bindingname*

The *app name* becomes „Admob Sample“ and the *app id* just „admob“.  
Leave the other settings as they are and finish the setup.

Open up the newly created project and add the missing packages and the Sample class.

```Java
package org.robovm.bindings.admob.sample;

import org.robovm.apple.foundation.NSAutoreleasePool;
import org.robovm.apple.uikit.UIApplication;
import org.robovm.apple.uikit.UIApplicationDelegateAdapter;

public class Sample extends UIApplicationDelegateAdapter {
	@Override
	public void didFinishLaunching (UIApplication application) {
	}

	public static void main (String[] argv) {
		try (NSAutoreleasePool pool = new NSAutoreleasePool()) {
			UIApplication.main(argv, null, Sample.class);
		}
	}
}
```

Copy the library archive file (*.a) into the libs folder of your binding project.



Now we are ready to create the bindings!

### Binding classes

First of all we will create a Java class for every Objective-C interface. Typically this is one class per header file.  
To be sure, open up each header (.h) file and check if it contains a line starting with `@interface`. The name after `@interface` will become the class name, the name after the colon `:` will become the extended class and the name(s) between the angle brackets `<>` (if any) will become implemented interfaces.  
The syntax would look like this:

> @interface **ClassName** : **ExtendedClassName**<*ImplementedInterfaceName*>

In our case this will be:

- class GADAdMobExtras extends NSObject implements GADAdNetworkExtras
- class GADBannerView extends UIView
- class GADInterstitial extends NSObject
- class GADRequest extends NSObject (**HINT**: NSCopying is not used in RoboVM)
- class GADRequestError extends NSError

Create those classes inside the `org.robovm.bindings.admob` package.
Add the `@NativeClass` annotation to each of this classes. This marks the classes as native Objective-C classes.

Example GADBannerView:
```Java
@NativeClass
public class GADBannerView extends UIView {

}
```

**HINT**: If you are binding Cocoa or CocoaTouch frameworks you should add the `@Library` annotation to the class and specify the necessary framework.
Example CTCallCenter in the CoreTelephony framework:
```Java
@Library("CoreTelephony")
@NativeClass
public class CTCallCenter extends NSObject {

}
```

### Binding methods

Let’s dive deeper into the header file of GADBannerView. Open the file in Eclipse.
The information we need here starts after the line with `@interface`.  
For simplicity let’s copy the whole section until the end of the file into our corresponding Java class. We can now bind part after part and delete the Objective-C code after done.

You can remove the `#pragma mark`. These are just for structuring the header file.
Important for us are those lines that start with a `-` or a `+`.

> `-` = instance methods  
> `+` = static methods

For example, let’s bind this method:
```objc
- (void)loadRequest:(GADRequest *)request;
```
This method is an instance method (`-`), it’s selector/name is `loadRequest:`, it has one parameter `GADRequest request` and the return type is `void`.

In RoboVM we can bind this method like this:
```Java
@Method(selector = "loadRequest:")
public native void loadRequest(GADRequest request);
```

Congratulations! You have now successfully bound your first method.  
Some things to keep in mind:

The selector name can be multiple parts long. In the following example the selector is marked bold:

>  `-` (void)**setLocationWithLatitude:**(CGFloat)latitude **longitude:**(CGFloat)longitude **accuracy:**(CGFloat)accuracyInMeters;

Use Java Bean naming conventions for consistency. Shorten long method names. The example above in Java would be:

```Java
@Method(selector = "setLocationWithLatitude:longitude:accuracy:")
public native void setLocation(float latitude, float longitude, float accuracyInMeters);
```

Don't forget to add the static keyword for methods starting with a `+`:
```objc
/// Creates an autoreleased GADRequest.
+ (instancetype)request;
```
becomes
```Java
@Method(selector = "request")
public static native GADRequest request();
```


### Binding constructors

Constructors can be identified because of their `init` in the selector and/or of the `id` return type. For example:

```objc
- (id)initWithAdSize:(GADAdSize)size;
```

You can bind this constructor like any other method but need to use the return type `long` and the annotation `@Pointer`.

```Java
@Method(selector = "initWithAdSize:")
private native @Pointer long init(GADAdSize size);
```

Make that method private because we don’t want anyone to manually init the object.  
Next you need to create the Java constructor with the same parameters and call that init method inside the inherited initObject(long) method.

```Java
public GADBannerView(GADAdSize size) {
    super((SkipInit)null);
    initObject(init(size));
}
```

Note the super constructor call. This is necessary because otherwise Java would also call the default constructor and initialize our Objective-C object twice.

### Binding properties

Let’s bind the following property:

```objc
@property(nonatomic, copy) NSString *adUnitID;
```

The selector of this property is `adUnitID` and its type is `NSString`.  
We can create a getter and a setter method via the `@Property` annotation:

```Java
@Property(selector = "adUnitID")
public native String getAdUnitID ();

@Property(selector = "setAdUnitID:")
public native void setAdUnitID (String id);
```

Note that we add `set` and `:` to the selector of the setter.  
We can also directly return String instead of NSString. RoboVM automatically converts it for us.

There are a few things we need to keep an eye on:

```objc
@property(nonatomic, readonly) BOOL hasAutoRefreshed;
```

We can only create a getter for this, as it has the readonly modifier.

```objc
@property(nonatomic, assign) NSObject<GADBannerViewDelegate> *delegate
```

When binding delegate properties or other weak/assign properties, we need to retain a strong reference of them, otherwise we will get memory issues and app crashes:

```Java
@Property(selector = "delegate")
public native GADBannerViewDelegate getDelegate();
	
@Property(selector = "setDelegate:", strongRef = true)
public native void setDelegate(GADBannerViewDelegate delegate);
```

**HINT**: You can leave out the selector parameter, if you name the property methods with getProperty/isProperty and setProperty. The example above would still work, if we hadn’t specified the selector parameter of the annotations.

### Binding delegates

To be done…

### Binding blocks

Obj-C blocks can be compared to Java listeners with just one method. A typical example of this is the Runnable class.
These blocks can occur in two forms: 

As a custom type:
```objc
typedef void (^FBAppCallHandler)(FBAppCall *call);

+ (BOOL)handleOpenURL:(NSURL *)url
    sourceApplication:(NSString *)sourceApplication
      fallbackHandler:(FBAppCallHandler)handler;
```

Or inline of an Obj-C method:
```objc
+ (BOOL)handleOpenURL:(NSURL *)url
    sourceApplication:(NSString *)sourceApplication
      fallbackHandler:(void(^)(FBAppCall *call))handler;
```
In any way, you can identify them by the `^` symbol.  
`void` is the return type of this block, `FBAppCallHandler` is the name and `FBAppCall call` is the first parameter of this block.

There are two ways in Java to bind a block type:

**Inline:**
```Java
@Method(selector = "handleOpenURL:sourceApplication:fallbackHandler:")
public static native boolean handleOpenURL(NSURL url, String sourceApplication, @Block VoidBlock1<FBAppCall> handler);
```

The `@Block` annotation is obligatory to identify block types and needs to be applied to the block type. 
RoboVM provides several generic classes that help defining inline blocks:
- **VoidBlockX**: defines a block without return type (void) and *X* amount parameters. In our example we need just one parameter and no return type, therefore we take `VoidBlock1`. 
- **BlockX**: defines a block with return type and *X* amount parameters. The last defined generic type becomes the return type.

**Custom Type:**
```Java
public interface FBAppCallHandler {
  void invoke(FBAppCall call);
}

@Method(selector = "handleOpenURL:sourceApplication:fallbackHandler:")
public static native boolean handleOpenURL(NSURL url, String sourceApplication, @Block FBAppCallHandler handler);
```

You create a custom interface with exactly one function. The function must have the exact return type and parameters as the Obj-C block.
This approach is slightly more work but gives you better readability, as you can name your block and parameters.

Both of these approaches apply two both forms of Obj-C blocks.

**HINT**: If you need to define a void block with no parameter, you can just use `@Block Runnable`.

### Binding structs

To be done...

### Binding C functions

To be done...

### Binding enums

In Objective-C there are typically two ways to define enums.  
In GADRequest.h we find this:

```objc
typedef NS_ENUM(NSInteger, GADGender) {
  kGADGenderUnknown,  ///< Unknown gender.
  kGADGenderMale,     ///< Male gender.
  kGADGenderFemale    ///< Female gender.
};
```

This is actually the same as:
```objc
typedef enum {
  kGADGenderUnknown,  ///< Unknown gender.
  kGADGenderMale,     ///< Male gender.
  kGADGenderFemale    ///< Female gender.
} GADGender;
```

We can bind this as a Java valued enum:

```Java
public enum GADGender implements ValuedEnum {
  Unknown(0),
  Male(1),
  Female(2);

  private final long n;
  
  private GADGender (long n) {
    this.n = n;
  }

  @Override
  public long value () {
    return n;
  }
}
```

The names of the enum constants is unimportant but the order and value is not. It can happen that some enum constants have the same value as other constants in Objective-C, thus they need to have the same value in Java.  
For example:

```objc
kGADExampleEmpty = 0,
kGADExampleFalse,
kGADExampleTrue,
kGADExampleError = kGADExampleFalse,
kGADExampleNetworkError = 1 | (1 << 9)
```
In Java:

```Java
Empty(0),
False(1),
True(2),
Error(1),
NetworkError(1 | (1 << 9))
```

Don't be scared if you find an enum without any name:
```objc
enum {
   kGADExampleTypeFirst,
   kGADExampleTypeSecond
};
```
Just invent a proper enum name:
```Java
public enum GADExampleType implements ValuedEnum {
   ...
}
```

### Binding bitmasks

To be done…

### Binding global values 

Global values in Obj-C can be identified by the `extern` and the `const` keyword.
For example:

```objc
extern GADAdSize const kGADAdSizeBanner;
```

The name of this global value is `kGADAdSizeBanner` and the type `GADAdSize`.
We can bind this value in Java like this:

```Java
@GlobalValue(symbol = "kGADAdSizeBanner", optional=true)
public static native @ByVal GADAdSize Banner();
```

Global values are always static and can have any name you want.  
The `optional` parameter is used to weakly bind this global value. This prevents the binding from crashing if it used on any OS or library version that doesn't support this global value.  

The @ByVal annotation is only needed for struct types as explained in the structs section.

### Binding constants

C constants are identified by the `#define` keyword and don't need to be bound in any way. You just take the value of the constant and create a Java constant with that value.

```objc
#define PI 3.14159265359
```

```Java
public static final long PI = 3.14159265359;
```

**HINT**: You can also define enums as constants. This is especially useful if the enum has just one entry.

### Finishing the binding

To be done…
robovm.xml... reference to integration instructions above... 

### Creating a static library in Xcode

To be done…

### Pull requests

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
