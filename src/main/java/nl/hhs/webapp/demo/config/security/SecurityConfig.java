package nl.hhs.webapp.demo.config.security;

import nl.hhs.webapp.demo.service.dao.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

//    @Value("${api.access.permitted}")
//    private String[] PERMITTED;
    private final UserService USER_SERVICE;
    private final BCryptPasswordEncoder PASSWORD_ENCODER;
    private final Access access;

    @Autowired
    public SecurityConfig(UserService userService, BCryptPasswordEncoder passwordEncoder, Access access) {
        USER_SERVICE = userService;
        PASSWORD_ENCODER = passwordEncoder;
        this.access = access;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeRequests().antMatchers(access.permitted())
                    .permitAll()
                    .anyRequest()
                .authenticated()
                    .and()
                .formLogin();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authProvider());
    }

    @Bean
    public DaoAuthenticationProvider authProvider(){
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
        provider.setPasswordEncoder(PASSWORD_ENCODER);
        provider.setUserDetailsService(USER_SERVICE);
        return provider;
    }
}
