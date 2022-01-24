import java.util.LinkedList;
import java.util.Queue;
import java.util.stream.Stream;

public class Processor {
    public static final int RESOURCE = 8;

    Queue<Process> toDoList = new LinkedList<>();
    Queue<Process> completeList = new LinkedList<>();
    Presenter presenter = new Presenter();
    View viewer = new View();

    public void allocate(Stream<Process> processes) {
        processes.limit(RESOURCE).forEach(toDoList::add);
        toDoList.stream().filter(process -> process.getProcessState() == ProcessState.READY)
                .forEach(i -> i.changeProcessState(ProcessState.WAITING));
    }

    public void run() {
        while (!toDoList.isEmpty()) {
            doWork();
        }
    }

    public void doWork() {
        Process workingProcess = chooseWork();

        workingProcess.changeProcessState(ProcessState.RUNNING);
        workingProcess.getPCB().goWorkProgress();

        addProcessToList(workingProcess);
    }

    private Process chooseWork() {
        return toDoList.poll();
    }

    private void addProcessToList(Process workingProcess) {
        if (isCompleteWork(workingProcess)) {
            workingProcess.changeProcessState(ProcessState.TERMINATED);
            completeList.add(workingProcess);
            printProcesses();
            return;
        }

        printRunningProcess(workingProcess);

        workingProcess.changeProcessState(ProcessState.WAITING);
        printProcesses();

        toDoList.add(workingProcess);
    }

    private boolean isCompleteWork(Process workingProcess) {
        return workingProcess.getPCB().getCompleteWorkProgress() == workingProcess.getTotalWorkProgress();
    }

    private void printProcesses() {
        viewer.printMessage(presenter.convertProcessesToMessage(toDoList, completeList));
    }

    private void printRunningProcess(Process workingProcess) {
        viewer.printMessage(presenter.convertProcessToMessage(workingProcess));
    }
}
