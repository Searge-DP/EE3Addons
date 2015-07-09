package big_xplosion.ee3addons.inventory.container;

import big_xplosion.ee3addons.inventory.InventoryPortableTransmutationTablet;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

public class ContainerPortableTransmutationTablet extends Container {

	private EntityPlayer player;
	private InventoryPortableTransmutationTablet tabletInv;

	public ContainerPortableTransmutationTablet(EntityPlayer player, InventoryPortableTransmutationTablet tabletInv) {
		this.player = player;
		this.tabletInv = tabletInv;
	}

	@Override
	public boolean canInteractWith(EntityPlayer player) {
		return true;
	}
}
