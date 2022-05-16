package com.mbsystems.quickpolldemo.config;

import com.mbsystems.quickpolldemo.entities.Admin;
import com.mbsystems.quickpolldemo.entities.User;
import com.mbsystems.quickpolldemo.repository.UserRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsService userDetailsService( UserRepository userRepository ) {
        return username -> {
            User user = userRepository.findUserByUsername( username );

            if ( user == null ) {
                throw new UsernameNotFoundException( String.format( "User with the username %s doesn't exist", username ) );
            }

            Collection<? extends GrantedAuthority>  authorities = new ArrayList<>();

            if ( user.getAdmin().equals( Admin.YES ) ) {
                authorities = AuthorityUtils.createAuthorityList( "ROLE_ADMIN" );
            }

            UserDetails userDetails = new org.springframework.security.core.userdetails.User( user.getUsername(),
                                                                                              user.getPassword(),
                                                                                              authorities );

            return userDetails;
        };
    }
}
