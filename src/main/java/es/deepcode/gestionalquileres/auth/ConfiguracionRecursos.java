/**
 * 
 */
package es.deepcode.gestionalquileres.auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * @author aocarballo
 *
 */
@Configuration
@EnableResourceServer
public class ConfiguracionRecursos extends ResourceServerConfigurerAdapter{

	//Damos los permisos, podemos indicar que tipo de usuario tiene permisos.
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
		.antMatchers(HttpMethod.GET, "/api/**").hasAnyRole("USER")
		.antMatchers(HttpMethod.POST, "/api/**").hasAnyRole("USER","ADMIN")
		.antMatchers(HttpMethod.PUT, "/api/**").hasAnyRole("USER","ADMIN")
		.antMatchers(HttpMethod.DELETE, "/api/**").hasAnyRole("ADMIN")
		.antMatchers(HttpMethod.OPTIONS, "/api/**").hasAnyRole("ADMIN")
		.antMatchers( "/api/**").hasAnyRole("ADMIN")
			.anyRequest().authenticated();
	}
	/*
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers(
				HttpMethod.OPTIONS, "/api/**").permitAll().
		antMatchers(HttpMethod.DELETE, "/api/**").permitAll().
		antMatchers(HttpMethod.PUT, "/api/**").permitAll()
		.antMatchers(HttpMethod.GET, "/api/**").permitAll()
		.antMatchers(HttpMethod.POST, "/api/**").permitAll()
			.anyRequest().authenticated()
			.and().cors().configurationSource(corsConfigurationSource());
	}
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
	CorsConfiguration config = new CorsConfiguration();
	config.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
	config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
	config.setAllowCredentials(true);
	config.setAllowedHeaders(Arrays.asList("Content-Type", "Authorization"));
	UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	source.registerCorsConfiguration("/**", config);
	return source;

	}

	@Bean
	public FilterRegistrationBean<CorsFilter> corsFilter(){
	FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(new CorsFilter(corsConfigurationSource()));
	bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
	return bean;
	}
	
	*/
}
