package big_xplosion.ee3addons.api;

import com.google.common.collect.Maps;
import net.minecraft.enchantment.Enchantment;

import java.util.Map;

public class EnchantmentEMCRegistry {

	private static Map<Enchantment, Integer> enchantmentCosts = Maps.newHashMap();

	public static void addEnchantmentEMCCost(Enchantment enchantment, int emcCost) {
		enchantmentCosts.put(enchantment, emcCost);
	}

	public static int getEMCostForEnchantment(Enchantment enchantment) {
		return enchantmentCosts.get(enchantment);
	}

	public static void removeEMCEnchantmentcost(Enchantment enchantment) {
		enchantmentCosts.remove(enchantment);
	}
}
