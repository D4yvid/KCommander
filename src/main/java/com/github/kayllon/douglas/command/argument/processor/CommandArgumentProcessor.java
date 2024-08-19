package com.github.kayllon.douglas.command.argument.processor;

import com.github.kayllon.douglas.command.argument.CommandArgument;

import com.github.kayllon.douglas.command.context.CommandContext;

import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static com.github.kayllon.douglas.command.argument.CommandArgument.CommandArgumentImpl;

public interface CommandArgumentProcessor {

    CommandContext context();

    void process(final String[] arguments);

    record CommandArgumentProcessorImpl(CommandContext context) implements CommandArgumentProcessor {

        @Override
        public void process(final String[] arguments) {
            this.context()
                .getArguments()
                .clear();

            this.context()
                .getArguments()
                .putAll(IntStream.range(0, arguments.length)
                    .mapToObj(index -> new CommandArgumentImpl(index, arguments[index]))
                    .collect(Collectors.toMap(CommandArgument::index, argument -> argument)));
        }

    }

}
