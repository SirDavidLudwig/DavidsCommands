package net.davidludwig.davidscommands.util;

import net.minecraft.util.math.ChunkPos;

public class ChunkUtils {

    public static int unloadPriority(ChunkPos pos) {
        int h;
        long key = Long.hashCode(ChunkPos.asLong(pos.x, pos.z));
        return hash(key);
    }

    public static int hash(long key) {
        int hash = (int) ((key >>> 32) ^ (key & 0xFFFFFFFFL));
        return (hash >>> 16) ^ (hash & 0xFFFF);
    }
}
