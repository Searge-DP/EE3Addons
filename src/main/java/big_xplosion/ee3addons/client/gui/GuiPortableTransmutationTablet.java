package big_xplosion.ee3addons.client.gui;

import big_xplosion.ee3addons.inventory.InventoryPortableTransmutationTablet;
import big_xplosion.ee3addons.inventory.container.ContainerPortableTransmutationTablet;
import com.pahimar.repackage.cofh.lib.gui.GuiBase;
import net.minecraft.entity.player.EntityPlayer;

// Not using my own GuiBase as I'm lazy and can just copy code from EE3 this way.
public class GuiPortableTransmutationTablet extends GuiBase {

	public GuiPortableTransmutationTablet(EntityPlayer player, InventoryPortableTransmutationTablet tabletInv) {
		super(new ContainerPortableTransmutationTablet(player, tabletInv));
	}
}
