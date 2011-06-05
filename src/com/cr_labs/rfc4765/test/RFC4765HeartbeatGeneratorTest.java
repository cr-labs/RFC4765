package com.cr_labs.rfc4765.test;

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


import com.cr_labs.rfc4765.Analyzer;
import com.cr_labs.rfc4765.IDMEFMessage_Heartbeat;
import com.cr_labs.rfc4765.accessories.RFC4765HeartbeatGenerator;

public class RFC4765HeartbeatGeneratorTest extends RFC4765HeartbeatGenerator {

	public RFC4765HeartbeatGeneratorTest(Analyzer analyzer, int intervalSeconds, String messageIDPrefix, int messageIDFirstValue) {
		super(analyzer, intervalSeconds, messageIDPrefix, messageIDFirstValue);
	}

	@Override
	public void processHeartbeat(IDMEFMessage_Heartbeat h) {
		System.out.println("in processHeartbeat: "+h);
	}

	
	
	public static void main(String[] args) {
		System.out.println("in RFC4765HeartbeatGeneratorTest");
		
		Analyzer analyzer = new Analyzer(null, null, null, null, null, null, null, null, null, null, null);
		RFC4765HeartbeatGeneratorTest hbtest = new RFC4765HeartbeatGeneratorTest(analyzer, 1, "MESSAGEIDPREFIX", 1000);
		hbtest.start();
		
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
		}
		
		hbtest.stop();
		
		
	}
	
	
}
