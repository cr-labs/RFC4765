package com.challengeandresponse.rfc4765test;

import com.challengeandresponse.rfc4765.Analyzer;
import com.challengeandresponse.rfc4765.IDMEFMessage_Heartbeat;
import com.challengeandresponse.rfc4765accessories.RFC4765HeartbeatGenerator;

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
