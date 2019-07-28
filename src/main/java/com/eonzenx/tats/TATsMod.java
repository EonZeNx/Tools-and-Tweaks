package com.eonzenx.tats;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.eonzenx.modsetup.items.ModItems;
import com.eonzenx.modsetup.setup.ClientProxy;
import com.eonzenx.modsetup.setup.IProxy;
import com.eonzenx.modsetup.setup.TATsModSetup;
import com.eonzenx.modsetup.tools.ModAxe;
import com.eonzenx.modsetup.tools.ModHoe;
import com.eonzenx.modsetup.tools.ModPickaxe;
import com.eonzenx.modsetup.tools.ModShovel;
import com.eonzenx.modsetup.tools.ModSword;
import com.eonzenx.modsetup.tools.ToolMaterialList;
import com.eonzenx.modsetup.setup.ServerProxy;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("tatsmod")
public class TATsMod
{
	public static final String MOD_ID = "tatsmod";
	public static IProxy proxy = DistExecutor.runForDist(() -> () -> new ClientProxy(), () -> () -> new ServerProxy());
    private static final Logger LOGGER = LogManager.getLogger();
    public static TATsModSetup setup = new TATsModSetup();
    
    public TATsMod() {
        // Register methods for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
    }
    private void setup(final FMLCommonSetupEvent event) {
        LOGGER.info("preinit code here");
        setup.init();
        proxy.init();
    }
    
    // Shorter new ResourceLocation
    public static ResourceLocation nRL(String path) {
    	return new ResourceLocation(MOD_ID, path);
    }
    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> event) {
            LOGGER.info("Register new blocks here");
        }
        @SubscribeEvent
        public static void onItemsRegistry(final RegistryEvent.Register<Item> event) {
            LOGGER.info("Register new items here");
            
            event.getRegistry().registerAll(
            		// Stone tools
	            		// Andesite tools
	            		ModItems.ANDESITE_AXE = new ModAxe("andesite_axe", ToolMaterialList.ANDESITE, 7F, -3.2F, new Item.Properties()),
	            		ModItems.ANDESITE_HOE = new ModHoe("andesite_hoe", ToolMaterialList.ANDESITE, -2F, new Item.Properties()),
	            		ModItems.ANDESITE_PICKAXE = new ModPickaxe("andesite_pickaxe", ToolMaterialList.ANDESITE, 1, -2.8F, new Item.Properties()),
	            		ModItems.ANDESITE_SHOVEL = new ModShovel("andesite_shovel", ToolMaterialList.ANDESITE, 1.5F, -3F, new Item.Properties()),
	            		ModItems.ANDESITE_SWORD = new ModSword("andesite_sword", ToolMaterialList.ANDESITE, 3, -2.4F, new Item.Properties()),
	            		
	            		// Diorite tools
	            		ModItems.DIORITE_AXE = new ModAxe("diorite_axe", ToolMaterialList.DIORITE, 7F, -3.2F, new Item.Properties()),
	            		ModItems.DIORITE_HOE = new ModHoe("diorite_hoe", ToolMaterialList.DIORITE, -2F, new Item.Properties()),
	            		ModItems.DIORITE_PICKAXE = new ModPickaxe("diorite_pickaxe", ToolMaterialList.DIORITE, 1, -2.8F, new Item.Properties()),
	            		ModItems.DIORITE_SHOVEL = new ModShovel("diorite_shovel", ToolMaterialList.DIORITE, 1.5F, -3F, new Item.Properties()),
	            		ModItems.DIORITE_SWORD = new ModSword("diorite_sword", ToolMaterialList.DIORITE, 3, -2.4F, new Item.Properties()),
	            		
	            		// Granite tools
	            		ModItems.GRANITE_AXE = new ModAxe("granite_axe", ToolMaterialList.GRANITE, 7F, -3.2F, new Item.Properties()),
	            		ModItems.GRANITE_HOE = new ModHoe("granite_hoe", ToolMaterialList.GRANITE, -2F, new Item.Properties()),
	            		ModItems.GRANITE_PICKAXE = new ModPickaxe("granite_pickaxe", ToolMaterialList.GRANITE, 1, -2.8F, new Item.Properties()),
	            		ModItems.GRANITE_SHOVEL = new ModShovel("granite_shovel", ToolMaterialList.GRANITE, 1.5F, -3F, new Item.Properties()),
	            		ModItems.GRANITE_SWORD = new ModSword("granite_sword", ToolMaterialList.GRANITE, 3, -2.4F, new Item.Properties()),
	            	
	            	// Ore tools
	            		// Emerald
        				ModItems.EMERALD_AXE = new ModAxe("emerald_axe", ToolMaterialList.EMERALD, 7F, -3.2F, new Item.Properties()),
	            		ModItems.EMERALD_HOE = new ModHoe("emerald_hoe", ToolMaterialList.EMERALD, -2F, new Item.Properties()),
	            		ModItems.EMERALD_PICKAXE = new ModPickaxe("emerald_pickaxe", ToolMaterialList.EMERALD, 1, -2.8F, new Item.Properties()),
	            		ModItems.EMERALD_SHOVEL = new ModShovel("emerald_shovel", ToolMaterialList.EMERALD, 1.5F, -3F, new Item.Properties()),
	            		ModItems.EMERALD_SWORD = new ModSword("emerald_sword", ToolMaterialList.EMERALD, 2, -1.6F, new Item.Properties()),
	            		
	            		// Redstone
	            		ModItems.REDSTONE_AXE = new ModAxe("redstone_axe", ToolMaterialList.REDSTONE, 7F, -2.2F, new Item.Properties()),
	            		ModItems.REDSTONE_HOE = new ModHoe("redstone_hoe", ToolMaterialList.REDSTONE, -1F, new Item.Properties()),
	            		ModItems.REDSTONE_PICKAXE = new ModPickaxe("redstone_pickaxe", ToolMaterialList.REDSTONE, 1, -1.8F, new Item.Properties()),
	            		ModItems.REDSTONE_SHOVEL = new ModShovel("redstone_shovel", ToolMaterialList.REDSTONE, 1.5F, -2F, new Item.Properties()),
	            		ModItems.REDSTONE_SWORD = new ModSword("redstone_sword", ToolMaterialList.REDSTONE, 2, -0.8F, new Item.Properties()),
	            		
	            		// Lapis Lazuli
        				ModItems.LAPIS_LAZULI_AXE = new ModAxe("lapis_lazuli_axe", ToolMaterialList.LAPIS_LAZULI, 7F, -3.2F, new Item.Properties()),
	            		ModItems.LAPIS_LAZULI_HOE = new ModHoe("lapis_lazuli_hoe", ToolMaterialList.LAPIS_LAZULI, -2F, new Item.Properties()),
	            		ModItems.LAPIS_LAZULI_PICKAXE = new ModPickaxe("lapis_lazuli_pickaxe", ToolMaterialList.LAPIS_LAZULI, 1, -2.8F, new Item.Properties()),
	            		ModItems.LAPIS_LAZULI_SHOVEL = new ModShovel("lapis_lazuli_shovel", ToolMaterialList.LAPIS_LAZULI, 1.5F, -3F, new Item.Properties()),
	            		ModItems.LAPIS_LAZULI_SWORD = new ModSword("lapis_lazuli_sword", ToolMaterialList.LAPIS_LAZULI, 2, -1.6F, new Item.Properties())
            );
        }
    }
}
