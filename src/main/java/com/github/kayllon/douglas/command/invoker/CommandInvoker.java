package com.github.kayllon.douglas.command.invoker;

import cn.nukkit.Player;

import cn.nukkit.command.CommandSender;
import cn.nukkit.command.ConsoleCommandSender;

public interface CommandInvoker {

    Player asPlayer();

    ConsoleCommandSender asConsole();

    CommandSender sender();

    boolean hasPermission(final String permission);

    record CommandInvokerImpl(CommandSender sender) implements CommandInvoker {

        @Override
        public Player asPlayer() {
            return this.sender() instanceof final Player player ? player : null;
        }

        @Override
        public ConsoleCommandSender asConsole() {
            return this.sender() instanceof final ConsoleCommandSender console ? console : null;
        }

        @Override
        public boolean hasPermission(final String permission) {
            return this.sender()
                .hasPermission(permission);
        }

    }

}
