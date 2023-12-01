package com.sfs.sellhappiness.global.infra;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@WebListener
public class AppInitListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent sce)  {
        log.info("AppInitListener.contextDestroyed......");
    }

    public void contextInitialized(ServletContextEvent sce)  {
        log.info("AppInitListener.contextInitialized......");
        ServletContext application = sce.getServletContext();
        application.setAttribute("root", application.getContextPath());
    }

	
}
