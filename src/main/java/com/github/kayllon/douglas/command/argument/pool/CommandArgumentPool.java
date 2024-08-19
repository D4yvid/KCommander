package com.github.kayllon.douglas.command.argument.pool;

import com.github.kayllon.douglas.command.argument.CommandArgument;
import com.github.kayllon.douglas.command.argument.CommandArgument.CommandArgumentImpl;

import com.github.kayllon.douglas.command.argument.consumer.CommandArgumentConsumer;

import com.github.kayllon.douglas.command.context.CommandContext;

public interface CommandArgumentPool {

    CommandContext context();

    boolean containsAt(final Integer index);

    CommandArgument getAt(final Integer index);

    void forEach(final CommandArgumentConsumer consumer);

    boolean empty();

    record CommandArgumentPoolImpl(CommandContext context) implements CommandArgumentPool {

        @Override
        public boolean containsAt(final Integer index) {
            return this.context()
                .getArguments()
                .containsKey(index);
        }

        @Override
        public CommandArgument getAt(final Integer index) {
            return this.context()
                .getArguments()
                .getOrDefault(index, new CommandArgumentImpl(index, null));
        }

        @Override
        public void forEach(final CommandArgumentConsumer consumer) {
            this.context()
                .getArguments()
                .forEach(consumer::accept);
        }

        @Override
        public boolean empty() {
            return this.context()
                .getArguments()
                .isEmpty();
        }

    }

}