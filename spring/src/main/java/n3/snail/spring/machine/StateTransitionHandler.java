package n3.snail.spring.machine;

import org.springframework.statemachine.StateContext;
import org.springframework.statemachine.StateMachine;
import org.springframework.statemachine.annotation.OnStateChanged;
import org.springframework.statemachine.annotation.OnTransition;
import org.springframework.statemachine.annotation.OnTransitionStart;
import org.springframework.statemachine.annotation.WithStateMachine;
import org.springframework.statemachine.config.EnableWithStateMachine;

/**
 * Hello world!
 *
 */
@EnableWithStateMachine
@WithStateMachine(id="id001")
public class StateTransitionHandler
{
    @OnTransition(source = "State2",target = "State1")
    public void toState1() {
        System.out.println("toState1");
    }

    @OnTransition(source = "State1",target = "State2")
    public void toState2(StateMachine<String, String> stateMachine, StateContext<String, String> stateContext) {
        System.out.println(stateMachine.getId() + ":transition to State2");
        System.out.println(stateContext);
    }

    @OnStateChanged
    public void onStateChanged() {
        System.out.println("onStateChanged");
    }

    @OnTransitionStart
    public void onTransitionStart() {

    }
}
