package com.ignotocracia.app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.ignotocracia.app.security.jwt.JwtEntryPoint;
import com.ignotocracia.app.security.jwt.JwtTokenFilter;
import com.ignotocracia.app.security.service.UsuarioDetailsServiceImpl;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
//@EnableGlobalMethodSecurity establece a qué métodos puede acceder solo el administrador.
/**
 * @author paula.carmona.moreno
 *Esta clase administra toda la autentificación
 */
public class MainSecurity  extends WebSecurityConfigurerAdapter{
	
	@Autowired
	 UsuarioDetailsServiceImpl userDetailsService;
	/**
	 * Simplemente devuelve mensaje de no autorizado
	 */
	@Autowired
	 JwtEntryPoint jwtEntryPoint;

    @Bean
    public JwtTokenFilter jwtTokenFilter(){
        return new JwtTokenFilter();
    }
    /**
     * 
     * @return  new BCryptPasswordEncoder()
     */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    
    //Sobrescribimos los métodos necesarios
    /**
     * Cifrado de contraseña
     */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	 auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}
	@Bean
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		
		return super.authenticationManagerBean();
	}
	@Override
	protected AuthenticationManager authenticationManager() throws Exception {

		return super.authenticationManager();
	}
	/**
	 * En este método se configura todo.
	 * Se necesita estar autenticado para los dos ultimos métodos
	 * A los dos primeros puede acceder todo el mundo
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable()
          .authorizeRequests()
          .antMatchers("/auth/**").permitAll()
          .anyRequest().authenticated()
          .and()
          .exceptionHandling().authenticationEntryPoint(jwtEntryPoint)
          .and()
          .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		  
		 http.addFilterBefore(jwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
	}
    
    

}
