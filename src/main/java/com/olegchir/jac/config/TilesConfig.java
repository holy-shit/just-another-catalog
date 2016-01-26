package com.olegchir.jac.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;
import org.springframework.web.servlet.view.tiles3.TilesViewResolver;

/**
 * Created by olegchir on 26/01/16.
 */
@Configuration
public class TilesConfig {

    public static final String TILES_ROOT_LOCATION = "WEB-INF/tiles/tiles.xml";

    /**
     * Initialize tiles with a standard config file (lilst of definitions)
     *
     * @return tiles configurer
     */
    @Bean
    public TilesConfigurer tilesConfigurer() {
        final TilesConfigurer configurer = new TilesConfigurer();
        configurer.setDefinitions(new String[] { TILES_ROOT_LOCATION });
        configurer.setCheckRefresh(true);
        return configurer;
    }

    /**
     * Create URLViewResolver that is able to serve Tiles views
     *
     * @return tiles view resolver
     */
    @Bean
    public TilesViewResolver tilesViewResolver() {
        final TilesViewResolver resolver = new TilesViewResolver();
        resolver.setViewClass(TilesView.class);
        return resolver;
    }
}