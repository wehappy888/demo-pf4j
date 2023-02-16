package org.wayne.demo.pf4j.plugin;

import org.pf4j.Plugin;
import org.pf4j.PluginWrapper;

/**
 * @author wayne
 * @version 1.0
 * @since 2022/4/13 16:35
 */
public class WelcomePlugin extends Plugin {

    public WelcomePlugin(PluginWrapper wrapper) {
        super(wrapper);
    }

    @Override
    public void start() {
        System.out.println("WelcomePlugin.start()");
    }

    @Override
    public void stop() {
        System.out.println("WelcomePlugin.stop()");
    }

    @Override
    public void delete() {
        System.out.println("WelcomePlugin.delete()");
    }
}
