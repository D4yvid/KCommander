package com.github.kayllon.douglas.command;

import com.github.kayllon.douglas.builder.Builder;

import com.github.kayllon.douglas.command.context.CommandContext;

import lombok.Getter;

import java.util.Objects;

public interface Command {

    String name();

    String permission();

    String description();

    CommandContext context();

    record CommandImpl(String name,
                       String permission,
                       String description,
                       CommandContext context) implements Command {

    }

    interface CommandBuilder extends Builder<Command> {

        CommandBuilder name(final String name);

        CommandBuilder permission(final String permission);

        CommandBuilder description(final String description);

        CommandBuilder context(final CommandContext context);

    }

    @Getter
    class CommandBuilderImpl implements CommandBuilder {

        private String name;

        private String permission;

        private String description;

        private CommandContext context;

        @Override
        public CommandBuilder name(final String name) {
            this.name = name;
            return this;
        }

        @Override
        public CommandBuilder permission(final String permission) {
            this.permission = permission;
            return this;
        }

        @Override
        public CommandBuilder description(final String description) {
            this.description = description;
            return this;
        }

        @Override
        public CommandBuilder context(final CommandContext context) {
            this.context = context;
            return this;
        }

        @Override
        public Command build() {
            return new CommandImpl(
                Objects.requireNonNull(this.getName(), "Name cannot be null"),
                Objects.requireNonNull(this.getPermission(), "Permission cannot be null"),
                Objects.requireNonNull(this.getDescription(), "Description cannot be null"),
                Objects.requireNonNull(this.getContext(), "Context cannot be null"));
        }

    }

    static CommandBuilder builder() {
        return new CommandBuilderImpl();
    }

}
