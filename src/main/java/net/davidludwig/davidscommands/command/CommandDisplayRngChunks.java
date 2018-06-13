package net.davidludwig.davidscommands.command;

import net.davidludwig.davidscommands.DavidsCommands;
import net.davidludwig.davidscommands.client.ClientProxy;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;

public class CommandDisplayRngChunks extends CommandBase {
    @Override
    public String getName() {
        return "display-rng-chunks";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return null;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        if (args.length == 0) {

        } else if (args.length == 1) {
            String arg = args[0].trim().toLowerCase();
            ClientProxy proxy = (ClientProxy) DavidsCommands.proxy;
            if (arg.equals("true"))
                proxy.getRenderer().rngChunkBorderEnabled = true;
            else if (arg.equals("false"))
                proxy.getRenderer().rngChunkBorderEnabled = false;
        }
    }
}
