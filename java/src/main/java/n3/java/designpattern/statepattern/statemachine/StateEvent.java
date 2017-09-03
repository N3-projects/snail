package n3.java.designpattern.statepattern.statemachine;

/**
 * @author N3 on 2017/8/20.
 */
public interface StateEvent {

    String eventName();

    String from();

    String to();

    void action(StateMachine stateMachine, String extendedEvent);
}
