package com.cr_labs.rfc4765.accessories;

/*
Copyright (C) 2007-2011 by Challenge/Response LLC
Copyright (C) 2011 by Jim Youll, successor copyright holder

This program is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

This program is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with this program.  If not, see <http://www.gnu.org/licenses/>.

Contact: jim@cr-labs.com
*/


import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import com.challengeandresponse.utils.ReadonlyList;
import com.cr_labs.rfc4765.Analyzer;
import com.cr_labs.rfc4765.IDMEFMessage_Heartbeat;

/**
 * Stores, tracks heartbeat messages. Just instantiate and then call logHeartbeat with a heartbeat message to store it.
 * Companion class is RFC4765HeartbeatGenerator, which sends out heartbeat messages at prescribed intervals.
 * 
 * TODO needs a heartbeats-reaper thread to yank really old data from the heartbeats list
 * 
 * @author jim
 * @see IDMEFMessage_Heartbeat
 * @see RFC4765HeartbeatGenerator
 *
 */
public class RFC4765HeartbeatTracker {
	
	private int maxHistory;
	private ConcurrentHashMap <String, CopyOnWriteArrayList <IDMEFMessage_Heartbeat>> heartbeats;
	

	/**
	 * @param maxHistory max number of historical heartbeat messages to store
	 */
	public RFC4765HeartbeatTracker(int maxHistory) {
		this.maxHistory = maxHistory;
		heartbeats = new ConcurrentHashMap <String, CopyOnWriteArrayList <IDMEFMessage_Heartbeat>> ();
	}

	
	public void logHeartbeat(IDMEFMessage_Heartbeat msg) {
		String key = msg.getAnalyzer().getAnalyzerID();
		// if there is no key for the analyzer that sent 'msg', add one with an empty heartbeat history
		heartbeats.putIfAbsent(key, new CopyOnWriteArrayList <IDMEFMessage_Heartbeat>());
		// get the List of heartbeats for the given analyzer. this is also used as a lock
		CopyOnWriteArrayList<IDMEFMessage_Heartbeat> analyzerBeats = heartbeats.get(key);
		synchronized (analyzerBeats) {
			// add the new msg to the list if it's not already there, and prune the list if it's too big
			analyzerBeats.addIfAbsent(msg);
			while (analyzerBeats.size() > maxHistory)
				analyzerBeats.remove(0);
		}
	}
	
	
	/**
	 * @param analyzer
	 * @returna read-only list of IDMEFMessage_Heartbeat objects for the given analyzer
	 */
	public ReadonlyList <IDMEFMessage_Heartbeat> getLoggedHeartbeats(Analyzer analyzer) {
		CopyOnWriteArrayList <IDMEFMessage_Heartbeat> al = heartbeats.get(analyzer);
		return new ReadonlyList <IDMEFMessage_Heartbeat> (al);
	}
	

}
