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

/** These enums represent error codes thrown by the player. */

public enum YTPlayerError implements ValuedEnum {
	kYTPlayerErrorInvalidParam(0),
	kYTPlayerErrorHTML5Error(1),
	kYTPlayerErrorVideoNotFound(2),
	kYTPlayerErrorNotEmbeddable(3),
	kYTPlayerErrorUnknown(4);

	  private final long n;

	  private YTPlayerError (long n) {
	    this.n = n;
	  }

	  @Override
	  public long value () {
	    return n;
	  }
	}
