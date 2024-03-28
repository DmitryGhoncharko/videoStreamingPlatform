package com.example.videostreamingplatform.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Slf4j
@Component
public class AuthFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            String requestUrl = httpRequest.getRequestURL().toString();
            String pageName = requestUrl.replace("http://127.0.0.1:8080/","");
            log.error(requestUrl);
            Cookie[] cookies = httpRequest.getCookies();
            boolean cookieFound = false;
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if ("username".equals(cookie.getName())) {
                        if(cookie.getValue().equals("adminLogin")){
                            cookieFound = true;
                            break;
                        }else if(!pageName.equals("admin-info")){
                            cookieFound = true;
                            break;
                        }else if(pageName.equals("admin-panel")){
                            cookieFound = true;
                            break;
                        }
                    }
                }
            }
             if(pageName.equals("login") || pageName.equals("register") || pageName.equals("logout") || pageName.equals("") || pageName.equals("/") || pageName.equals("admin-panel") || pageName.equals("loginAdmin")) {
                cookieFound = true;
            }
            if (!cookieFound) {
                httpResponse.sendRedirect("http://127.0.0.1:8080");
                return;
            }
            chain.doFilter(request, response);
    }
}
