package net.davidludwig.davidscommands.command;

import net.davidludwig.davidscommands.DavidsCommands;
import net.davidludwig.davidscommands.client.ClientProxy;
import net.davidludwig.davidscommands.util.ChunkUtils;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.gen.ChunkProviderServer;
import net.minecraftforge.client.IClientCommand;

public class CommandUnloadPriority extends CommandBase implements IClientCommand {
    @Override
    public boolean allowUsageWithoutPrefix(ICommandSender sender, String message) {
        return false;
    }

    @Override
    public String getName() {
        return "unload-priority";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return null;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        Entity entity = sender.getCommandSenderEntity();
        if (entity == null) {
            return;
        }
        if (args.length == 0) {
            ChunkPos pos = new ChunkPos(entity.getPosition());
            sender.sendMessage(new TextComponentString(String.format("Chunk [%d, %d] unload priority is: %d", pos.x, pos.z, ChunkUtils.unloadPriority(pos))));
        } else if (args.length == 1) {
            String arg = args[0].trim().toLowerCase();
            ClientProxy proxy = (ClientProxy) DavidsCommands.proxy;
            if (arg.equals("show"))
                proxy.getRenderer().chunkPriorityEnabled = true;
            else if (arg.equals("hide"))
                proxy.getRenderer().chunkPriorityEnabled = false;
        }
    }

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }
}
