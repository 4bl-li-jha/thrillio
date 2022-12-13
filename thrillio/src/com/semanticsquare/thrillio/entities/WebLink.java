package com.semanticsquare.thrillio.entities;

import com.sematicsquare.thrillio.partner.Sharable;

public class WebLink extends Bookmark implements Sharable{
	private String url;
	private String host;

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getHost() {
		return host;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public String toString() {
		return "WebLink [url=" + url + ", host=" + host + "]";
	}

	public boolean isKidFriendlyEligible() {
		if(url.contains("porn")||getTitle().contains("porn")||host.contains("adult"))
			return false;
		return true;
	}

	
	public String getItemData() {
		StringBuilder builder= new StringBuilder();
		builder.append("<item>");
			builder.append("<type>WebLink</type>");
			builder.append("<title>").append(getTitle()).append("</title>");
			builder.append("<url>").append(url).append("</url>");
			builder.append("<host>").append(host).append("</host>");
		builder.append("<item>");
		
		return builder.toString();
	}
	
}
