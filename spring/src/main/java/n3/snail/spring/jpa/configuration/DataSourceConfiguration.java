package n3.snail.spring.jpa.configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DataSourceConfiguration {

    @Primary
    @Bean
    @ConfigurationProperties("spring.datasource.druid.app.main")
    public DruidDataSource appMainDataSource(){
        DruidDataSource build = DruidDataSourceBuilder.create().build();
        //获取连接时最大等待时间，单位毫秒。配置了maxWait之后，缺省启用公平锁（会影响性能），可手动设置非公平锁
        build.setUseUnfairLock(true);
        return build;
    }

}
