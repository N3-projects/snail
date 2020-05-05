package n3.snail.distribution.schedule.tbschedule.configuration;

//import com.taobao.pamirs.schedule.strategy.TBScheduleManagerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * <bean id="scheduleManagerFactory" class="com.taobao.pamirs.schedule.strategy.TBScheduleManagerFactory"
 init-method="init">
 <property name="zkConfig">
 <map>
 <entry key="zkConnectString" value="${tbschedule.zk.address}" />
 <entry key="rootPath" value="${tbschedule.zk.root.path}" />
 <entry key="zkSessionTimeout" value="60000" />
 <entry key="userName" value="" />
 <entry key="password" value="" />
 <entry key="isCheckParentPath" value="true" />
 </map>
 </property>
 </bean>
 *
 * @author hzyemao
 * @version 1.0 , 2017/3/9
 */
@Configuration
@ComponentScan("n3.snail.distribution.schedule.tbschedule")
public class TBScheduleConfiguration {

//    @Bean(initMethod= "init")
//    public TBScheduleManagerFactory getTBScheduleManagerFactory() {
//        Map<String,String> zkConfig = new HashMap<>();
//        zkConfig.put("zkConnectString", "192.168.137.96");
//        zkConfig.put("rootPath", "/taobao-pamirs-schedule/lichking");
//        zkConfig.put("zkSessionTimeout", "60000");
//        zkConfig.put("userName", "lok_tar");
//        zkConfig.put("password", "ogar");
//        zkConfig.put("isCheckParentPath", "true");
//
//        TBScheduleManagerFactory tbScheduleManagerFactory = new TBScheduleManagerFactory();
//        tbScheduleManagerFactory.setZkConfig(zkConfig);
//        return tbScheduleManagerFactory;
//    }
}
