package config;

import com.wrapper.spotify.SpotifyApi;
import com.wrapper.spotify.SpotifyHttpManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.net.URI;

@Configuration //burada @Service vardi
public class SpotifyConfiguration {
    @Value("${redirect.server.ip}")
    private String customIp;
    @Value("${spotify.client.id}")
    private String clientId;
    @Value("${spotify.client.secret}")
    private String clientSecret;


    public SpotifyApi getSpotifyObject(){
        URI redirectedURL = SpotifyHttpManager.makeUri(customIp + "/api/get-user-code/");


        return new SpotifyApi
                .Builder()
                .setClientId(clientId)
                .setClientSecret(clientSecret)
                .setRedirectUri(redirectedURL)
                .build();
    }
}
