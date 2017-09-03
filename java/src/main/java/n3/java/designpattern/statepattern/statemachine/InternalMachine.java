package n3.java.designpattern.statepattern.statemachine;

import n3.java.designpattern.statepattern.State;

/**
 * @author N3 on 2017/8/20.
 */
class InternalMachine implements StateMachine {

    private String name;
    private String id;
    private volatile State currState;

    InternalMachine(String name, String id, State currState) {
        this.name = name;
        this.id = id;
        this.currState = currState;
    }

    @Override
    public void sendEvent(StateEvent event) {
        sendEvent(event, null);
    }

    @Override
    public synchronized void sendEvent(StateEvent event, String extendedEvent) {
        if (!currState.getId().equals(event.from())) {
            throw new RuntimeException("illegal state event");
        }
        event.action(this, extendedEvent);
        internalChangeState(event.to());
    }

    private void internalChangeState(String to) {
        currState = new InternalState(to);
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public State getState() {
        return currState;
    }

    private class InternalState implements State {

        private final String id;

        private InternalState(String id) {
            this.id = id;
        }

        @Override
        public String getId() {
            return id;
        }
    }
}
