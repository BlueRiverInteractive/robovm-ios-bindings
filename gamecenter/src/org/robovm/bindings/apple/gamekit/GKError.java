
package org.robovm.bindings.apple.gamekit;

import org.robovm.rt.bro.ValuedEnum;

public enum GKError implements ValuedEnum {
	GKErrorUnknown(0), GKErrorCancelled(2), GKErrorCommunicationsFailure(3), GKErrorUserDenied(4), GKErrorInvalidCredentials(5), GKErrorNotAuthenticated(
		6), GKErrorAuthenticationInProgress(7), GKErrorInvalidPlayer(8), GKErrorScoreNotSet(9), GKErrorParentalControlsBlocked(10), GKErrorPlayerStatusExceedsMaximumLength(
		11), GKErrorPlayerStatusInvalid(12), GKErrorMatchRequestInvalid(13), GKErrorUnderage(14), GKErrorGameUnrecognized(15), GKErrorNotSupported(
		16), GKErrorInvalidParameter(17), GKErrorUnexpectedConnection(18), GKErrorChallengeInvalid(19), GKErrorTurnBasedMatchDataTooLarge(
		20), GKErrorTurnBasedTooManySessions(21), GKErrorTurnBasedInvalidParticipant(22), GKErrorTurnBasedInvalidTurn(23), GKErrorTurnBasedInvalidState(
		24);

	private final long n;

	private GKError (long n) {
		this.n = n;
	}

	@Override
	public long value () {
		return n;
	}
}
