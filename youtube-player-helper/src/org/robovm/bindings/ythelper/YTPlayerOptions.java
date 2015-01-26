
package org.robovm.bindings.ythelper;

import org.robovm.apple.foundation.NSDictionary;
import org.robovm.apple.foundation.NSMutableDictionary;
import org.robovm.apple.foundation.NSNumber;
import org.robovm.apple.foundation.NSObject;
import org.robovm.apple.foundation.NSString;
import org.robovm.rt.bro.annotation.Marshaler;
import org.robovm.rt.bro.annotation.MarshalsPointer;

@Marshaler(YTPlayerOptions.Marshaler.class)
public class YTPlayerOptions {
    public static class Marshaler {
        @SuppressWarnings("unchecked")
        @MarshalsPointer
        public static YTPlayerOptions toObject (Class<YTPlayerOptions> cls, long handle, long flags) {
            NSDictionary<NSString, NSObject> o = (NSDictionary<NSString, NSObject>)NSObject.Marshaler.toObject(
                NSDictionary.class, handle, flags);
            if (o == null) {
                return null;
            }
            return new YTPlayerOptions(o);
        }

        @MarshalsPointer
        public static long toNative (YTPlayerOptions o, long flags) {
            if (o == null) {
                return 0L;
            }
            return NSObject.Marshaler.toNative(o.data, flags);
        }
    }

    private final NSDictionary<NSString, NSObject> data;

    public YTPlayerOptions () {
        data = new NSMutableDictionary<>();
    }

    private YTPlayerOptions (NSDictionary<NSString, NSObject> data) {
        this.data = data;
    }

    public NSDictionary<NSString, NSObject> getDictionary () {
        return data;
    }

    public boolean has (String parameter) {
        return has(new NSString(parameter));
    }

    public boolean has (NSString parameter) {
        return data.containsKey(parameter);
    }

    public String get (String parameter) {
        return get(new NSString(parameter));
    }

    public String get (NSString parameter) {
        if (has(parameter)) {
            NSString val = (NSString)data.get(parameter);
            return val.toString();
        }
        return null;
    }

    public YTPlayerOptions set (String parameter, String value) {
        return set(new NSString(parameter), value);
    }

    public YTPlayerOptions set (String parameter, int value) {
        return set(new NSString(parameter), value);
    }

    public YTPlayerOptions set (NSString parameter, String value) {
        data.put(parameter, new NSString(value));
        return this;
    }

    public YTPlayerOptions set (NSString parameter, int value) {
        data.put(parameter, NSNumber.valueOf(value));
        return this;
    }

    public static class Parameters {
        public static final NSString AUTOHIDE = new NSString("autohide");
        public static final NSString AUTOPLAY = new NSString("autoplay");
        public static final NSString CC_LOAD_POLICY = new NSString("cc_load_policy");
        public static final NSString COLOR = new NSString("color");
        public static final NSString CONTROLS = new NSString("controls");
        public static final NSString DISABLEKB = new NSString("disablekb");
        public static final NSString ENABLEJSAPI = new NSString("enablejsapi");
        public static final NSString END = new NSString("end");
        public static final NSString FS = new NSString("fs");
        public static final NSString HL = new NSString("hl");
        public static final NSString IV_LOAD_POLICY = new NSString("iv_load_policy");
        public static final NSString LIST = new NSString("list");
        public static final NSString LIST_TYPE = new NSString("listType");
        public static final NSString LOOP = new NSString("loop");
        public static final NSString MODESTBRANDING = new NSString("modestbranding");
        public static final NSString ORIGIN = new NSString("origin");
        public static final NSString PLAYERAPIID = new NSString("playerapiid");
        public static final NSString PLAYLIST = new NSString("playlist");
        public static final NSString PLAYSINLINE = new NSString("playsinline");
        public static final NSString REL = new NSString("rel");
        public static final NSString SHOWINFO = new NSString("showinfo");
        public static final NSString START = new NSString("start");
        public static final NSString THEME = new NSString("theme");
    }
}
