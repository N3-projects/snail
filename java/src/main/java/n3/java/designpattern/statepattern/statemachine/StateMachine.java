package n3.java.designpattern.statepattern.statemachine;

import n3.java.designpattern.statepattern.State;

/**
 * @author N3 on 2017/8/19.
 */
public interface StateMachine {

    String getName();

    String getId();

    State getState();

    void sendEvent(StateEvent event);

    void sendEvent(StateEvent event, String extendedEvent);
}
