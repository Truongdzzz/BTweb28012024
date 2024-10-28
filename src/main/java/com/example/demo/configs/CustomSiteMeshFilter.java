package com.example.demo.configs;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;

public class CustomSiteMeshFilter extends ConfigurableSiteMeshFilter {
    protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
        builder.addDecoratorPath("/*", "/web.jsp")
                .addDecoratorPath("/admin/*", "/admin.jsp")
                .addExcludedPath("/login*").addExcludedPath("/login/*")
                .addExcludedPath("/alogin*").addExcludedPath("/alogin/*")
                .addExcludedPath("/api/**").addExcludedPath("/api/**");
    }
}
