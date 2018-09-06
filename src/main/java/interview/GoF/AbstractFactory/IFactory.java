package interview.gof.abstractfactory;

import interview.gof.abstractfactory.workflow.Workflow;

public interface IFactory {

    Workflow createControlMode();

    Workflow createBlackList();

    Workflow createScreenOff();

    Workflow createScreenLock();
}
