Usage
============
Build this project and copy libOpenKitUnity.a into the Plugins folder within
Unity's project tree.


Developer notes
===============

This project is not ARC.

libmono.0.dylib was copied from: 
/Applications/Unity/Unity.app/Contents/Frameworks/MonoEmbedRuntime/osx/libmono.0.dylib


Bridging the Divide
===================

Types
-------------------

### Struct

```
iOS:
    typedef struct
    {
        float x;
        float y;
    }OKSomeStruct;

Unity:
    [StructLayout (LayoutKind.Sequential)]
    public struct OKSomeStruct{
        public float x;
        public float y;
    }
```

### Enum

```
iOS:
    typedef enum
    {
        kOKSomeEnum1,
        kOKSomeEnum2
    }OKSomeEnum;

Unity:
    public enum OKSomeEnum
    {
        kOKSomeEnum1,
        kOKSomeEnum2
    }
```
    
### Array of strings

```
iOS:
    const char *images[]
    
Unity:
    string[] images
```
    
    
    
Calling native functions from Unity
-----------------------------------

```
In native code, declare:
    extern void OKBridgeInit(bool isEditor, const char *escapedCodeBase);
    
In Unity, declare:
    // For iOS:
    [DllImport ("__Internal")]
	  public static extern void OKBridgeInit(bool isEditor, string escapedCodeBase);
    
    // For Mac:
    [DllImport ("NameOfMacBundle")]
    public static extern void OKBridgeInit(bool isEditor, string escapedCodeBase);
```

Calling Unity methods from native code
-----------------------------------

### Method that takes a string:

```
Unity:
    // In the OKBridge class:
    public static void OKBridgeLog(string message);
    
iOS:
    // Declare
    static MonoMethod *mono_okbridgeLogError;

    // Then, in the body of OKBridgeInit (in OKBridge.m)
    {
        ...
        mono_okbridgeLog = mono_method_desc_search_in_image(mono_method_desc_new("OKBridge:OKBridgeLog", FALSE), monoImage);
        ...
    }
        
     // Then, to call:
    void *args[1] = { mono_string_new(mono_domain_get(), [[NSString stringWithFormat:@"OpenKit: %@",str] UTF8String]) };
    mono_runtime_invoke(mono_okbridgeLog, NULL, args, NULL);
```


### Method that takes multiple arguments:

Same as above, except call with:

```
    // In this example playerNumber is an int and accel
    // is a struct containing acceleration data:
    void *args[2] = {&playerNumber, &accel};
    mono_runtime_invoke(mono_deviceDidAccelerate, NULL, args, NULL);
```


Forwarding messages from OKBridge to game objects:
-------------------------------------------------

```
  obj = GameObject.Find("listeningObjName");
  listener = obj.GetComponent<OKCallbackListener>();
  if (listener != null) {
    listener.DidDoSomething();
  }
```


References:
-----------
http://www.reigndesign.com/blog/unity-native-plugins-os-x/  
http://www.tinytimgames.com/2010/01/10/the-unityobjective-c-divide/  
http://forum.unity3d.com/threads/84380-possible-to-call-C-Javascript-back-from-plugin-bundle-on-mac  

Inspired from ~/dev/JoypadSDKBuild/UnityPlugin (see the 0.2-maintenance branch).
