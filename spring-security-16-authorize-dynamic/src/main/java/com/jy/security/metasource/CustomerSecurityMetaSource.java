package com.jy.security.metasource;


import com.jy.entity.Menu;
import com.jy.entity.Role;
import com.jy.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;

import java.util.Collection;
import java.util.List;


@Component
public class CustomerSecurityMetaSource implements FilterInvocationSecurityMetadataSource {

    AntPathMatcher antPathMatcher = new AntPathMatcher();

    private  final MenuService menuService;

    @Autowired
    public CustomerSecurityMetaSource(MenuService menuService) {
        this.menuService = menuService;
    }

    @Override
    public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
        //1.当前请求对象
        String requestURI = ((FilterInvocation) object).getRequest().getRequestURI();
        //2.查询所有菜单
        List<Menu> allMenu = menuService.getAllMenu();

        for (Menu menu : allMenu) {
            if (antPathMatcher.match(menu.getPattern(), requestURI)) {
                String[] roles = menu.getRoles().stream().map(Role::getName).toArray(String[]::new);

                return SecurityConfig.createList(roles);
            }
        }
        return null;
    }

    @Override
    public Collection<ConfigAttribute> getAllConfigAttributes() {
        return null;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return FilterInvocation.class.isAssignableFrom(clazz);
    }
}
