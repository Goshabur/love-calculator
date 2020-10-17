package ru.gosha.spring.test.config;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

public class AppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        Class[] classes = {ApplicationConfig.class};
        return classes;
    }

    @Override
    protected String[] getServletMappings() {
        String[] array = {"/"};
        return array;
    }
}
