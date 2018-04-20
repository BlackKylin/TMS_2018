package com.wyx.tms.shiro;

import com.wyx.tms.entity.Permission;
import com.wyx.tms.service.PermissionService;
import org.apache.shiro.config.Ini;
import org.apache.shiro.web.filter.mgt.DefaultFilterChainManager;
import org.apache.shiro.web.filter.mgt.PathMatchingFilterChainResolver;
import org.apache.shiro.web.servlet.AbstractShiroFilter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;

import static sun.font.FontManagerNativeLibrary.load;

public class CustomerFilterChainDefinitions {

    private Logger logger = LoggerFactory.getLogger(CustomerFilterChainDefinitions.class);

    @Autowired
    private PermissionService permissionService;

    private String filterChainDefinitions;

    private AbstractShiroFilter shiroFilter;

    public void setFilterChainDefinitions(String filterChainDefinitions) {
        this.filterChainDefinitions = filterChainDefinitions;
    }

    public void setShiroFilter(AbstractShiroFilter shiroFilter){
        this.shiroFilter =shiroFilter;
    }

    @PostConstruct
    public synchronized void init(){
        logger.info("********************初始化url权限**************************");
        getFilterChainManager().getFilterChains().clear();
        load();
        logger.info("********************初始化url权限结束**************************");


    }

    @PostConstruct
    public synchronized void update(){

        logger.info("********************刷新url权限**************************");
        getFilterChainManager().getFilterChains().clear();
        load();
        logger.info("********************刷新url权结束**************************");

    }

    public synchronized void load(){

        Ini ini = new Ini();
        ini.load(filterChainDefinitions);

        //从数据库中查找所有的权限
        List<Permission> permissionList = permissionService.findPermissionAll();
        Ini.Section section = ini.getSection(Ini.DEFAULT_SECTION_NAME);

        for(Permission permission : permissionList){
            section.put(permission.getUrl(),"perms["+permission.getPermissionCode()+"]");
        }
        section.put("/**","user");

        DefaultFilterChainManager defaultFilterChainManager = getFilterChainManager();
        for(Map.Entry<String,String> entry : section.entrySet()) {
            defaultFilterChainManager.createChain(entry.getKey(), entry.getValue());
        }
    }

    public DefaultFilterChainManager getFilterChainManager(){
        PathMatchingFilterChainResolver pathMatchingFilterChainResolver = (PathMatchingFilterChainResolver) shiroFilter.getFilterChainResolver();
        DefaultFilterChainManager defaultFilterChainManager = (DefaultFilterChainManager) pathMatchingFilterChainResolver.getFilterChainManager();
        return defaultFilterChainManager;
    }

}
