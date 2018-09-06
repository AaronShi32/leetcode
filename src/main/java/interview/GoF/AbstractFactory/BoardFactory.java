package interview.gof.abstractfactory;

import interview.gof.abstractfactory.workflow.BoardControlModeWorkflow;
import interview.gof.abstractfactory.workflow.Workflow;

public class BoardFactory implements IFactory {

    @Override
    public Workflow createControlMode() {
        return new BoardControlModeWorkflow();
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
