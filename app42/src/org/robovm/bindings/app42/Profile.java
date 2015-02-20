package org.robovm.bindings.app42;

import org.robovm.apple.foundation.NSDate;
import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;
import org.robovm.rt.bro.annotation.Pointer;

@NativeClass
public class Profile extends NSObject
{
	@Property(selector = "firstName")
	public native String getFirstName();

	@Property(selector = "setFirstName:", strongRef = true)
	public native void setFirstName(String firstName);

	@Property(selector = "lastName")
	public native String getLastName();

	@Property(selector = "setLastName:", strongRef = true)
	public native void setLastName(String lastName);

	@Property(selector = "sex")
	public native String getSex();

	@Property(selector = "setSex:", strongRef = true)
	public native void setSex(String sex);

	@Property(selector = "mobile")
	public native String getMobile();

	@Property(selector = "setMobile:", strongRef = true)
	public native void setMobile(String mobile);

	@Property(selector = "line1")
	public native String getLine1();

	@Property(selector = "setLine1:", strongRef = true)
	public native void setLine1(String line1);

	@Property(selector = "line2")
	public native String getLine2();

	@Property(selector = "setLine2:", strongRef = true)
	public native void setLine2(String line2);
	
	@Property(selector = "city")
	public native String getCity();

	@Property(selector = "setCity:", strongRef = true)
	public native void setCity(String city);

	@Property(selector = "state")
	public native String getState();

	@Property(selector = "setState:", strongRef = true)
	public native void setState(String state);

	@Property(selector = "country")
	public native String getCountry();

	@Property(selector = "setCountry:", strongRef = true)
	public native void setCountry(String country);

	@Property(selector = "pincode")
	public native String getPincode();

	@Property(selector = "setPincode:", strongRef = true)
	public native void setPincode(String pincode);

	@Property(selector = "homeLandLine")
	public native String getHomeLandLine();

	@Property(selector = "setHomeLandLine:", strongRef = true)
	public native void setHomeLandLine(String homeLandLine);

	@Property(selector = "officeLandLine")
	public native String getOfficeLandLine();

	@Property(selector = "setOfficeLandLine:", strongRef = true)
	public native void setOfficeLandLine(String officeLandLine);

	@Property(selector = "dateOfBirth")
	public native NSDate getDateOfBirth();

	@Property(selector = "setDateOfBirth:", strongRef = true)
	public native void setDateOfBirth(NSDate dateOfBirth);
	
	@Property(selector = "userObj")
	public native User getUser();

	@Property(selector = "setUserObj:", strongRef = true)
	public native void setUser(User user);

	public Profile(User user) {
		super((SkipInit) null);
	    initObject(init(user));
	}
	
	@Method(selector = "initWithUser:")
	private native @Pointer long init(User user);
}
