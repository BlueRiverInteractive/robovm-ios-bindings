
package org.robovm.bindings.other;

import java.nio.ByteBuffer;
import org.robovm.cocoatouch.foundation.NSObject;
import org.robovm.objc.ObjCClass;
import org.robovm.objc.ObjCRuntime;
import org.robovm.objc.Selector;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.rt.bro.Struct;
import org.robovm.rt.bro.annotation.Bridge;
import org.robovm.rt.bro.annotation.Library;
import org.robovm.rt.bro.ptr.BytePtr;
import org.robovm.rt.bro.ptr.VoidPtr;

@Library("Foundation")
@NativeClass()
public class NSData extends NSObject {
	private static final ObjCClass objCClass = ObjCClass.getByType(NSData.class);

	static {
		ObjCRuntime.bind(NSData.class);
	}

	// - (NSUInteger)length;
	private static final Selector length$ = Selector.register("length");

	@Bridge
	private native static long objc_length (NSData __self__, Selector __cmd__);

	public int length () {
		return (int)objc_length(this, length$);
	}

	// - (const void *)bytes NS_RETURNS_INNER_POINTER;
	private static final Selector bytes$ = Selector.register("bytes");

	@Bridge
	private native static VoidPtr objc_bytes (NSData __self__, Selector __cmd__);

	public ByteBuffer getBytes () {
		VoidPtr p = objc_bytes(this, bytes$);
		BytePtr b = p.as(BytePtr.class);
		return b.asByteBuffer((int)length());
	}

	// + (id)dataWithBytesNoCopy:(void *)bytes length:(NSUInteger)length freeWhenDone:(BOOL)b;
	private static final Selector dataWithBytes$free = Selector.register("dataWithBytesNoCopy:length:freeWhenDone:");

	@Bridge
	private native static NSData objc_dataWithBytesFree (ObjCClass __self__, Selector __cmd__, VoidPtr bytes, long length,
		boolean freeWhenDone);

	public static NSData createFromByteBuffer (final ByteBuffer buffer) {

		BytePtr b = Struct.malloc(BytePtr.class, buffer.capacity());
		ByteBuffer buffer2 = b.asByteBuffer(buffer.capacity());
		buffer.position(0);
		buffer2.clear();
		buffer2.put(buffer);

		// call the objective-c class. Converts the pointer to a void pointer since this class requires a (const void *)
		return objc_dataWithBytesFree(objCClass, dataWithBytes$free, b.as(VoidPtr.class), (long)buffer.capacity(), true);
	}

	public void free () {
		VoidPtr p = objc_bytes(this, bytes$);
		p.free();
	}
}
