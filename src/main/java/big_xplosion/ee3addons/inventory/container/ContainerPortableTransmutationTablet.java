package big_xplosion.ee3addons.inventory.container;

import big_xplosion.ee3addons.inventory.InventoryPortableTransmutationTablet;
import com.pahimar.ee3.inventory.InventoryTransmutationTablet;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

public class ContainerPortableTransmutationTablet extends Container {

	private EntityPlayer player;
	private InventoryPortableTransmutationTablet tabletInv;
	private InventoryTransmutationTablet inventoryTransmutationTablet;

	protected final int PLAYER_INVENTORY_ROWS = 3;
	protected final int PLAYER_INVENTORY_COLUMNS = 9;

	private float energyValue;
	private String searchTerm;
	private int sortOption;
	private int sortOrder;
	private int scrollBarPosition;

	public ContainerPortableTransmutationTablet(EntityPlayer player, InventoryPortableTransmutationTablet tabletInv) {
		this.player = player;
		this.tabletInv = tabletInv;
	}


	@Override
	public boolean canInteractWith(EntityPlayer p_75145_1_) {
		return false;
	}
}
