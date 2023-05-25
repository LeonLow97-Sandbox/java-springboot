package com.ltp.gradesubmission.security.filter;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ltp.gradesubmission.entity.User;

public class AuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    // /login

    @Override
    public Authentication attemptAuthentication(HttpServletRequest request,
            HttpServletResponse response) throws AuthenticationException {

        try {
            // get the body of the request as binary data
            // Throws an exception if the objectmapper, fails to deserialize and map the request
            // stream to the properties in User.class
            User user = new ObjectMapper().readValue(request.getInputStream(), User.class);

            // If request is okay, pass the user object to the Authentication Manager
            System.out.println(user.getUsername());
            System.out.println(user.getPassword());
        } catch (IOException e) {
            throw new RuntimeException();
        }
        return super.attemptAuthentication(request, response);
    }

}
