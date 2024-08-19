package com.github.kayllon.douglas.command.argument.consumer;

import com.github.kayllon.douglas.command.argument.CommandArgument;

@FunctionalInterface
public interface CommandArgumentConsumer {

    void accept(final Integer index,
                final CommandArgument value);

}
