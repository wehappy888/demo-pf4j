package org.wayne.demo.pf4j.service;

import org.pf4j.Extension;
import org.wayne.demo.pf4j.api.Greeting;

/**
 * @author wayne
 * @version 1.0
 * @since 2022/4/13 16:36
 */
@Extension
public class WelcomeGreeting implements Greeting {

    @Override
    public String getGreeting() {
        return "Welcome";
    }
}
