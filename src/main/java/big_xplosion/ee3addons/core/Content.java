package big_xplosion.ee3addons.core;

import big_xplosion.ee3addons.api.EnchantmentEMCRegistry;
import big_xplosion.ee3addons.block.BlockEMChanter;
import big_xplosion.ee3addons.tile.TileEMChanter;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;

public class Content {

	public static Block emchanter;

	public static void preInit() {
		initBlocks();

		initEnchantmentCosts();
	}

	private static void initBlocks() {
		emchanter = new BlockEMChanter();

		GameRegistry.registerBlock(emchanter, "emchanter");

		GameRegistry.registerTileEntity(TileEMChanter.class, "emchanter");
	}

	private static void initEnchantmentCosts() { //TODO: find good values
		EnchantmentEMCRegistry.addEnchantmentEMCCost(Enchantment.protection, 0);
		EnchantmentEMCRegistry.addEnchantmentEMCCost(Enchantment.fireProtection, 0);
		EnchantmentEMCRegistry.addEnchantmentEMCCost(Enchantment.featherFalling, 0);
		EnchantmentEMCRegistry.addEnchantmentEMCCost(Enchantment.blastProtection, 0);
		EnchantmentEMCRegistry.addEnchantmentEMCCost(Enchantment.projectileProtection, 0);
		EnchantmentEMCRegistry.addEnchantmentEMCCost(Enchantment.respiration, 0);
		EnchantmentEMCRegistry.addEnchantmentEMCCost(Enchantment.aquaAffinity, 0);
		EnchantmentEMCRegistry.addEnchantmentEMCCost(Enchantment.thorns, 0);
		EnchantmentEMCRegistry.addEnchantmentEMCCost(Enchantment.sharpness, 0);
		EnchantmentEMCRegistry.addEnchantmentEMCCost(Enchantment.smite, 0);
		EnchantmentEMCRegistry.addEnchantmentEMCCost(Enchantment.baneOfArthropods, 0);
		EnchantmentEMCRegistry.addEnchantmentEMCCost(Enchantment.knockback, 0);
		EnchantmentEMCRegistry.addEnchantmentEMCCost(Enchantment.fireAspect, 0);
		EnchantmentEMCRegistry.addEnchantmentEMCCost(Enchantment.looting, 0);
		EnchantmentEMCRegistry.addEnchantmentEMCCost(Enchantment.efficiency, 0);
		EnchantmentEMCRegistry.addEnchantmentEMCCost(Enchantment.silkTouch, 0);
		EnchantmentEMCRegistry.addEnchantmentEMCCost(Enchantment.unbreaking, 0);
		EnchantmentEMCRegistry.addEnchantmentEMCCost(Enchantment.fortune, 0);
		EnchantmentEMCRegistry.addEnchantmentEMCCost(Enchantment.power, 0);
		EnchantmentEMCRegistry.addEnchantmentEMCCost(Enchantment.punch, 0);
		EnchantmentEMCRegistry.addEnchantmentEMCCost(Enchantment.flame, 0);
		EnchantmentEMCRegistry.addEnchantmentEMCCost(Enchantment.infinity, 0);
		EnchantmentEMCRegistry.addEnchantmentEMCCost(Enchantment.field_151370_z, 0); //Fishing: loot bonus
		EnchantmentEMCRegistry.addEnchantmentEMCCost(Enchantment.field_151369_A, 0); //Fishing: speed
	}
}
