// -- NOTE ---
// This API originally used Spring Security and Java Web Tokens (JWT)
// to secure the endpoints.  For the current ice cream truck API,
// securing the endpoints was not necessary, so this file is not
// necessary.

package com.ecommerce.database;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;



@Entity
public class AppUser {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
 
    private long id;
    private String username;
    private String password;
    private String role;
 

  
    public long getId() {
      return id;
    }
  
    public void setId(long id) {
      this.id = id;
    }
  
    public String getName() {
      return username;
    }
  
    public void setName(String username) {
      this.username = username;
    }
  
    public String getPassword() {
      return password;
    }
  
    public void setPassword(String password) {
      this.password = password;
    }

    public String getRole() {
      return role;
    }
  
    public void setRole(String role) {
      this.role = role;
    }   

}
