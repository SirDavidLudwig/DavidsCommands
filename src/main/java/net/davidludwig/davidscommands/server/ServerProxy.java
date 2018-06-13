package net.davidludwig.davidscommands.server;

import net.davidludwig.davidscommands.CommonProxy;
import net.davidludwig.davidscommands.command.server.*;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandHandler;
import net.minecraft.command.ICommand;
import net.minecraft.server.MinecraftServer;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

public class ServerProxy extends CommonProxy {

    private MinecraftServer server;

    public ICommand[] commands = {
            new CommandCountEntities(),
            new CommandInstantBlockFalling(),
            new CommandRngReset()
    };

    public void registerCommands() {
        for (ICommand command : commands) {
            registerCommand(command);
        }
    }

    public void registerCommand(ICommand command) {
        CommandHandler handler = (CommandHandler) server.getCommandManager();
        handler.registerCommand(command);
    }

    @EventHandler
    public void onServerStart(FMLServerStartingEvent event) {
        server = event.getServer();
        registerCommands();
    }
}
