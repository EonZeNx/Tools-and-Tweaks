package com.eonzenx.modsetup.events.equippedEvents;

import com.eonzenx.modsetup.events.EquippedEvent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;

@Mod("tatsmod")
public class HelmetEquipEvent extends EquippedEvent {
	public HelmetEquipEvent(PlayerEntity player, Item equippedItem) {
		super(player, equippedItem);
		
		System.out.println("Equipped " + equippedItem.getRegistryName().toString());
	}
}
