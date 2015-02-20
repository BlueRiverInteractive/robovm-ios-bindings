package org.robovm.bindings.app42;

import org.robovm.apple.foundation.NSDate;
import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

@NativeClass
public class Review extends NSObject
{
	@Property(selector = "userId")
	public native String getUserId();

	@Property(selector = "setUserId:", strongRef = true)
	public native void setUserId(String userId);
	
	@Property(selector = "item")
	public native String getItem();

	@Property(selector = "setItem:", strongRef = true)
	public native void setItem(String item);
	
	@Property(selector = "status")
	public native String getStatus();

	@Property(selector = "setStatus:", strongRef = true)
	public native void setStatus(String status);
	
	@Property(selector = "reviewId")
	public native String getReviewId();

	@Property(selector = "setReviewId:", strongRef = true)
	public native void setReviewId(String reviewId);

	@Property(selector = "comment")
	public native String getComment();

	@Property(selector = "setComment:", strongRef = true)
	public native void setComment(String comment);

	@Property(selector = "commentId")
	public native String getCommentId();

	@Property(selector = "setCommentId:", strongRef = true)
	public native void setCommentId(String commentId);

	@Property(selector = "rating")
	public native double getRating();

	@Property(selector = "setRating:", strongRef = true)
	public native void setRating(double rating);

	@Property(selector = "createdOn")
	public native NSDate getCreatedOn();

	@Property(selector = "setCreatedOn:", strongRef = true)
	public native void setCreatedOn(NSDate createdOn);
}
