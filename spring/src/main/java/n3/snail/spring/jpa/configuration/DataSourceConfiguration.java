package n3.snail.spring.jpa.configuration;

//import com.alibaba.druid.pool.DruidDataSource;
//import com.alibaba.druid.spring.boot.autoconfigure.DruidDataSourceBuilder;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

@Configuration
public class DataSourceConfiguration {

//    @Primary
//    @Bean(initMethod = "init")
//    @ConfigurationProperties("spring.datasource.druid")
//    public DataSource dataSourceOne(){
//        return DruidDataSourceBuilder.create().build();
//    }

//    @Bean
//    @ConfigurationProperties("spring.datasource.druid.two")
//    public DataSource dataSourceTwo(){
//        return DruidDataSourceBuilder.create().build();
//    }

}
