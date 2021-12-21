package bg.softuni.thespork.config;

import bg.softuni.thespork.service.impl.TheSporkUserService;
import org.springframework.boot.autoconfigure.security.servlet.PathRequest;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfiguration extends WebSecurityConfigurerAdapter {

    private final TheSporkUserService theSporkUserService;
    private final PasswordEncoder passwordEncoder;

    public ApplicationSecurityConfiguration(TheSporkUserService theSporkUserService, PasswordEncoder passwordEncoder) {
        this.theSporkUserService = theSporkUserService;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                authorizeRequests().
                antMatchers("/js/**", "/css/**", "/images/**").permitAll().
                antMatchers("/", "/users/login", "/users/register").permitAll().
                antMatchers("/**").authenticated().
                and().
                formLogin().
                loginPage("/users/login").
                usernameParameter("username").
                passwordParameter("password").
                defaultSuccessUrl("/home").
                failureForwardUrl("/users/login-error").
                and().
                logout().logoutUrl("/logout").
                logoutSuccessUrl("/").
                invalidateHttpSession(true).
                deleteCookies("JSESSIONID");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(theSporkUserService).passwordEncoder(passwordEncoder);
    }
}
