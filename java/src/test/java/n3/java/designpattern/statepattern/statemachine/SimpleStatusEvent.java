package n3.java.designpattern.statepattern.statemachine;

/**
 * @author N3 on 2017/8/20.
 */
public enum SimpleStatusEvent implements StateEvent {

    EXECUTE {
        @Override
        public String from() {
            return SimpleStatusEnum.INIT.name();
        }

        @Override
        public String to() {
            return SimpleStatusEnum.PROCESSING.name();
        }

        @Override
        public void action(StateMachine stateMachine, String extendedEvent) {
            System.out.println(stateMachine.getId() + " changed from " + from() + " to " + to());
        }
    },

    EXECUTE_SUCCESS {
        @Override
        public String from() {
            return null;
        }

        @Override
        public String to() {
            return null;
        }

        @Override
        public void action(StateMachine stateMachine, String extendedEvent) {

        }
    },

    EXECUTE_FAIL {
        @Override
        public String from() {
            return null;
        }

        @Override
        public String to() {
            return null;
        }

        @Override
        public void action(StateMachine stateMachine, String extendedEvent) {

        }
    };

    @Override
    public String eventName() {
        return name();
    }
}
