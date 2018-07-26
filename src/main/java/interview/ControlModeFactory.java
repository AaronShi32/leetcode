package interview;

public class ControlModeFactory implements IFactory {
    @Override
    public IControlModeWorkflow create() {
        return new HPPadControlMode();
    }
}
