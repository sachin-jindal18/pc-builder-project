package com.example.demo.cli;

import com.example.demo.core.PC;
import com.example.demo.core.systems.KVM;
import com.example.demo.core.systems.Tower;
import org.springframework.shell.standard.ShellComponent;
import org.springframework.shell.standard.ShellMethod;

@ShellComponent
public class PCBuilderCli {

    public PCBuilderCli() {
    }

    @ShellMethod("Please help about this project")
    public String build() {
        var pcBuilder = new PC.Builder().withKVM(new KVM()).withTower(new Tower());
        return "Welcome to PC Builder";
    }
}
