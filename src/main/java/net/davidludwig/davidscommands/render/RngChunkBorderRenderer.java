package net.davidludwig.davidscommands.render;

import net.davidludwig.davidscommands.client.ClientRenderer;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.player.EntityPlayer;

public class RngChunkBorderRenderer extends Renderer {

    public void render(ClientRenderer renderer, float partialTicks) {
        EntityPlayer entityplayer = getMinecraft().player;
        Tessellator tessellator = Tessellator.getInstance();
        BufferBuilder bufferbuilder = tessellator.getBuffer();
        double d0 = entityplayer.lastTickPosX + (entityplayer.posX - entityplayer.lastTickPosX) * (double)partialTicks;
        double d1 = entityplayer.lastTickPosY + (entityplayer.posY - entityplayer.lastTickPosY) * (double)partialTicks;
        double d2 = entityplayer.lastTickPosZ + (entityplayer.posZ - entityplayer.lastTickPosZ) * (double)partialTicks;
        double d3 = 0.0D - d1;
        double d4 = 256.0D - d1;
        GlStateManager.disableTexture2D();
        GlStateManager.disableBlend();
        int chunkX = (entityplayer.chunkCoordX < 0 ? entityplayer.chunkCoordX - 79 : entityplayer.chunkCoordX) / 80;
        int chunkZ = (entityplayer.chunkCoordZ < 0 ? entityplayer.chunkCoordZ - 79 : entityplayer.chunkCoordZ) / 80;
        double d5 = (double)((chunkX * 80) << 4) - d0;
        double d6 = (double)((chunkZ * 80) << 4) - d2;
        GlStateManager.glLineWidth(1.5F);
        bufferbuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);

        float color[] = {1.0F, 0, 1.0F};

//        for (int k = 2; k < 16*80; k += 2)
//        {
//            if (k % 16 == 0)
//                continue;
//            bufferbuilder.pos(d5 + (double)k, d3, d6).color(color[0], color[1], color[2], 0.0F).endVertex();
//            bufferbuilder.pos(d5 + (double)k, d3, d6).color(color[0], color[1], color[2], 1.0F).endVertex();
//            bufferbuilder.pos(d5 + (double)k, d4, d6).color(color[0], color[1], color[2], 1.0F).endVertex();
//            bufferbuilder.pos(d5 + (double)k, d4, d6).color(color[0], color[1], color[2], 0.0F).endVertex();
//            bufferbuilder.pos(d5 + (double)k, d3, d6 + 80*16.0D).color(color[0], color[1], color[2], 0.0F).endVertex();
//            bufferbuilder.pos(d5 + (double)k, d3, d6 + 80*16.0D).color(color[0], color[1], color[2], 1.0F).endVertex();
//            bufferbuilder.pos(d5 + (double)k, d4, d6 + 80*16.0D).color(color[0], color[1], color[2], 1.0F).endVertex();
//            bufferbuilder.pos(d5 + (double)k, d4, d6 + 80*16.0D).color(color[0], color[1], color[2], 0.0F).endVertex();
//        }
//
//        for (int l = 2; l < 16*80; l += 2)
//        {
//            if (l % 16 == 0)
//                continue;
//            bufferbuilder.pos(d5, d3, d6 + (double)l).color(color[0], color[1], color[2], 0.0F).endVertex();
//            bufferbuilder.pos(d5, d3, d6 + (double)l).color(color[0], color[1], color[2], 1.0F).endVertex();
//            bufferbuilder.pos(d5, d4, d6 + (double)l).color(color[0], color[1], color[2], 1.0F).endVertex();
//            bufferbuilder.pos(d5, d4, d6 + (double)l).color(color[0], color[1], color[2], 0.0F).endVertex();
//            bufferbuilder.pos(d5 + 80*16.0D, d3, d6 + (double)l).color(color[0], color[1], color[2], 0.0F).endVertex();
//            bufferbuilder.pos(d5 + 80*16.0D, d3, d6 + (double)l).color(color[0], color[1], color[2], 1.0F).endVertex();
//            bufferbuilder.pos(d5 + 80*16.0D, d4, d6 + (double)l).color(color[0], color[1], color[2], 1.0F).endVertex();
//            bufferbuilder.pos(d5 + 80*16.0D, d4, d6 + (double)l).color(color[0], color[1], color[2], 0.0F).endVertex();
//        }
//
//        for (int i1 = 0; i1 <= 256; i1 += 2)
//        {
//            double d7 = (double)i1 - d1;
//            bufferbuilder.pos(d5, d7, d6).color(1.0F, 1.0F, 0.0F, 0.0F).endVertex();
//            bufferbuilder.pos(d5, d7, d6).color(1.0F, 1.0F, 0.0F, 1.0F).endVertex();
//            bufferbuilder.pos(d5, d7, d6 + 16.0D).color(1.0F, 1.0F, 0.0F, 1.0F).endVertex();
//            bufferbuilder.pos(d5 + 16.0D, d7, d6 + 16.0D).color(1.0F, 1.0F, 0.0F, 1.0F).endVertex();
//            bufferbuilder.pos(d5 + 16.0D, d7, d6).color(1.0F, 1.0F, 0.0F, 1.0F).endVertex();
//            bufferbuilder.pos(d5, d7, d6).color(1.0F, 1.0F, 0.0F, 1.0F).endVertex();
//            bufferbuilder.pos(d5, d7, d6).color(1.0F, 1.0F, 0.0F, 0.0F).endVertex();
//        }

