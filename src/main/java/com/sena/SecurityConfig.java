package com.sena;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
		return httpSecurity.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	public AuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(null);
		provider.setUserDetailsService(null);
		return provider;
	}

	@Bean
	public InMemoryUserDetailsManager userDetailsService() {
		UserDetails userl = User.withUsername("user").password(passwordEncoder().encode("user")).roles("USER").build();
		UserDetails admin = User.withUsername("admin").password(passwordEncoder().encode("admin")).roles("ADMIN")
				.build();
		return new InMemoryUserDetailsManager(userl, admin);
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		return httpSecurity.csrf(Csrf -> Csrf.disable()).httpBasic(Customizer.withDefaults())
				.sessionManagement(Session -> Session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
				.authorizeHttpRequests(http -> {
					// configurar los endpoints publicos//
					http.requestMatchers(HttpMethod.GET, "/login", "/inicio", "/Registro/", "/casas", "/venta",
							"/alquiler", "/arriendo", "/edificios", "/oficinas", "/locales", "/fincas", "/terrenos",
							"/lotes", "/apartamentos", "/habitaciones","/PublicControlador", "/FormuCrearpublic", "/PaginaPrincipal", "/js/**", "/css/**", "/img/**", "/imagenes/**",
							"/secciones/**", "/vendor/**", "/scss/**").permitAll();
					// configurar los endpoints privados//
					http.requestMatchers(HttpMethod.GET, "usuario")
							.hasAnyRole("ADMIN", "USER");
					// configurar los endpoints no especificados
					http.anyRequest().denyAll();
				}).build();
	}


}
