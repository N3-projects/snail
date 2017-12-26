package n3.snail.spring.machine;

import org.springframework.context.annotation.Bean;
import org.springframework.statemachine.action.Action;
import org.springframework.statemachine.config.EnumStateMachineConfigurerAdapter;
import org.springframework.statemachine.config.builders.StateMachineConfigurationConfigurer;
import org.springframework.statemachine.config.builders.StateMachineStateConfigurer;
import org.springframework.statemachine.config.builders.StateMachineTransitionConfigurer;
import org.springframework.statemachine.config.configurers.StateConfigurer;

import java.util.EnumSet;

/**
 * @author N3 on 2017/8/18.
 */
//@Configuration
//@EnableStateMachine
public class MachineConfig
        extends EnumStateMachineConfigurerAdapter<State, Event> {

    @Override
    public void configure(StateMachineStateConfigurer<State, Event> config)
            throws Exception {
        config
                .withStates()
                .initial(State.State1)
                .states(EnumSet.allOf(State.class)).history(null, StateConfigurer.History.SHALLOW);
    }

    @Override
    public void configure(StateMachineTransitionConfigurer<State, Event> transitions) throws Exception {
        transitions.withExternal().source(State.State1).target(State.State2).event(Event.Event1to2).action(action())
                .and().withExternal().source(State.State2).target(State.State1).event(Event.Event2to1);
    }

    @Override
    public void configure(StateMachineConfigurationConfigurer<State, Event> config) throws Exception {
        config.withConfiguration().machineId("machineId");
        super.configure(config);
    }

    @Bean
    public Action<State, Event> action() {
        return context -> {
            String id = context.getStateMachine().getId();
            System.out.println(id + ":1to2 action");
        };
    }
}
