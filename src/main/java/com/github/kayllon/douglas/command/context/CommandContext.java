package com.github.kayllon.douglas.command.context;

import cn.nukkit.command.Command;
import cn.nukkit.command.CommandExecutor;
import cn.nukkit.command.CommandSender;

import com.github.kayllon.douglas.command.argument.CommandArgument;

import com.github.kayllon.douglas.command.argument.pool.CommandArgumentPool;
import com.github.kayllon.douglas.command.argument.pool.CommandArgumentPool.CommandArgumentPoolImpl;

import com.github.kayllon.douglas.command.argument.processor.CommandArgumentProcessor;
import com.github.kayllon.douglas.command.argument.processor.CommandArgumentProcessor.CommandArgumentProcessorImpl;


import com.github.kayllon.douglas.command.invoker.CommandInvoker;
import com.github.kayllon.douglas.command.invoker.CommandInvoker.CommandInvokerImpl;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Getter
public abstract class CommandContext implements CommandExecutor {

    private final Map<Integer, CommandArgument> arguments;

    private final CommandArgumentProcessor argumentProcessor;

    private final CommandArgumentPool argumentPool;

    private CommandInvoker invoker;

    public CommandContext() {
        this.arguments = new HashMap<>();
        this.argumentProcessor = new CommandArgumentProcessorImpl(this);
        this.argumentPool = new CommandArgumentPoolImpl(this);
    }

    @Override
    public boolean onCommand(final CommandSender sender,
                             final Command command,
                             final String label,
                             final String[] arguments) {
        if (Objects.isNull(this.getInvoker())) {
            this.invoker = new CommandInvokerImpl(sender);
        }

        this.getArgumentProcessor()
            .process(arguments);

        return this.onContext(this.getInvoker(), this.getArgumentPool());
    }

    public abstract boolean onContext(final CommandInvoker invoker,
                                      final CommandArgumentPool argumentPool);

}
