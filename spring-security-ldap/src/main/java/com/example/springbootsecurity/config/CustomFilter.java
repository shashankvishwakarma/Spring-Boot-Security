package com.example.springbootsecurity.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.security.Principal;

//@Component
public class CustomFilter implements Filter {

    final static Logger LOGGER = LoggerFactory.getLogger(CustomFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        LOGGER.info("Init::called");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        LOGGER.info("doFilter::called");

        HttpServletRequest request = (HttpServletRequest) servletRequest;

        Principal userPrincipal = request.getUserPrincipal();
        LOGGER.info("userPrinciple::{}",userPrincipal);
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        LOGGER.info("Destroy::called");

    }
}
