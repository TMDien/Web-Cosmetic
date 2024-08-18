package tmd.project.ShopCosmetic.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

// import org.studyeasy.demo.util.constants.Privillages;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(securedEnabled = true)
public class WebSecurityConfig {
    private static final String[] WHITELIST = {
            "/",
            "/login",
            "/register",
            "/post/**",
            "/post/edit/**",
            "posts/add**",
            "posts/**",
            "/db-console/**",
            "/assets/css/**",
            "/assets/fonts/**",
            "/assets/img/**",
            "/update_photo",
            "/forgot-password",
            "/reset-password",
            "/change-password",
            "/**",
            "/api/v1/**",
            "/home_user"

    };
    
    @Bean
    public static PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .headers(headers -> headers.frameOptions(options -> options.sameOrigin()))
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers(WHITELIST).permitAll()
                        .requestMatchers("/profile/**").authenticated()
                        .requestMatchers("/admin/**").hasRole("ADMIN")
                        .requestMatchers("/editor/**").hasAnyRole("ADMIN", "EDITOR"))   
                .formLogin(login -> login
                        .loginPage("/login").loginProcessingUrl("/login")
                        .usernameParameter("email").passwordParameter("password")
                        .defaultSuccessUrl("/", true).failureUrl("/login?error")
                        .permitAll())
                .logout(logout -> logout.logoutUrl("/logout")
                        .logoutSuccessUrl("/"))        
                .httpBasic(withDefaults());



        http.csrf(csrf -> csrf.disable());
        http.headers(headers -> headers.frameOptions(options -> options.disable()));

        return http.build();
    }
}
