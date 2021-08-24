// -- NOTE ---
// This API originally used Spring Security and Java Web Tokens (JWT)
// to secure the endpoints.  For the current ice cream truck API,
// securing the endpoints was not necessary, so this file is not
// necessary.

package com.ecommerce.database;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<AppUser, Long> {

    @Query("select u from AppUser u where u.username = ?1")
    AppUser findByUsername(String username);
}