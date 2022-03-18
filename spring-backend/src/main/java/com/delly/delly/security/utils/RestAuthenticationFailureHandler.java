package com.delly.delly.security.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class RestAuthenticationFailureHandler implements AuthenticationFailureHandler {

    @Autowired
    private Mapper mapper;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException {
        Map<String, Object> body = new HashMap<>();
//        User user = mapper.mapHTTPServletRequestBodyToObject(request, User.class);
        body.put("timestamp", Calendar.getInstance().getTime());
        body.put("error-message", exception.getMessage());
        response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        OutputStream out = response.getOutputStream();
        ObjectMapper mapper = new ObjectMapper();
        mapper.writerWithDefaultPrettyPrinter().writeValue(out, body);
        out.flush();
    }
}
