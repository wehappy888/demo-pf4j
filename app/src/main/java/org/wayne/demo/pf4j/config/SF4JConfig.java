package org.wayne.demo.pf4j.config;

import org.pf4j.DefaultPluginManager;
import org.pf4j.PluginManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author wangEn
 * @version 1.0.0
 * @since 2023/2/16 14:09
 */
@Configuration
public class SF4JConfig {

    @Bean
    public PluginManager pluginManager() {
        PluginManager pluginManager = new DefaultPluginManager();
        pluginManager.loadPlugins();
        pluginManager.startPlugins();
        return pluginManager;
    }
}
