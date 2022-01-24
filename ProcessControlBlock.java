public class ProcessControlBlock {
    int workProgress = 0;

    public int getWorkProgress() {
        return workProgress;
    }

    public void goWorkProgress() {
        this.workProgress++;
    }
}
