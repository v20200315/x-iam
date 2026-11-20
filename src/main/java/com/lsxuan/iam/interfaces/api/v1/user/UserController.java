package com.lsxuan.iam.interfaces.api.v1.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @GetMapping("/me")
    public Map<String, Object> me(@AuthenticationPrincipal Jwt jwt) {

        log.info("call api/v1/users/me");

        return Map.of("userId", jwt.getSubject(), "username", jwt.getClaimAsString("preferred_username"), "email",
            jwt.getClaimAsString("email"), "issuer", jwt.getIssuer().toString());
    }
}
