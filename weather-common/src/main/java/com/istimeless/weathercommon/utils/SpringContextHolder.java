package com.istimeless.weathercommon.utils;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Map;

/**
 * @author lijiayin
 */
@SuppressWarnings("unchecked")
public class SpringContextHolder implements ApplicationContextAware {

    private static ApplicationContext applicationContext;

    public static <T> T getBean(String beanName) {
        return (T) applicationContext.getBean(beanName);
    }

    public static <T> T getBean(Class<?> cls) {
        return (T) applicationContext.getBean(cls);
    }

    public static <T> T getBean(String beanName, Class<?> cls) {
        return (T) applicationContext.getBean(beanName, cls);
    }

    public static <T> Map<String, T> getBeans(Class<?> cls) {
        return (Map<String, T>) applicationContext.getBeansOfType(cls);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextHolder.applicationContext = applicationContext;
    }
}
