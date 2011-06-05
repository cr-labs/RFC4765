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
		xs.alias("RFC4765Action",com.cr_labs.rfc4765.Action.class);
		xs.alias("RFC4765AdditionalData",com.cr_labs.rfc4765.AdditionalData.class);
		xs.alias("RFC4765Address",com.cr_labs.rfc4765.Address.class);
		xs.alias("RFC4765Analyzer",com.cr_labs.rfc4765.Analyzer.class);
		xs.alias("RFC4765Assessment",com.cr_labs.rfc4765.Assessment.class);
		xs.alias("RFC4765Checksum",com.cr_labs.rfc4765.Checksum.class);
		xs.alias("RFC4765Confidence",com.cr_labs.rfc4765.Confidence.class);
		xs.alias("RFC4765CorrelationAlert",com.cr_labs.rfc4765.CorrelationAlert.class);
		xs.alias("RFC4765File",com.cr_labs.rfc4765.File.class);
		xs.alias("RFC4765FileAccess",com.cr_labs.rfc4765.FileAccess.class);
		xs.alias("RFC4765IDMEFMessageAlert", com.cr_labs.rfc4765.IDMEFMessage_Alert.class);
		xs.alias("RFC4765IDMEFMessageCorrelationAlert", com.cr_labs.rfc4765.IDMEFMessage_CorrelationAlert.class);
		xs.alias("RFC4765IDMEFMessageHeartbeat", com.cr_labs.rfc4765.IDMEFMessage_Heartbeat.class);
		xs.alias("RFC4765IDMEFMessageOverflowAlert", com.cr_labs.rfc4765.IDMEFMessage_OverflowAlert.class);
		xs.alias("RFC4765IDMEFMessageToolAlert", com.cr_labs.rfc4765.IDMEFMessage_ToolAlert.class);
		xs.alias("RFC4765Impact",com.cr_labs.rfc4765.Impact.class);
		xs.alias("RFC4765Inode",com.cr_labs.rfc4765.Inode.class);
		xs.alias("RFC4765Linkage",com.cr_labs.rfc4765.Linkage.class);
		xs.alias("RFC4765Node",com.cr_labs.rfc4765.Node.class);
		xs.alias("RFC4765OverflowAlert",com.cr_labs.rfc4765.OverflowAlert.class);
		xs.alias("RFC4765Process",com.cr_labs.rfc4765.Process.class);
		xs.alias("RFC4765Referene",com.cr_labs.rfc4765.Reference.class);
		xs.alias("RFC4765Service",com.cr_labs.rfc4765.Service.class);
		xs.alias("RFC4765Source",com.cr_labs.rfc4765.Source.class);
		xs.alias("RFC4765Target",com.cr_labs.rfc4765.Target.class);
		xs.alias("RFC4765ToolAlert",com.cr_labs.rfc4765.ToolAlert.class);
		xs.alias("RFC4765User",com.cr_labs.rfc4765.User.class);
		xs.alias("RFC4765UserId",com.cr_labs.rfc4765.UserId.class);
	}
	
	
	
	
}
