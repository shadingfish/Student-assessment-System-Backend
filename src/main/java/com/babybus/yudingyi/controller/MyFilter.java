package com.babybus.yudingyi.controller;

import com.babybus.yudingyi.service.RedisService;
import com.babybus.yudingyi.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

//@Component
@WebFilter(urlPatterns = "/admin-api/user/*")
public class MyFilter implements Filter {

    /**
     * 路径匹配，检查本次请求是否需要放行
     * @param urls
     * @param requestURI
     * @return
     */
    //路径匹配器，支持通配符
    public static final AntPathMatcher PATH_MATCHER = new AntPathMatcher();
    public boolean check(String[] urls,String requestURI){
        for (String url : urls) {
            boolean match = PATH_MATCHER.match(url, requestURI);
            if(match){
                return true;
            }
        }
        return false;
    }

    @Autowired
    RedisService redisService;

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // 在此处执行过滤器逻辑
        System.out.println("=====doFilter=====");

        // 获取请求中的 Token
        String token = httpRequest.getHeader("Authorization");
        System.out.println("获取token：" + token);
        String node = httpRequest.getRequestURI();
        System.out.println("访问接口：" + node );


        //定义不需要处理的请求路径
        String[] urls = new String[]{
                "/auth/login",
                "/auth/studentRegister",
                "/auth/facultyRegister",
                "/auth/captcha",
                "/favicon.ico",
        };

        //判断本次请求是否需要处理, 如果不需要处理，则直接放行
        boolean check = check(urls, node);
        if(check){
            System.out.println("本次请求不需要拦截");
            chain.doFilter(httpRequest, httpResponse);
            return;
        }

//        List<BigInteger> roleList = userMapper.findRole(new BigInteger(user_id));
//
//        Set<BigInteger> permissionCode = new HashSet<>();
//
//        for (BigInteger s : roleList) {
//            permissionCode.add(userMapper.getPermissionInfo(s));
//        }
//
//        List<String> roles = new ArrayList<>();
//        for (BigInteger role : roleList) {
//            roles.add(userMapper.getRoleName(role));
//        }
//
//        Set<String> permissions = new HashSet<>();
//        for (BigInteger code : permissionCode) {
//            permissions.add(userMapper.getPermissions(code));
//        }
//
//        // 根据用户角色进行权限判断
//        if (permissions.contains(node)) {
//            // 用户具有读取权限，继续处理请求
//            chain.doFilter(httpRequest, httpResponse);
//        } else {
//            // 用户没有足够的权限，返回错误信息或者进行相应的拦截处理
//            httpResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
//            httpResponse.getWriter().write("Insufficient permissions");
//        }

        // 解析Authorization请求头中的JWT令牌 Bearer access_token
        String cardId = jwtTokenUtil.getUsernameFromToken(token);
        System.out.println("学工号：" + cardId);
        // 在此处执行 RBAC 权限判断逻辑
        if (redisService.isValidToken(cardId)) {
            // 根据 Token 获取用户信息，例如用户权限
            System.out.println("用户合法");
            List<String> permissionUrls = redisService.getListValues(cardId);
            // 根据用户角色进行权限判断
            if (permissionUrls.contains(node)) {
                System.out.println("用户具有读取权限，继续处理请求");
                // 用户具有读取权限，继续处理请求
                chain.doFilter(httpRequest, httpResponse);
            } else {
                System.out.println("用户没有足够的权限");
                // 用户没有足够的权限，返回错误信息或者进行相应的拦截处理
                httpResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
                httpResponse.getWriter().write("Insufficient permissions");
            }
        }else {
            // Token 无效，返回错误信息或者进行相应的拦截处理
            httpResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            httpResponse.getWriter().write("Invalid token");
        }
//         //继续处理请求
//        chain.doFilter(httpRequest, httpResponse);
    }

    // 可以在init()和destroy()方法中进行一些初始化和清理操作

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 初始化过滤器
        // 在此处执行过滤器逻辑
        System.out.println("=====Filter init=====");
    }

    @Override
    public void destroy() {
        // 清理资源
        System.out.println("=====Filter destroy=====");
    }
}

