package interview.gof.abstractfactory;

import interview.gof.abstractfactory.workflow.PadControlModeWorkflow;
import interview.gof.abstractfactory.workflow.Workflow;

public class PadFactory implements IFactory {

    @Override
    public Workflow createControlMode() {
        return new PadControlModeWorkflow();
    }

    @Override
    public Workflow createBlackList() {
        return null;
    }

    @Override
    public Workflow createScreenOff() {
        return null;
    }

    @Override
    public Workflow createScreenLock() {
        return null;
    }
}
