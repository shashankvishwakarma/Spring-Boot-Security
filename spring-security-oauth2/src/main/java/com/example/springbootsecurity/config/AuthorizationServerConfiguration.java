package com.example.springbootsecurity.config;

import com.example.springbootsecurity.constants.OAuth2Constant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JwtAccessTokenConverter;

/**
 * Configures the authorization server.
 * The @EnableAuthorizationServer annotation is used to configure the OAuth 2.0 Authorization Server mechanism.
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

    /**
     * Setting up the endpointsconfigurer authentication manager.
     * The AuthorizationServerEndpointsConfigurer defines the authorization and token endpoints and the token services.
     *
     * @param endpoints
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
        endpoints.authenticationManager(authenticationManager);
    }

    /**
     * Setting up the clients with a clientId, a clientSecret, a scope, the grant types and the authorities.
     *
     * @param configurer
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer configurer) throws Exception {

        configurer
                .inMemory()
                .withClient(OAuth2Constant.CLIENT_ID)
                .secret(passwordEncoder().encode(OAuth2Constant.CLIENT_SECRET))
                /*.resourceIds(OAuth2Constant.RESOURCE_ID)*/
                .authorizedGrantTypes(OAuth2Constant.GRANT_TYPE_PASSWORD, OAuth2Constant.AUTHORIZATION_CODE, OAuth2Constant.REFRESH_TOKEN, OAuth2Constant.IMPLICIT)
                .scopes(OAuth2Constant.SCOPE_READ, OAuth2Constant.SCOPE_WRITE, OAuth2Constant.SCOPE_TRUST)
                .accessTokenValiditySeconds(OAuth2Constant.ACCESS_TOKEN_VALIDITY_SECONDS)
                .refreshTokenValiditySeconds(OAuth2Constant.REFRESH_TOKEN_VALIDITY_SECONDS);
    }

    /**
     * We here defines the security constraints on the token endpoint.
     * We set it up to isAuthenticated, which returns true if the user is not anonymous
     *
     * @param security the AuthorizationServerSecurityConfigurer.
     * @throws Exception
     * @para /**
     * We here defines the security constraints on the token endpoint.
     * We set it up to isAuthenticated, which returns true if the user is not anonymous
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security.checkTokenAccess("isAuthenticated()");
    }
}
