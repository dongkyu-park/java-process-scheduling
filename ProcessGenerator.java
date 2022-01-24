import java.util.HashSet;
import java.util.Set;

public class ProcessGenerator {
    public static final Set<Character> processNameSet = new HashSet<>();

    public Process generateReadyProcess() {
        char typeName = selectProcessType();

        if (typeName == 'A') {
            return new ProcessA();
        }
        if (typeName == 'B') {
            return new ProcessB();
        }
        if (typeName == 'C') {
            return new ProcessC();
        }
        if (typeName == 'D') {
            return new ProcessD();
        }
        return new ProcessE();
    }

    public char selectProcessType() {
        char typeName = (char) ((int)(Math.random() * 5) + 65);

        if (validateProcessType(typeName)) {
            return selectProcessType();
        }
        processNameSet.add(typeName);

        return typeName;
    }

    private boolean validateProcessType(char typeName) {
        return processNameSet.contains(typeName);
    }
}
