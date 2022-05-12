package nl.hhs.webapp.demo.model.user;

import nl.hhs.webapp.demo.config.security.Roles;
import nl.hhs.webapp.demo.util.annotation.ValidUser;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Collection;

import static javax.persistence.GenerationType.AUTO;

@ValidUser
@Entity(name = "User")
public class User implements UserDetails {

    @Id @GeneratedValue(strategy = AUTO)
    private Long
            Id;

    @NotNull
    @Size(min = 3, max = 50)
    private String
            name;

    @Email
    @NotBlank
    @NotNull
    private String
            email;

    @NotNull @NotEmpty
    @Size(min = 8, max = 32)
    private String
            password;

    @Transient
    public String confirmationPassword;

    private boolean locked = true, enabled = false;

    @Enumerated(EnumType.STRING)
    private Roles
            roles;

    public User(){}

    protected User (String name, String email, String password, String confirmationPassword){
        this.name = name;
        this.email = email;
        this.password = password;
        this.confirmationPassword = confirmationPassword;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.getPermissions();
//        return Collections.singletonList(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}