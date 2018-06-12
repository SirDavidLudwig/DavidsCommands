package net.davidludwig.davidscommands.command.server;

import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;

public class CommandCountEntities extends CommandBase {

    @Override
    public int getRequiredPermissionLevel() {
        return 0;
    }

    @Override
    public String getName() {
        return "count-entities";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return null;
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        String dimensions[] = {"Nether", "Overworld", "The End"};
        if (args.length == 0) {
            int totalEntities = 0;
            int totalTileEntities = 0;
            String result = "";
            for (int i = -1; i <= 1; i++) {
                int entities = countEntitiesWithinRadius(server, i, null, -1, false);
                int tileEntities = countEntitiesWithinRadius(server, i, null, -1, true);
                totalEntities += entities;
                totalTileEntities += tileEntities;
                result += dimensions[i+1] + ' ';
                for (int j = dimensions[i+1].length(); j < 53; j++)
                    result += '-';
                result += '\n';
                result += String.format("    Entities:      %d\n", entities);
                result += String.format("    Tile Entities: %d\n\n", tileEntities);
            }
            result = String.format("Total Entities:      %d\nTotal Tile Entities: %d\n%s", totalEntities, totalTileEntities, result);
            sender.sendMessage(new TextComponentString(result.trim()));
        } else {

        }
    }

    public int countEntitiesWithinRadius(MinecraftServer server, int dimension, BlockPos start, int radius, boolean tileEntities) {
        int total = 0;
        int radiusSq = radius == -1 ? radius : radius * radius;
        if (tileEntities) {
            for (TileEntity tileEntity : server.getWorld(dimension).loadedTileEntityList) {
                if (radius == -1 || tileEntity.getPos().distanceSq(start) <= radiusSq) {
                    total++;
                }
            }
        } else {
            for (Entity entity : server.getWorld(dimension).loadedEntityList) {
                if (radius == -1 || entity.getDistanceSq(start) <= radiusSq) {
                    total++;
                }
            }
        }
        return total;
    }
}
