package sda.spring.config;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.GenericFilterBean;

import sda.spring.service.TokenAuthenticationService;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private TokenAuthenticationService tokenAuthenticationService;

    @Autowired
    private UserDetailsService userService;

    @Override
    protected void configure(final HttpSecurity http) throws Exception {

        http.csrf().disable().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests()
                // Allow anonymous resource requests
                .antMatchers("/").permitAll().antMatchers("/favicon.ico").permitAll().antMatchers("**/*.html")
                .permitAll().antMatchers("**/*.css").permitAll().antMatchers("**/*.js").permitAll()
                .antMatchers(HttpMethod.OPTIONS).permitAll()
                .antMatchers("/swagger-ui.html").permitAll()
                .antMatchers("/webjars/springfox-swagger-ui/**").permitAll()
                .antMatchers("/webjars/springfox-swagger-ui/**").permitAll().antMatchers("/configuration/**")
                .permitAll().antMatchers("/swagger-resources/**").permitAll().antMatchers("/spring-security-rest/**")
                .permitAll().antMatchers("/api-docs/**").permitAll().antMatchers("/v2/api-docs/**").permitAll().antMatchers("/version").permitAll()
                //allow anonymous login and register
                .antMatchers("/loginProcess").permitAll()
                .antMatchers("/registerProcess").permitAll()
                // All other request need to be authenticated
                .anyRequest().authenticated().and()

                // Custom Token based authentication based on the header
                // previously given to the client
                .addFilterBefore(new StatelessAuthenticationFilter(tokenAuthenticationService),
                        UsernamePasswordAuthenticationFilter.class);

    }

    @Bean
    public UserDetailsChecker userDetailsChecker() {
        return new AccountStatusUserDetailsChecker();
    }

    @Override
    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService);
    }


    private static final class StatelessAuthenticationFilter extends GenericFilterBean {

        private final TokenAuthenticationService authenticationService;

        StatelessAuthenticationFilter(final TokenAuthenticationService authenticationService) {
            this.authenticationService = authenticationService;
        }

        @Override
        public void doFilter(final ServletRequest request, final ServletResponse response, final FilterChain chain)
                throws IOException, ServletException {
            final HttpServletRequest httpRequest = (HttpServletRequest) request;
            final HttpServletResponse httpResponse = (HttpServletResponse) response;
            final Authentication authentication = authenticationService.getAuthentication(httpRequest, httpResponse);
            SecurityContextHolder.getContext().setAuthentication(authentication);
            try {
                chain.doFilter(request, response);
            } finally {
                SecurityContextHolder.getContext().setAuthentication(null);
            }
        }

    }

}
