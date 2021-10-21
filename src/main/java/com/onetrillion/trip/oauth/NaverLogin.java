package com.onetrillion.trip.oauth;

import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.ExecutionException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.oauth.OAuth20Service;
import com.onetrillion.trip.user.UserDTO;

public class NaverLogin {
	private OAuth20Service oauthService;
	private String profileUrl;
	private String service;
	
	public NaverLogin(NaverValue Naver) {
		this.oauthService = new ServiceBuilder(Naver.getClientId())
				.apiSecret(Naver.getClientSecret())
				.callback(Naver.getRedirectUrl())
				.scope("profile")
				.build(Naver.getApi20Instance());
		
		this.profileUrl = Naver.getProfileUrl();
	}

	public String getNaverAuthURL() {
		
		return this.oauthService.getAuthorizationUrl();
	}

	public UserDTO getUserProfile(String code) throws Exception {
		OAuth2AccessToken accessToken = oauthService.getAccessToken(code);
		
		OAuthRequest request = new OAuthRequest(Verb.GET, this.profileUrl);
		
		oauthService.signRequest(accessToken, request);		
		Response response = oauthService.execute(request);
		return parseJson(response.getBody());	
	}

	private UserDTO parseJson(String body) throws Exception {
		UserDTO user = new UserDTO();
		
		ObjectMapper mapper = new ObjectMapper();
		JsonNode rootNode = mapper.readTree(body);
		
		JsonNode naverNode = rootNode.get("response");
		user.setU_email(naverNode.get("email").asText());
		return user;
	}
}
