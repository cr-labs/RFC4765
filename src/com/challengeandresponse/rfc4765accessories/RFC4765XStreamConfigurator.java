package com.challengeandresponse.rfc4765accessories;

import com.thoughtworks.xstream.XStream;


public final class RFC4765XStreamConfigurator {

	/**
	 * This is an adapter class that just encapsulates the shorthands for JODA Time and RFC4765
	 * 
	 * Call like this: RFC4765XStreamConfigurator.configureXStream(xstream);
	 * 
	 * This class is not in the RFC4765 package because of the dependency on XStream...
	 * XStream isn't needed by RFC4765, only by SK which wants to XML-ify the RFC4765 classes AND make them pretty
	 */
	private RFC4765XStreamConfigurator() {
	}
	
	public static void configureXStream(XStream xs) {
		xs.alias("RFC4765Action",com.challengeandresponse.rfc4765.Action.class);
		xs.alias("RFC4765AdditionalData",com.challengeandresponse.rfc4765.AdditionalData.class);
		xs.alias("RFC4765Address",com.challengeandresponse.rfc4765.Address.class);
		xs.alias("RFC4765Analyzer",com.challengeandresponse.rfc4765.Analyzer.class);
		xs.alias("RFC4765Assessment",com.challengeandresponse.rfc4765.Assessment.class);
		xs.alias("RFC4765Checksum",com.challengeandresponse.rfc4765.Checksum.class);
		xs.alias("RFC4765Confidence",com.challengeandresponse.rfc4765.Confidence.class);
		xs.alias("RFC4765CorrelationAlert",com.challengeandresponse.rfc4765.CorrelationAlert.class);
		xs.alias("RFC4765File",com.challengeandresponse.rfc4765.File.class);
		xs.alias("RFC4765FileAccess",com.challengeandresponse.rfc4765.FileAccess.class);
		xs.alias("RFC4765IDMEFMessageAlert", com.challengeandresponse.rfc4765.IDMEFMessage_Alert.class);
		xs.alias("RFC4765IDMEFMessageCorrelationAlert", com.challengeandresponse.rfc4765.IDMEFMessage_CorrelationAlert.class);
		xs.alias("RFC4765IDMEFMessageHeartbeat", com.challengeandresponse.rfc4765.IDMEFMessage_Heartbeat.class);
		xs.alias("RFC4765IDMEFMessageOverflowAlert", com.challengeandresponse.rfc4765.IDMEFMessage_OverflowAlert.class);
		xs.alias("RFC4765IDMEFMessageToolAlert", com.challengeandresponse.rfc4765.IDMEFMessage_ToolAlert.class);
		xs.alias("RFC4765Impact",com.challengeandresponse.rfc4765.Impact.class);
		xs.alias("RFC4765Inode",com.challengeandresponse.rfc4765.Inode.class);
		xs.alias("RFC4765Linkage",com.challengeandresponse.rfc4765.Linkage.class);
		xs.alias("RFC4765Node",com.challengeandresponse.rfc4765.Node.class);
		xs.alias("RFC4765OverflowAlert",com.challengeandresponse.rfc4765.OverflowAlert.class);
		xs.alias("RFC4765Process",com.challengeandresponse.rfc4765.Process.class);
		xs.alias("RFC4765Referene",com.challengeandresponse.rfc4765.Reference.class);
		xs.alias("RFC4765Service",com.challengeandresponse.rfc4765.Service.class);
		xs.alias("RFC4765Source",com.challengeandresponse.rfc4765.Source.class);
		xs.alias("RFC4765Target",com.challengeandresponse.rfc4765.Target.class);
		xs.alias("RFC4765ToolAlert",com.challengeandresponse.rfc4765.ToolAlert.class);
		xs.alias("RFC4765User",com.challengeandresponse.rfc4765.User.class);
		xs.alias("RFC4765UserId",com.challengeandresponse.rfc4765.UserId.class);
	}
	
	
	
	
}
