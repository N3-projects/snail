package n3.snail.java.spi;

import org.testng.annotations.Test;

import java.util.List;

/**
 * @author hzyemao
 * @version 1.0 , 2018/4/22
 */
public class TestSPIServiceProvider {

    @Test
    public void test() {
        List<SPIServiceProvider> spiServiceProviderList = SPIServiceScanner.findSPIService(SPIServiceProvider.class);
        spiServiceProviderList.forEach(SPIServiceProvider::action);
    }
}
