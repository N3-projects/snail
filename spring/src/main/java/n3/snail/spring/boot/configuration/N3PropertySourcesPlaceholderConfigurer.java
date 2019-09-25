package n3.snail.spring.boot.configuration;

import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.util.Properties;

/**
 * 自定义额外配置解析，并合并到系统参数配置中
 */
public class N3PropertySourcesPlaceholderConfigurer extends PropertySourcesPlaceholderConfigurer {

    private Properties externalProperties;

    @Override
    protected Properties mergeProperties() throws IOException {
        Properties mergeProperties = super.mergeProperties();
        CollectionUtils.mergePropertiesIntoMap(externalProperties, mergeProperties);
        return mergeProperties;
    }

    public Properties getExternalProperties() {
        return externalProperties;
    }

    /**
     * 可支持其他自定义配置文件或配置中心的自定义配置<br>
     * 读取到外部数据以后，将其转化为Properties类型即可注入
     * @param externalProperties 额外自定义配置
     */
    public void setExternalProperties(Properties externalProperties) {
        this.externalProperties = externalProperties;
    }
}