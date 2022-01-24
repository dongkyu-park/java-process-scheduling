public class ProcessControlBlock {
    int completeWorkProgress = 0;

    public int getCompleteWorkProgress() {
        return completeWorkProgress;
    }

    public void goWorkProgress() {
        this.completeWorkProgress++;
    }
}
