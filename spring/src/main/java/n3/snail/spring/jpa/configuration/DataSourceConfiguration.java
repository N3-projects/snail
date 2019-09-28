package n3.snail.spring.jpa.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import n3.snail.spring.boot.configuration.N3PropertySourcesPlaceholderConfigurer;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.util.Properties;

@Configuration
public class DataSourceConfiguration {

    @Primary
    @Bean
    @ConfigurationProperties("spring.datasource.druid.orgrimmar.master")
    public DruidDataSource orgrimmarMasterDataSource(){
        DruidDataSource master = DruidDataSourceBuilder.create().build();
        //获取连接时最大等待时间，单位毫秒。配置了maxWait之后，缺省启用公平锁（会影响性能），可手动设置非公平锁
        master.setUseUnfairLock(true);
        return master;
    }

    @Bean
    @ConfigurationProperties("spring.datasource.druid.orgrimmar.slave")
    public DruidDataSource orgrimmarSlaveDataSource(){
        DruidDataSource slave = DruidDataSourceBuilder.create().build();
        //获取连接时最大等待时间，单位毫秒。配置了maxWait之后，缺省启用公平锁（会影响性能），可手动设置非公平锁
        slave.setUseUnfairLock(true);
        //从库设置为read only
        slave.setDefaultReadOnly(true);
        return slave;
    }

    @Bean
    public N3PropertySourcesPlaceholderConfigurer druidPropertySourcesPlaceholderConfigurer() throws IOException {
        Properties n3Properties = new Properties();
        // 此处读取classpath下配置文件，实际也可以是配置中心的配置
        ClassPathResource resource = new ClassPathResource("druid.properties");
        n3Properties.load(resource.getInputStream());

        N3PropertySourcesPlaceholderConfigurer configurer = new N3PropertySourcesPlaceholderConfigurer();
        configurer.setExternalProperties(n3Properties);
        return configurer;
    }
}
