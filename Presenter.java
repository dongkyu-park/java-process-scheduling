import java.util.Queue;

public class Presenter {
    public StringBuilder convertProcessesToMessage(Queue<Process> toDoList, Queue<Process> completeList) {
        StringBuilder sb = new StringBuilder();

        toDoList.stream().forEach((i) -> sb.append(i.getProcessType() + "(" + i.getProcessState() + "), "
        + i.getPCB().getWorkProgress() + " / " + i.getEndWorkProgress() + "sec\n"));
        completeList.stream().forEach((i) -> sb.append(i.getProcessType() + "(" + i.getProcessState() + "), "
                + i.getPCB().getWorkProgress() + " / " + i.getEndWorkProgress() + "sec\n"));
        sb.append("...\n");

        return sb;
    }

    public StringBuilder convertProcessToMessage(Process workingProcess) {
        StringBuilder sb = new StringBuilder();
        sb.append(workingProcess.getProcessType() + "(" + workingProcess.getProcessState() + "), "
                + workingProcess.getPCB().getWorkProgress() + " / " + workingProcess.getEndWorkProgress()
                + "sec\n");

        return sb;
    }
}
