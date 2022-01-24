import java.util.stream.Stream;

public class Kernel {
    public static final int GENERATE_COUNT = 3;

    public static void main(String[] args) {
        ProcessGenerator pGenerator = new ProcessGenerator();
        Stream<Process> readyProcesses = Stream.generate(() -> pGenerator.generateReadyProcess()).limit(GENERATE_COUNT);

        Processor processor = new Processor(); // CPU
        processor.allocate(readyProcesses);
        processor.run();
    }
}
