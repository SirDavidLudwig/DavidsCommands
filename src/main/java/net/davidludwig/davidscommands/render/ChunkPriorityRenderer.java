package net.davidludwig.davidscommands.render;

import net.davidludwig.davidscommands.client.ClientRenderer;
import net.davidludwig.davidscommands.util.ChunkUtils;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MathHelper;

public class ChunkPriorityRenderer extends Renderer {

    public void render(ClientRenderer renderer, float partialTicks) {
        EntityPlayer player = getMinecraft().player;
        int renderDistance = getMinecraft().gameSettings.renderDistanceChunks;
        int x = MathHelper.floor(player.posX / 16.0D);
        int z = MathHelper.floor(player.posZ / 16.0D);

        for (int i = -renderDistance; i <= renderDistance; i++)
        {
            for (int j = -renderDistance; j <= renderDistance; j++)
            {
                ChunkPos chunkPos = new ChunkPos(i + x, j + z);
                BlockPos pos = new ChunkPos(i + x, j + z).getBlock(8, player.getPosition().getY() + 1, 8);
                renderer.drawText(Integer.toString(ChunkUtils.unloadPriority(chunkPos)), pos.getX(), pos.getY(), pos.getZ(), partialTicks, 0xff0000);
            }
        }
        renderer.drawText("Testing", 0, 57, 0, partialTicks, 0x00ff00);
    }
}
