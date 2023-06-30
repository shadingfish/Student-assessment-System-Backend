package com.babybus.wangdy55.component;

import com.babybus.wangdy55.mapper.NodeMapper;
import com.babybus.yudingyi.util.JwtTokenUtil;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "xFilter", urlPatterns = "/api/**")
public class XFilter implements Filter {
    @Autowired
    private NodeMapper nodeMapper;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // 过滤器的逻辑
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        // 获取请求路径
        String path = httpRequest.getRequestURI().substring(httpRequest.getContextPath().length());
        System.out.println(path);
        // 获取请求头, 校验用户是否已登录
        String accessToken = httpRequest.getHeader("Authorization");
        if (accessToken == null) {
            httpResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "用户未登录");
            return;
        }
        // 若用户已经登录
        String cardId = jwtTokenUtil.getUsernameFromToken(accessToken);
        // 若请求路径不存在
        if (nodeMapper.getNode(path) == null) {
            httpResponse.sendError(HttpServletResponse.SC_NOT_FOUND, "找不到请求路径");
            return;
        }
        // 若请求路径存在, 但是用户权限不足
        if (nodeMapper.checkNode(cardId, path)) {
            System.out.println("用户权限不足");
            // 发送权限不足的错误响应
            httpResponse.sendError(HttpServletResponse.SC_FORBIDDEN, "用户权限不足");
            // 中断请求链，确保不再继续处理请求
            return;
        }

        chain.doFilter(request, response);
    }
}
