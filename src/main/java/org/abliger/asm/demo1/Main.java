package org.abliger.asm.demo1;

import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws Exception {
        Files.write(Paths.get("./target/classes/org/abliger/asm/demo1/BBB.class"), Gen.dump());
    }
}
