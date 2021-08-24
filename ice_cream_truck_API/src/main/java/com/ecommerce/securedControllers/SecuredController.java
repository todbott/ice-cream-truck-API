// -- NOTE ---
// This API originally used Spring Security and Java Web Tokens (JWT)
// to secure the endpoints.  For the current ice cream truck API,
// securing the endpoints was not necessary, so this file is not
// necessary.

package com.ecommerce.securedControllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/secure")
public class SecuredController {

    @GetMapping
    public @ResponseBody String reachSecureEndpoint() {

        return "This was an endpoint used for testing the JWT security system.";
    }
}