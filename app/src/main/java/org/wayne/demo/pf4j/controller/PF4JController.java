package org.wayne.demo.pf4j.controller;

import cn.hutool.core.collection.CollectionUtil;
import lombok.SneakyThrows;
import org.pf4j.PluginDescriptor;
import org.pf4j.PluginManager;
import org.pf4j.PluginWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.wayne.demo.pf4j.api.Greeting;
import org.wayne.demo.pf4j.response.ResultBody;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author wangEn
 * @version 1.0.0
 * @since 2023/2/16 14:12
 */
@RestController
@RequestMapping("/pf4j")
public class PF4JController {

    @Autowired
    private PluginManager pluginManager;

    @SneakyThrows
    @GetMapping("/callplugin1/greeting")
    //@ApiOperation("调用插件1中的greeting方法")
    public ResultBody callplugin1Greeting() {
        List<PluginWrapper> startedPlugins = pluginManager.getStartedPlugins();
        if (CollectionUtil.isEmpty(startedPlugins)) {
            return ResultBody.failed("没有可使用的插件");
        }
        List<PluginDescriptor> collect = startedPlugins.stream().map(PluginWrapper::getDescriptor).filter(t -> "welcome-plugin".equals(t.getPluginId())).collect(Collectors.toList());
        if (CollectionUtil.isEmpty(collect)) {
            return ResultBody.failed("插件：welcome-plugin 没有启动");
        }
        PluginDescriptor pluginDescriptor = collect.get(0);
        List<Greeting> extensions = pluginManager.getExtensions(Greeting.class, pluginDescriptor.getPluginId());
        return ResultBody.success(extensions.get(0).getGreeting());
    }

}
