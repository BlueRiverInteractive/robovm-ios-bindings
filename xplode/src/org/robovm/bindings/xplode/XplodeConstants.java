package org.robovm.bindings.xplode;

import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.ValuedEnum;

/**
 * Created by sargis on 2/20/15.
 */
@NativeClass
public class XplodeConstants extends NSObject {

    public enum XPLPromotionDockingPosition implements ValuedEnum {
        Bottom(0),
        Top(1);

        private final long n;

        private XPLPromotionDockingPosition(long n) {
            this.n = n;
        }

        @Override
        public long value() {
            return n;
        }
    }

    public enum XPLPromotionDockDimensions implements ValuedEnum {
        Default(0),
        IAd(1),
        IAB(2);

        private final long n;

        private XPLPromotionDockDimensions(long n) {
            this.n = n;
        }

        @Override
        public long value() {
            return n;
        }
    }
}
