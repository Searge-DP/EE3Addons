package big_xplosion.ee3addons.client.handler;

import big_xplosion.ee3addons.client.gui.GuiPortableTransmutationTablet;
import big_xplosion.ee3addons.inventory.InventoryPortableTransmutationTablet;
import big_xplosion.ee3addons.inventory.container.ContainerPortableTransmutationTablet;
import big_xplosion.ee3addons.util.GUIs;
import cpw.mods.fml.common.network.IGuiHandler;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class GuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (ID == GUIs.PORTABLE_TRANSMUTATION_TABLET.ordinal())
			return new ContainerPortableTransmutationTablet(player, new InventoryPortableTransmutationTablet(player.getHeldItem()));
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (ID == GUIs.PORTABLE_TRANSMUTATION_TABLET.ordinal())
			return new GuiPortableTransmutationTablet(player, new InventoryPortableTransmutationTablet(player.getHeldItem()));
		return null;
	}
}
