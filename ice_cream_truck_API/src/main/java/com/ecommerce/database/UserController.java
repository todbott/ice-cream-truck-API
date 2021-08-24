// -- NOTE ---
// This API originally used Spring Security and Java Web Tokens (JWT)
// to secure the endpoints.  For the current ice cream truck API,
// securing the endpoints was not necessary, so this file is not
// necessary.

package com.ecommerce.database;

import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController

@RequestMapping("/users")

// This allows us to add new users and passwords to the database
public class UserController {

    private UserRepository applicationUserRepository;
    public BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserController(UserRepository applicationUserRepository,
                          BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.applicationUserRepository = applicationUserRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    @PostMapping(value = "/record", consumes = MediaType.ALL_VALUE)
    public void signUp(@RequestBody AppUser user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        applicationUserRepository.save(user);
    }
}
