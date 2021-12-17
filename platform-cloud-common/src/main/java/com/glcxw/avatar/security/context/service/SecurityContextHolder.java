package com.glcxw.avatar.security.context.service;

import com.glcxw.avatar.security.context.SecurityContext;
import com.glcxw.avatar.security.context.SecurityContextHolderStrategy;

public class SecurityContextHolder {

    private static int initializeCount = 0;

    private static SecurityContextHolderStrategy strategy;

    static {
        initialize();
    }

    public SecurityContextHolder() {
    }

    public static void clearContext() {
        strategy.clearContext();
    }

    public static SecurityContext getContext() {
        return strategy.getContext();
    }

    public static int getInitializeCount() {
        return initializeCount;
    }

    private static void initialize() {
        strategy = new ThreadLocalSecurityContextHolderStrategy();
        ++initializeCount;
    }

    public static void setContext(SecurityContext context) {
        strategy.setContext(context);
    }

    public static SecurityContextHolderStrategy getContextHolderStrategy() {
        return strategy;
    }

    public static SecurityContext createEmptyContext() {
        return strategy.createEmptyContext();
    }

}