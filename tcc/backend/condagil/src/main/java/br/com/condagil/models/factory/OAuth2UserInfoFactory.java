package br.com.condagil.models.factory;

import java.util.Map;

import br.com.condagil.exception.OAuth2AuthenticationProcessingException;
import br.com.condagil.models.dto.oauth.GoogleOAuth2UserInfo;
import br.com.condagil.models.dto.oauth.OAuth2UserInfo;
import br.com.condagil.models.enums.SocialProvider;

public class OAuth2UserInfoFactory {

	public static OAuth2UserInfo getOAuth2UserInfo(String registrationId, Map<String, Object> attributes) {
        if (registrationId.equalsIgnoreCase(SocialProvider.GOOGLE.getProviderType())) {
            return new GoogleOAuth2UserInfo(attributes);
        } else {
            throw new OAuth2AuthenticationProcessingException("Sorry! Login with " + registrationId + " is not supported yet.");
        }
    }
	
}