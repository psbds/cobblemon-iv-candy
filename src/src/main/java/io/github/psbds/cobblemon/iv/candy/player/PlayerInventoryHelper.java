package io.github.psbds.cobblemon.iv.candy.player;

import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;

public class PlayerInventoryHelper {
    
    public static void addOrDrop(ServerPlayer player, ItemStack itemStack) {
        if (player.getInventory().add(itemStack)) {
        } else {
            player.drop(itemStack, false);
        }
    }
}
