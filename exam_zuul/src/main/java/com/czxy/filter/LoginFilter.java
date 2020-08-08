package com.czxy.filter;

import com.czxy.domain.User;
import com.czxy.utils.JwtUtils;
import com.czxy.utils.RasUtils;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import javax.servlet.http.HttpServletRequest;

public class LoginFilter extends ZuulFilter {

    private static final  String pub = "G:\\ras\\ras.pub";
    private static final  String pri = "G:\\ras\\ras.pri";
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 1;
    }

    @Override
    public boolean shouldFilter() {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        String uri = request.getRequestURI();
        System.out.println(uri);
        if ("/api/userservice/user.login".equals(uri)){
            return false;
        }
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext currentContext = RequestContext.getCurrentContext();
        HttpServletRequest request = currentContext.getRequest();
        String s = request.getHeader("authorization");
        try {
            JwtUtils.getObjectFromToken(s, RasUtils.getPublicKey(pub), User.class);
        } catch (Exception e) {
            currentContext.setSendZuulResponse(false);
            currentContext.setResponseStatusCode(403);
        }
        return null;
    }
}
