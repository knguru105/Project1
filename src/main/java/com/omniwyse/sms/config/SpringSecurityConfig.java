package com.omniwyse.sms.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.omniwyse.sms.filter.MyAuthenticationFilter;
import com.omniwyse.sms.utils.MyAccessDeniedHandler;

@EnableGlobalMethodSecurity(prePostEnabled = true)
@EnableWebSecurity
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(SpringSecurityConfig.class);

    @Autowired
    @Qualifier("userDetailsService")
    UserDetailsService userDetailsService;
    
    @Autowired
    private MyAccessDeniedHandler accesshandler;

    @Override
    protected void configure(HttpSecurity httpsecurity) {
        try {
        	
        	LOGGER.info("**** SpringSecurity config is Triggered ****");
        	
            httpsecurity.csrf().disable();
            
            httpsecurity.addFilterBefore(new MyAuthenticationFilter(), BasicAuthenticationFilter.class);

            httpsecurity.authorizeRequests().antMatchers("/tenant/register/**","/tenant/for/**","/tenant/login/**").permitAll().anyRequest().fullyAuthenticated();
//             httpsecurity.authorizeRequests().antMatchers("/tenant/for/**").permitAll().anyRequest().fullyAuthenticated();
//             httpsecurity.authorizeRequests().antMatchers("/tenant/login/**").permitAll().anyRequest().fullyAuthenticated();

            httpsecurity.httpBasic();
            
            httpsecurity.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService);
//        .passwordEncoder(new PasswordEncoder() {
//            @Override
//            public String encode(CharSequence charSequence){
//                return charSequence.toString();
//            }
//            @Override
//            public boolean matches(CharSequence charSequence,String s){
//                return true;
//            }
//        });
    }
    
}
