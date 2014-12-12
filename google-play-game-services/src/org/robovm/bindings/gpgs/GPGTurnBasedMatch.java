package org.robovm.bindings.gpgs;

import org.robovm.apple.foundation.NSArray;
import org.robovm.apple.foundation.NSData;
import org.robovm.apple.foundation.NSObject;
import org.robovm.objc.annotation.Block;
import org.robovm.objc.annotation.Method;
import org.robovm.objc.annotation.NativeClass;
import org.robovm.objc.annotation.Property;

@NativeClass
public class GPGTurnBasedMatch extends NSObject {

	@Property(selector = "matchConfig")
	public native GPGMultiplayerConfig getMatchConfig();
	
	@Property(selector = "creationTimestamp")
	public native long getCreationTimestamp();
	
	@Property(selector = "creationParticipant")
	public native GPGTurnBasedParticipant getCreationParticipant();
	
	@Property(selector = "data")
	public native NSData getData();
	
	@Property(selector = "dataAvailable")
	public native boolean getDataAvailable();
	
	@Property(selector = "inviterParticipant")
	public native GPGTurnBasedParticipant getInviterParticipant();
	
	@Property(selector = "lastUpdateTimestamp")
	public native long getLastUpdateTimestamp();
	
	@Property(selector = "lastUpdateParticipant")
	public native GPGTurnBasedParticipant getLastUpdateParticipant();
	
	@Property(selector = "matchDescription")
	public native String getMatchDescription();
	
	@Property(selector = "matchId")
	public native String getMatchId();
	
	@Property(selector = "matchNumber")
	public native int getMatchNumber();
	
	@Property(selector = "matchVersion")
	public native int getMatchVersion();
	
	@Property(selector = "participants")
	public native NSArray getParticipants();
	
	@Property(selector = "pendingParticipant")
	public native GPGTurnBasedParticipant getPendingParticipant();

	@Property(selector = "previousMatchData")
	public native NSData getPreviousMatchData();
	
	@Property(selector = "previousMatchDataAvailable")
	public native boolean getPreviousMatchDataAvailable();
	
	@Property(selector = "rematchId")
	public native String getRematchId();
	
	@Property(selector = "results")
	public native NSArray getResults();
	
	@Property(selector = "status")
	public native GPGTurnBasedMatchStatus getStatus();

	@Property(selector = "userMatchStatus")
	public native GPGTurnBasedUserMatchStatus getUserMatchStatus();
	
	@Method(selector = "canParticipantTakeTurn:")
	public native boolean canParticipantTakeTurn(String participantId);

	@Property(selector = "localParticipantId")
	public native String getLocalParticipantId();
	
	@Method(selector = "participantIdForPlayerId:")
	public native String participantIdForPlayerId(String playerId);

	@Property(selector = "localParticipant")
	public native GPGTurnBasedParticipant getLocalParticipant();
	
	@Method(selector = "participantForId:")
	public native GPGTurnBasedParticipant participantForId(String participantId);
	
	@Property(selector = "pendingPlayer")
	public native GPGPlayer getPendingPlayer();
	
	@Property(selector = "myTurn")
	public native boolean myTurn();
	
	@Property(selector = "myResult")
	public native GPGTurnBasedParticipantResult getMyResult();

	@Method(selector = "resultForParticipantId:")
	public native GPGTurnBasedParticipantResult resultForParticipantId(String participantId);

	@Method(selector = "statusForPlayerId:")
	public native GPGTurnBasedParticipantStatus statusForPlayerId(String playerId);
	
	@Property(selector = "myStatus")
	public native GPGTurnBasedParticipantStatus getMyStatus();
	
	@Method(selector = "createMatchWithConfig:completionHandler:")
	public static native GPGTurnBasedMatchCreationResult createMatchWithConfig(GPGMultiplayerConfig config, @Block GPGTurnBasedMatchCreateBlock completionHandler);
	
	@Method(selector = "fetchMatchWithId:includeMatchData:completionHandler:")
	public static native void fetchMatchWithId(String matchId, boolean includeMatchData, @Block GPGTurnBasedMatchGetBlock completionHandler);
	        
  	@Method(selector = "listForIncludeMatchData:maxCompletedMatches:maxResults:pageToken:completionHandler:")
	public static native void listForIncludeMatchData(boolean includeMatchData, int maxCompletedMatches, int maxResults, String pageToken, @Block GPGTurnBasedMatchListBlock completionHandler);
	                      
	@Method(selector = "allMatchesWithCompletionHandler:")
	public static native void allMatchesWithCompletionHandler(@Block GPGTurnBasedMatchesBlock completionHandler);
	
	@Method(selector = "allMatchesFromDataSource:completionHandler:")
	public static native void allMatchesFromDataSource(GPGDataSource dataSource, @Block GPGTurnBasedMatchesBlock completionHandler);
	
	@Method(selector = "matchesForMatchStatus:completionHandler:")
	public static native void matchesForMatchStatus(GPGTurnBasedMatchStatus status, @Block GPGTurnBasedMatchesBlock completionHandler);
	
	@Method(selector = "matchesForMatchStatus:dataSource:completionHandler:")
	public static native void matchesForMatchStatus(GPGTurnBasedMatchStatus status, GPGDataSource dataSource, @Block GPGTurnBasedMatchesBlock completionHandler);
	                   
	@Method(selector = "matchesForUserMatchStatus:completionHandler:")
	public static native void matchesForUserMatchStatus(GPGTurnBasedUserMatchStatus status, @Block GPGTurnBasedMatchesBlock completionHandler);
	
   	@Method(selector = "matchesForUserMatchStatus:dataSouce:completionHandler:")
	public static native void matchesForUserMatchStatus(GPGTurnBasedUserMatchStatus status, GPGDataSource dataSource, @Block GPGTurnBasedMatchesBlock completionHandler);
	                       
	@Method(selector = "cancelWithCompletionHandler:")
	public native void cancelWithCompletionHandler(@Block GPGTurnBasedMatchCompletionBlock completionHandler);
	
	@Method(selector = "declineWithCompletionHandler:")
	public  native void declineWithCompletionHandler(@Block GPGTurnBasedMatchCompletionBlock completionHandler);
	
	@Method(selector = "dismissWithCompletionHandler:")
	public native void dismissWithCompletionHandler(@Block GPGTurnBasedMatchCompletionBlock completionHandler);
	
   	@Method(selector = "finishWithData:results:completionHandler:")
	public native void finishWithData(NSData data, NSArray results, @Block GPGTurnBasedMatchCompletionBlock completionHandler);
	               
	@Method(selector = "joinWithCompletionHandler:")
	public native void joinWithCompletionHandler(@Block GPGTurnBasedMatchCompletionBlock completionHandler);
	
	@Method(selector = "leaveOutOfTurnWithCompletionHandler:")
	public native void leaveOutOfTurnWithCompletionHandler(@Block GPGTurnBasedMatchCompletionBlock completionHandler);
	
	@Method(selector = "leaveDuringTurnWithNextParticipantId:completionHandler:")
	public native void leaveDuringTurnWithNextParticipantId(String nextParticipantId, @Block GPGTurnBasedMatchCompletionBlock completionHandler);
	
	@Method(selector = "rematchWithCompletionHandler:")
	public native void rematchWithCompletionHandler(@Block GPGTurnBasedMatchRematchBlock completionHandler);
	                         
  	@Method(selector = "takeTurnWithNextParticipantId:data:results:completionHandler:")
	public native void takeTurnWithNextParticipantId(String nextParticipantId, NSData data, NSArray results, @Block GPGTurnBasedMatchCompletionBlock completionHandler);
}
