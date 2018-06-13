package net.davidludwig.davidscommands;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;

public abstract class CommonProxy {

    public abstract void registerCommands();

    public void init(FMLInitializationEvent event) {
    }
}
