package com.ltp.gradesubmission.security.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class FilterOne implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println(((HttpServletRequest) request).getRequestURI());

        System.out.println("Filter 1...");

        // doFilter passes the request to the next filter in the filter chain
        chain.doFilter(request, response);
    }
}
