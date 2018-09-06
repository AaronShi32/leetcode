package interview.gof.abstractfactory;

import interview.gof.abstractfactory.workflow.PhoneControlModeWorkflow;
import interview.gof.abstractfactory.workflow.Workflow;

public class PhoneFactory implements IFactory {

    @Override
    public Workflow createControlMode() {
        return new PhoneControlModeWorkflow();
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
