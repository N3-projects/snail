package n3.snail.java.spi.impl;

import n3.snail.java.spi.SPIServiceProvider;

/**
 * @author hzyemao
 * @version 1.0 , 2018/4/22
 */
public class N3SPIServiceProviderImpl implements SPIServiceProvider {
    @Override
    public void action() {
        System.out.println(this.getClass().getName() + " action()");
    }
}
