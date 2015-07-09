package big_xplosion.ee3addons.item;

import big_xplosion.ee3addons.EE3Addons;
import big_xplosion.ee3addons.core.TabEE3Addons;
import big_xplosion.ee3addons.util.GUIs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class ItemPortableTransmutationTablet extends Item {

	public ItemPortableTransmutationTablet() {
		this.setCreativeTab(TabEE3Addons.tab);
		this.setUnlocalizedName("portableTransTablet");
		this.setMaxStackSize(1);
	}

	@Override
	public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
		if (stack.getTagCompound() == null)
			stack.stackTagCompound = new NBTTagCompound();

		player.openGui(EE3Addons.instance, GUIs.PORTABLE_TRANSMUTATION_TABLET.ordinal(), player.worldObj, (int) player.posX, (int) player.posY, (int) player.posZ);

		return stack;
	}
}
