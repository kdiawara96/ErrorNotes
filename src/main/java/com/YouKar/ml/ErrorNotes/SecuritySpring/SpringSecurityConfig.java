package com.YouKar.ml.ErrorNotes.SecuritySpring;

import com.YouKar.ml.ErrorNotes.Models.Personnes;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {


    //Par defaut elle utilise un seul utilisateur qui s'appelle user donc on change
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {


        // c'est une strategie de stockage en memoire
        auth.inMemoryAuthentication().withUser("User").password("azerty").roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

       //Avec ça le navigateur nous donnes un autre formulaire d'auth pour nous loguer
        // http.httpBasic();

        http.formLogin().loginPage("/loginPage");
        http.authorizeRequests().anyRequest().authenticated();
    }


}
