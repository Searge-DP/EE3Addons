package big_xplosion.ee3addons.core;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class TabEE3Addons extends CreativeTabs {

	public static TabEE3Addons tab = new TabEE3Addons();

	public TabEE3Addons() {
		super("ee3Addons");
	}

	@Override
	public Item getTabIconItem() {
		return Item.getItemFromBlock(Content.enchanter);
	}
}
