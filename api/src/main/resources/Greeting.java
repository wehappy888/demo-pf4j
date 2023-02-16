package org.wayne.demo.pf4j.api;

import org.pf4j.ExtensionPoint;

/**
 * 声明扩展点
 *
 * @author wayne
 * @version 1.0
 * @since 2022/4/13 16:30
 */
public interface Greeting extends ExtensionPoint {

    String getGreeting();

}
