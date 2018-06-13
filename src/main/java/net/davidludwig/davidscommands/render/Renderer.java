package net.davidludwig.davidscommands.render;

import net.minecraft.client.Minecraft;

public class Renderer {

    protected Minecraft minecraft;

    public Renderer() {
        minecraft = Minecraft.getMinecraft();
    }

    public Minecraft getMinecraft() {
        return minecraft;
    }
}
