package xyz.acproject.danmuji.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
public class CrossOriginConfig {
	
	@Bean
	public CorsFilter corsFilter() {
		CorsConfiguration con = new CorsConfiguration();
		con.addAllowedOrigin("*");
		con.addAllowedMethod("*");
		con.addAllowedHeader("*");
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", con);
		return new CorsFilter(source);
	}

}
