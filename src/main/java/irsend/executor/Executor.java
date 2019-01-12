package irsend.executor;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Executor {

    public static void main(String... args) throws IOException, InterruptedException {
        List<String> commands = new ArrayList<>();
        commands.add("irsend");
        commands.add("SEND_ONCE");
        commands.add("klarta_forste_2");
        Collections.addAll(commands, args);
        Runtime runtime = Runtime.getRuntime();
        System.out.print("Execute command:");
        for (String command : commands) {
            System.out.print(" " + command);
        }
        System.out.println();
        Process process = runtime.exec(commands.toArray(new String[args.length + 2]), null);
        int exitCode = process.waitFor();
        System.out.println("Command executed with exit code: " + exitCode);
    }

}
