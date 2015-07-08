package big_xplosion.ee3addons.item;

import big_xplosion.ee3addons.core.TabEE3Addons;
import com.pahimar.ee3.EquivalentExchange3;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemPortableTransmutationTablet extends Item {

	public ItemPortableTransmutationTablet() {
		this.setCreativeTab(TabEE3Addons.tab);
		this.setUnlocalizedName("portableTransTablet");
		this.setMaxStackSize(1);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		player.openGui(EquivalentExchange3.instance, 9, player.worldObj, (int) player.posX, (int) player.posY, (int) player.posZ);
		return stack;
	}
}
