
package org.robovm.bindings.googleanalytics;

import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;

@NativeClass
public class GAIFields extends NSObject {
	public static final String kGAIUseSecure = "useSecure";

	public static final String kGAIHitType = "&t";
	public static final String kGAITrackingId = "&tid";
	public static final String kGAIClientId = "&cid";
	public static final String kGAIAnonymizeIp = "&aip";
	public static final String kGAISessionControl = "&sc";
	public static final String kGAIScreenResolution = "&sr";
	public static final String kGAIViewportSize = "&vp";
	public static final String kGAIEncoding = "&de";
	public static final String kGAIScreenColors = "&sd";
	public static final String kGAILanguage = "&ul";
	public static final String kGAIJavaEnabled = "&je";
	public static final String kGAIFlashVersion = "&fl";
	public static final String kGAINonInteraction = "&ni";
	public static final String kGAIReferrer = "&dr";
	public static final String kGAILocation = "&dl";
	public static final String kGAIHostname = "&dh";
	public static final String kGAIPage = "&dp";
	public static final String kGAIDescription = "&cd"; // synonym for kGAIScreenName
	public static final String kGAIScreenName = "&cd"; // synonym for kGAIDescription
	public static final String kGAITitle = "&dt";
	public static final String kGAIAppName = "&an";
	public static final String kGAIAppVersion = "&av";
	public static final String kGAIAppId = "&aid";
	public static final String kGAIAppInstallerId = "&aiid";

	public static final String kGAIEventCategory = "&ec";
	public static final String kGAIEventAction = "&ea";
	public static final String kGAIEventLabel = "&el";
	public static final String kGAIEventValue = "&ev";
	public static final String kGAISocialNetwork = "&sn";
	public static final String kGAISocialAction = "&sa";
	public static final String kGAISocialTarget = "&st";

	public static final String kGAITransactionId = "&ti";
	public static final String kGAITransactionAffiliation = "&ta";
	public static final String kGAITransactionRevenue = "&tr";
	public static final String kGAITransactionShipping = "&ts";
	public static final String kGAITransactionTax = "&tt";
	public static final String kGAICurrencyCode = "&cu";

	public static final String kGAIItemPrice = "&ip";
	public static final String kGAIItemQuantity = "&iq";
	public static final String kGAIItemSku = "&ic";
	public static final String kGAIItemName = "&in";
	public static final String kGAIItemCategory = "&iv";
	public static final String kGAICampaignSource = "&cs";
	public static final String kGAICampaignMedium = "&cm";
	public static final String kGAICampaignName = "&cn";
	public static final String kGAICampaignKeyword = "&ck";
	public static final String kGAICampaignContent = "&cc";
	public static final String kGAICampaignId = "&ci";
	public static final String kGAITimingCategory = "&utc";
	public static final String kGAITimingVar = "&utv";
	public static final String kGAITimingValue = "&utt";
	public static final String kGAITimingLabel = "&utl";

	public static final String kGAIExDescription = "&exd";
	public static final String kGAIExFatal = "&exf";

	public static final String kGAISampleRate = "&sf";

	// hit types
	public static final String kGAIAppView = "appview";
	public static final String kGAIEvent = "event";
	public static final String kGAISocial = "social";
	public static final String kGAITransaction = "transaction";
	public static final String kGAIItem = "item";
	public static final String kGAIException = "exception";
	public static final String kGAITiming = "timing";

	/** Generates the correct parameter name for a content group with an index.
	 * 
	 * @param index the index of the content group.
	 * 
	 * @return an String representing the content group parameter for the index. */
	@Method(selector = "contentGroupForIndex:")
	public static native String getContentGroup (int index);

	/** Generates the correct parameter name for a custon dimension with an index.
	 * 
	 * @param index the index of the custom dimension.
	 * 
	 * @return an String representing the custom dimension parameter for the index. */
	@Method(selector = "customDimensionForIndex:")
	public static native String getCustomDimension (int index);

	/** Generates the correct parameter name for a custom metric with an index.
	 * 
	 * @param index the index of the custom metric.
	 * 
	 * @return an String representing the custom metric parameter for the index. */
	@Method(selector = "customMetricForIndex:")
	public static native String customMetricForIndex (int index);
}
