/**
 * 
 */
package es.deepcode.gestionalquileres.auth;

import java.util.Arrays;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

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
			.antMatchers(HttpMethod.GET, "/**").permitAll()
			/*.antMatchers(HttpMethod.GET, "/api/**").hasAnyRole("USER")
			.antMatchers(HttpMethod.POST, "/api/**").hasAnyRole("USER","ADMIN")
			.antMatchers(HttpMethod.PUT, "/api/**").hasAnyRole("USER","ADMIN")
			.antMatchers(HttpMethod.DELETE, "/api/**").hasAnyRole("ADMIN")
			.antMatchers(HttpMethod.OPTIONS, "/api/**").hasAnyRole("ADMIN")
			.antMatchers( "/api/**").hasAnyRole("ADMIN")*/
				.anyRequest().authenticated()
				.and().cors().configurationSource(corsConfigurationSource());
		}
		@Bean
		public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration config = new CorsConfiguration();
		//Configuramos el dominio de Origen
		config.setAllowedOrigins(Arrays.asList("http://localhost:4200"));
		//Metodos que permitimos
		config.setAllowedMethods(Arrays.asList("GET","POST","PUT","DELETE","OPTIONS"));
		//Permitimos credenciales
		config.setAllowCredentials(true);
		//Permitimos cabeceras
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
}
