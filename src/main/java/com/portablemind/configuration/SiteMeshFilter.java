package com.portablemind.configuration;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;

/**
 * Created by Mateusz Brycki on 22/08/2015.
 */

public class SiteMeshFilter extends ConfigurableSiteMeshFilter {
    @Override
    protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
        builder.addDecoratorPath("/admin/*", "/WEB-INF/views/decorators/adminDecorator.jsp")
               .addDecoratorPath("/*", "/WEB-INF/views/decorators/boardDecorator.jsp");
    }
}