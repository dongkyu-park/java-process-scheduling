public abstract class Process {
    String processType; // 식별자
    ProcessState processState = ProcessState.READY;
    ProcessControlBlock PCB = new ProcessControlBlock();
    int totalWorkProgress;

    public String getProcessType() {
        return processType;
    }

    public int getTotalWorkProgress() {
        return totalWorkProgress;
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
