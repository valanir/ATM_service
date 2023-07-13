package app.security;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;

@Log4j2
@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity httpSec) throws Exception {
    httpSec
      .csrf().disable()
      .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
      .and()
      .cors()
      .and()
      .authorizeRequests()
      .antMatchers("/").permitAll()
      .antMatchers("/api/v1/manager/*").permitAll()
      .antMatchers("/swagger-ui/**").permitAll()
      .antMatchers("/swagger-resources").permitAll()
      .antMatchers("/swagger-resources/**").permitAll()
      .antMatchers("/webjars/**").permitAll()
      .antMatchers("/v2/api-docs").permitAll()
      .antMatchers("/h2/**").permitAll()

      .anyRequest().authenticated()
      .and()
      .exceptionHandling().authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED));

    httpSec.headers().frameOptions().disable();
    return httpSec.build();
  }
}


