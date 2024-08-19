package com.github.kayllon.douglas.command.service;

import cn.nukkit.command.PluginCommand;

import cn.nukkit.plugin.Plugin;

import com.github.kayllon.douglas.command.exception.CommandException;

import com.github.kayllon.douglas.builder.Builder;

import com.github.kayllon.douglas.command.Command;

import lombok.Getter;

import java.text.MessageFormat;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public interface CommandService {

    Plugin plugin();

    Map<String, Command> commands();

    void register();

    record CommandServiceImpl(
        Plugin plugin,
        Map<String, Command> commands
    ) implements CommandService {

        @Override
        public void register() {
            this.commands().forEach((key, value) -> {
                final var command = new PluginCommand<>(value.name(), this.plugin());

                command.setPermission(value.permission());
                command.setDescription(value.description());

                command.setExecutor(value.context());

                command.getCommandParameters()
                    .clear();

                if (!(this.plugin().getServer().getCommandMap().register(this.plugin().getName(), command))) {
                    throw new CommandException(MessageFormat.format("Failed to register command named {0}", value.name()));
                }

                this.plugin()
                    .getLogger()
                    .info(MessageFormat.format("Registered command named {0}", value.name()));
            });
        }

    }

    interface CommandServiceBuilder extends Builder<CommandService> {

        CommandServiceBuilder plugin(final Plugin plugin);

        CommandServiceBuilder command(final Command command);

    }

    @Getter
    class CommandServiceBuilderImpl implements CommandServiceBuilder {

        private Plugin plugin;

        private final Map<String, Command> commands = new HashMap<>();

        @Override
        public CommandServiceBuilder plugin(final Plugin plugin) {
            this.plugin = plugin;
            return this;
        }

        @Override
        public CommandServiceBuilder command(final Command command) {
            this.getCommands()
                .put(command.name(), command);
            return this;
        }

        @Override
        public CommandService build() {
            return new CommandServiceImpl(
                Objects.requireNonNull(this.getPlugin(), "Plugin cannot be null"),
                this.getCommands()
            );
        }

    }

    static CommandServiceBuilder builder() {
        return new CommandServiceBuilderImpl();
    }

}
