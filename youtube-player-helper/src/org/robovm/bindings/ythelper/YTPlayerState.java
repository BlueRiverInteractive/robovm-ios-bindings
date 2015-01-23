package org.robovm.bindings.ythelper;

import org.robovm.rt.bro.ValuedEnum;

//Copyright 2014 Google Inc. All rights reserved.
//
//Licensed under the Apache License, Version 2.0 (the "License");
//you may not use this file except in compliance with the License.
//You may obtain a copy of the License at
//
//http://www.apache.org/licenses/LICENSE-2.0
//
//Unless required by applicable law or agreed to in writing, software
//distributed under the License is distributed on an "AS IS" BASIS,
//WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//See the License for the specific language governing permissions and
//limitations under the License.

/** These enums represent the state of the current video in the player. */

public enum YTPlayerState implements ValuedEnum {
	kYTPlayerStateUnstarted(0),
	kYTPlayerStateEnded(1),
	kYTPlayerStatePlaying(2),
	kYTPlayerStatePaused(3),
	kYTPlayerStateBuffering(4),
	kYTPlayerStateQueued(5),
	kYTPlayerStateUnknown(6);

	  private final long n;

	  private YTPlayerState (long n) {
	    this.n = n;
	  }

	  @Override
	  public long value () {
	    return n;
	  }
	}
