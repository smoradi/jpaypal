package mars.jpaypal.server.service;

import com.paypal.core.rest.OAuthTokenCredential;
import com.paypal.core.rest.PayPalRESTException;

import mars.jpaypal.domain.build.BuildProps;

public class AccessTokenGenerator {
  private static String accessToken;

  public static String getAccessToken() throws PayPalRESTException {
    // Retrieve the access token from OAuthTokenCredential by passing in
    // ClientID and ClientSecret
    if (accessToken == null) {
      accessToken = new OAuthTokenCredential(BuildProps.clientID, BuildProps.clientSecret).getAccessToken();
    }
    return accessToken;
  }

}