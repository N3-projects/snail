package n3.snail.java.designpattern.statepattern.statemachine;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.EnumSet;
import java.util.HashSet;
import java.util.Set;

import static org.testng.Assert.*;

/**
 * @author N3 on 2017/8/19.
 */
public class TestStateMachine {

    @BeforeTest
    public void before() {
        //注册状态机
        Set<StateEvent> eventSet = new HashSet<>();
        EnumSet.allOf(SimpleStatusEvent.class).forEach(eventSet::add);
        StateMachineRegistry.register(MachineNameConstant.SIMPLE_STATUS, eventSet);
    }

    @Test
    public void testApi() {
        //构造状态机
        StateMachine simpleStateMachine = StateMachineFactory
                .getStateMachine(MachineNameConstant.SIMPLE_STATUS, SimpleStatusEnum.INIT.name());
        assertNotNull(simpleStateMachine);
        //发送状态事件
        simpleStateMachine.sendEvent(SimpleStatusEvent.EXECUTE);
    }
}
