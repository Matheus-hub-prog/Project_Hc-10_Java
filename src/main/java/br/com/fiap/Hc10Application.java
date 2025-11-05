package br.com.fiap;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class Hc10Application {
    public static void main(String... args) {
        System.out.println("🚀 Iniciando o sistema HC+10...");
        Quarkus.run(args);
    }
}
