package big_xplosion.ee3addons.core;

import big_xplosion.ee3addons.block.BlockEMChanter;
import big_xplosion.ee3addons.tile.TileEMChanter;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;

public class Content {

	public static Block enchanter;

	public static void preInit() {
		initBlocks();

		testEnchantmentEMCValues();
	}

	public static void init() {

	}

	public static void postInit() {

	}

	private static void initBlocks() {
		enchanter = new BlockEMChanter();

		GameRegistry.registerBlock(enchanter, "emchanter");

		GameRegistry.registerTileEntity(TileEMChanter.class, "emchanter");
	}

	private static void testEnchantmentEMCValues() {                    //TEST METHOD
		for (Enchantment ench : Enchantment.enchantmentsList) {
			if (ench != null) {
				for (int i = 1; i <= ench.getMaxLevel(); i++)
					System.out.println(String.format("enchantment: %s	level: %s	value: %s", ench.getTranslatedName(i), i, (2000/ench.getWeight() * 10) + 10000 * i/10)); //still not sure what the formula will be
			}
		}
	}
}
