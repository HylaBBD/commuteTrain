package com.commutetrip.backend.components;

import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Component;

import com.commutetrip.backend.services.CommuterService;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class AuthenticationEvents {
    private final CommuterService commuterService;

    @EventListener
    public void onSuccess(AuthenticationSuccessEvent success) {

        if (success.getAuthentication().getPrincipal() instanceof OidcUser) {
            OidcUser principal = ((OidcUser) success.getAuthentication().getPrincipal());

            if (commuterService.findByAwsUserId(principal.getClaim("sub").toString()).isEmpty()) {
                commuterService.saveCommuter(principal.getClaim("name").toString(),
                        principal.getClaim("sub").toString());
            }
        }
    }
}