        tessellator.draw();
        GlStateManager.glLineWidth(2.0F);
        bufferbuilder.begin(3, DefaultVertexFormats.POSITION_COLOR);

        color = new float[]{0.6F, 0.0F, 1.0F};

        for (int k = 0; k <= 80*16; k += 16)
        {
            bufferbuilder.pos(d5 + (double)k, d3, d6).color(color[0], color[1], color[2], 0.0F).endVertex();
            bufferbuilder.pos(d5 + (double)k, d3, d6).color(color[0], color[1], color[2], 1.0F).endVertex();
            bufferbuilder.pos(d5 + (double)k, d4, d6).color(color[0], color[1], color[2], 1.0F).endVertex();
            bufferbuilder.pos(d5 + (double)k, d4, d6).color(color[0], color[1], color[2], 0.0F).endVertex();
            bufferbuilder.pos(d5 + (double)k, d3, d6 + 80*16.0D).color(color[0], color[1], color[2], 0.0F).endVertex();
            bufferbuilder.pos(d5 + (double)k, d3, d6 + 80*16.0D).color(color[0], color[1], color[2], 1.0F).endVertex();
            bufferbuilder.pos(d5 + (double)k, d4, d6 + 80*16.0D).color(color[0], color[1], color[2], 1.0F).endVertex();
            bufferbuilder.pos(d5 + (double)k, d4, d6 + 80*16.0D).color(color[0], color[1], color[2], 0.0F).endVertex();
        }

        for (int l = 0; l <= 80*16; l += 16)
        {
            bufferbuilder.pos(d5, d3, d6 + (double)l).color(color[0], color[1], color[2], 0.0F).endVertex();
            bufferbuilder.pos(d5, d3, d6 + (double)l).color(color[0], color[1], color[2], 1.0F).endVertex();
            bufferbuilder.pos(d5, d4, d6 + (double)l).color(color[0], color[1], color[2], 1.0F).endVertex();
            bufferbuilder.pos(d5, d4, d6 + (double)l).color(color[0], color[1], color[2], 0.0F).endVertex();
            bufferbuilder.pos(d5 + 80*16.0D, d3, d6 + (double)l).color(color[0], color[1], color[2], 0.0F).endVertex();
            bufferbuilder.pos(d5 + 80*16.0D, d3, d6 + (double)l).color(color[0], color[1], color[2], 1.0F).endVertex();
            bufferbuilder.pos(d5 + 80*16.0D, d4, d6 + (double)l).color(color[0], color[1], color[2], 1.0F).endVertex();
            bufferbuilder.pos(d5 + 80*16.0D, d4, d6 + (double)l).color(color[0], color[1], color[2], 0.0F).endVertex();
        }

        tessellator.draw();
        GlStateManager.glLineWidth(1.0F);
        GlStateManager.enableBlend();
        GlStateManager.enableTexture2D();
    }
}
