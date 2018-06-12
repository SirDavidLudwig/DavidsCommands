package net.davidludwig.davidscommands.command.server;

import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;

public class CommandInstantBlockFalling extends CommandBase {

    @Override
    public int getRequiredPermissionLevel() {
        return 4;
    }

    @Override
    public String getName() {
        return "instant-block-falling";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "/instant-block-falling true/false";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        TextComponentString tcs;
        if (args.length == 1) {
            BlockFalling.fallInstantly = args[0].trim().toLowerCase().equals("true");
            tcs = new TextComponentString(String.format("Instant block falling changed to %b", BlockFalling.fallInstantly));
            tcs.getStyle().setItalic(true);
            tcs.getStyle().setColor(TextFormatting.GRAY);
            server.getPlayerList().sendMessage(tcs);
        } else {
            tcs = new TextComponentString(String.format("Instant block falling: %b", BlockFalling.fallInstantly));
            sender.sendMessage(tcs);
        }
    }
}
