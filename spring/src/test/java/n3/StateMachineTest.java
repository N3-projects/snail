package n3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.config.StateMachineBuilder;
import org.springframework.statemachine.config.configurers.StateConfigurer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

import java.util.EnumSet;

/**
 * @author N3 on 2017/8/18.
 */
@ContextConfiguration(locations = { "classpath:n3/applicationContext-test.xml" })
public class StateMachineTest extends AbstractTestNGSpringContextTests {

//    @Autowired
//    StateMachine<IState, IEvent> stateMachine;

    @Autowired
    ApplicationContext context;

    @SuppressWarnings("unchecked")
    @Test
    public void helloWorld() throws Exception{
        StateMachine machine = getMachineFromBuilder("id001");
//        machine.start();
        System.out.println(machine.getId());
        System.out.println(machine.getState().getId());
        System.out.println(machine.getInitialState());
        machine.getExtendedState().getVariables().put("param1", "value1");
        machine.sendEvent(Event.Event1to2);
        System.out.println(machine.getState().getId());
        machine.sendEvent(Event.Event2to1);
        System.out.println(machine.getState().getId());
    }

    @SuppressWarnings("unchecked")
    @Test
    public void testIllegalTransition() throws Exception{
        StateMachine machine = getMachineFromBuilder("id002");
        System.out.println(machine.getId()+ "|" + machine.getState().getId());
        machine.getExtendedState().getVariables().put("param002", "value002");
        System.out.println("******* transition 2 to 1 ******");
        machine.sendEvent(Event.Event2to1);
        System.out.println(machine.getState().getId());
    }

    private StateMachine getMachineFromBuilder(String machineId) throws Exception{
        StateMachineBuilder.Builder<State, Event> builder = StateMachineBuilder.builder();
        builder.configureStates()
                .withStates()
                .initial(State.State1)
                .states(EnumSet.allOf(State.class));
        builder.configureTransitions()
                .withExternal()
                .source(State.State1).target(State.State2)
                .event(Event.Event1to2)
                .and()
                .withExternal()
                .source(State.State2).target(State.State1)
                .event(Event.Event2to1).action(context -> {
            String id = context.getStateMachine().getId();
            System.out.println(id + ":1to2 action");
        });
        builder.configureConfiguration().withConfiguration()
                .machineId(machineId)
                .beanFactory(context)
                .autoStartup(true);

        return builder.build();
    }
}
