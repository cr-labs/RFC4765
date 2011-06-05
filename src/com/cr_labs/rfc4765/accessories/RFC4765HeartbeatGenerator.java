package com.cr_labs.rfc4765.accessories;

import java.util.Timer;
import java.util.TimerTask;

import org.joda.time.DateTime;

import com.cr_labs.rfc4765.Analyzer;
import com.cr_labs.rfc4765.IDMEFMessage_Heartbeat;

/**
 * Creates heartbeat messages for a single Analyzer at prescribed intervals.
 * This class is fundamentally a Timer, that creates IDMEFMessage_Heartbeat messages
 * and then calls the abstract method processHeartbeat() .. apps just extend this class, override that method,
 * and do whatever it is that they want to do with heartbeats
 * 
 * @author jim
 *
 */
public abstract class RFC4765HeartbeatGenerator {

	private int intervalSeconds;

	private MakeHeartbeatsTask hbTask;
	private Timer timer;


	/**
	 * When shutting down: number of seconds to wait for lingering notifications tasks to be sent, before giving up
	 */
	public static final int SHUTDOWN_TIMEOUT = 10;

	/**
	 * 
	 * @param analyzer the Analyzer whose info is included with the heartbeats that this thing generates
	 * @param intervalSeconds the interval in seconds between heartbeats
	 * @param messageIDPrefix optional prefix for generated messageIDs, ok to use null if there is no prefix 
	 * @param messageIDFirstValue message IDs are nonzero and increase sequentially. provide the starting value (can be zero). if value is < 0, it's set to 0.
	 */
	public RFC4765HeartbeatGenerator(Analyzer analyzer, int intervalSeconds, String messageIDPrefix, int messageIDFirstValue) {
		hbTask = new MakeHeartbeatsTask(messageIDPrefix,analyzer,intervalSeconds,messageIDFirstValue);
		this.intervalSeconds = intervalSeconds;
	}



	/**
	 * Start generating heartbeat messages and calling back to registered classes
	 *	 */
	public void start() {
		timer = new Timer("RFC4765HeartbeatGenerator timer");
		timer.schedule(hbTask, (long) ((long)intervalSeconds * 1000), (long) ((long)intervalSeconds * 1000));
	}

	/**
	 * Stop generating heartbeat messages
	 */
	public void stop() {
		timer.cancel();
	}



	/**
	 * Process a generated heartbeat. The specifics of "what that means" are left to the implementation.
	 */
	public abstract void processHeartbeat(IDMEFMessage_Heartbeat h);
	


	/**
	 * When the timer fires, call the heartbeat processor method
	 */
	class MakeHeartbeatsTask extends TimerTask {
		private String messageIDPrefix;
		private Analyzer analyzer;
		private int intervalSeconds;
		private int nextMessageID;
		
		public MakeHeartbeatsTask(String messageIDPrefix, Analyzer analyzer, int intervalSeconds, int messageIDFirstValue) {
			this.messageIDPrefix = messageIDPrefix;
			this.analyzer = analyzer;
			this.intervalSeconds = intervalSeconds;
			if (messageIDFirstValue < 0)
				this.nextMessageID = 0;
			else
				this.nextMessageID = messageIDFirstValue;
		}
		
		public void run() {
			// generate a fresh IDMEFMessage_Heartbeat, inserting the 'analyzer'
			IDMEFMessage_Heartbeat h;
			// is synchronized to protect the increment of nextMessageID
			synchronized (this) {
				h = new IDMEFMessage_Heartbeat(messageIDPrefix+nextMessageID,analyzer,new DateTime(),new DateTime(),intervalSeconds,null);
				nextMessageID++;
			}
			processHeartbeat(h);
		}
	}


	
	
	

//
//	/**
//	 * Heartbeat notifications are sent out in independent threads.
//	 * This class carries out the notification. Instead of making the call directly, 
//	 * the notification method should create an instance of this method for every
//	 * notice, then submit them to, e.g. an ExecutionService, where they will be
//	 * queued and run in independent threads.
//	 * 
//	 * @author jim
//	 *
//	 */
//	private class HeartbeatNotifier implements Runnable {
//	private IDMEFMessage_Heartbeat h;
//	private HeartbeatListenerI who;

//	public HeartbeatNotifier(IDMEFMessage_Heartbeat h, HeartbeatListenerI who) {
//	this.h = h;
//	this.who = who;
//	}
//	public void run() {
////	System.out.println("sending heartbeat to:"+who+"   --> heartbeat:"+h);
//	who.processGeneratedHeartbeat(h);
//	}
//	}

	

}
