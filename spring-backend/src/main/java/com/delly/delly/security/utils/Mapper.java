package com.delly.delly.security.utils;

import com.google.gson.Gson;
import org.springframework.context.annotation.Configuration;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.stream.Collectors;

@Configuration
public class Mapper {

    public <T> T mapHTTPServletRequestBodyToObject(HttpServletRequest request, Class<T> tClass) throws IOException {
        String data = request.getReader().lines().collect(Collectors.joining());
        Gson g = new Gson();
        return g.fromJson(data, tClass);
    }
}
