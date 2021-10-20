package com.onetrillion.trip.oauth;



import org.apache.commons.lang3.StringUtils;

import com.github.scribejava.core.builder.api.DefaultApi20;

import lombok.Data;

@Data
public class NaverValue implements NaverUrls {
	
	private String serivce;
	private String clientId;
	private String clientSecret;
	private String redirectUrl;
	private DefaultApi20 api20Instance;
	private String profileUrl;
	
	public NaverValue(String service, String clientId, String clientSecret, String redirectUrl) {
			this.serivce = service;
			this.clientId = clientId;
			this.clientSecret = clientSecret;
			this.redirectUrl = redirectUrl;
			if(StringUtils.equalsIgnoreCase(service, "naver")) {
				this.api20Instance = NaverAPI20.Instance();
				this.profileUrl = NAVER_PROFILE_URL;
			}
	}
}
