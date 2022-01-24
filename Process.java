public abstract class Process {
    String processType; // 식별자
    ProcessState processState = ProcessState.READY;
    ProcessControlBlock PCB = new ProcessControlBlock();
    int endWorkProgress;

    public String getProcessType() {
        return processType;
    }

    public int getEndWorkProgress() {
        return endWorkProgress;
    }

    public ProcessState getProcessState() {
        return processState;
    }

    public ProcessControlBlock getPCB() {
        return PCB;
    }

    public void changeProcessState(ProcessState processState) {
        this.processState = processState;
    }
}
