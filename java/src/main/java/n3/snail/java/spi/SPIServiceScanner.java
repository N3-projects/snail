package n3.snail.java.spi;

import java.util.ArrayList;
import java.util.List;
import java.util.ServiceLoader;

/**
 * SPI服务扫描器，检索classpath范围内的SPI服务提供者
 * @author hzyemao
 * @version 1.0 , 2018/4/22
 */
public class SPIServiceScanner {

    private SPIServiceScanner() {
    }

    /**
     * @return 返回空集合，说明没有找到满足条件的服务提供者
     */
    public static <T> List<T> findSPIService(Class<T> clz) {
        ServiceLoader<T> serviceLoader = ServiceLoader.load(clz);
        List<T> providerList = new ArrayList<>();
        for (T serviceProvider : serviceLoader) {
            providerList.add(serviceProvider);
        }
        return providerList;
    }
}
