package irsend.executor;

import java.io.IOException;
import java.util.*;

public class Executor {

    public static void main(String... args) throws IOException, InterruptedException {
        List<String> codes = Arrays.asList(args);
        Executor executor = new Executor();
        int exitCode = executor.execute("klarta_forste_2", codes);
        if (exitCode != 0) {
            System.err.println("Command executed with exit code: " + exitCode);
        }
    }

    public int execute(String device, Collection<String> codes) throws InterruptedException, IOException {
        List<String> commands = new ArrayList<>();
        commands.add("irsend");
        commands.add("SEND_ONCE");
        commands.add(device);
        commands.addAll(codes);
        Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec(commands.toArray(new String[0]), null);
        return process.waitFor();
    }

}
