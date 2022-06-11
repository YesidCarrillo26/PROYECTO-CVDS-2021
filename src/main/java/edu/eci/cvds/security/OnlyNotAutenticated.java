package edu.eci.cvds.security;

import javax.servlet.ServletRequest;

import javax.servlet.ServletResponse;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;

import edu.eci.cvds.managedbeans.ShiroBean;

import org.apache.shiro.SecurityUtils;

public class OnlyNotAutenticated extends AccessControlFilter {

    String welcomeurl;

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        Subject subject = getSubject(request, response);
        return !subject.isAuthenticated(); // THE POINT

    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {

        if (SecurityUtils.getSubject().hasRole("Administrador")) {
            welcomeurl="/faces/login.xhtml";
        } else if(SecurityUtils.getSubject().hasRole("Usuario")){
            welcomeurl="/faces/login.xhtml";
        }
        WebUtils.issueRedirect(request, response, welcomeurl);
        return false;//What to do if try to go to login -> go welcome page of auth ursers
    }

    public String getWelcomeurl() {
        return welcomeurl;
    }

    public void setWelcomeurl(String welcomeurl) {
        this.welcomeurl = welcomeurl;
    }
}