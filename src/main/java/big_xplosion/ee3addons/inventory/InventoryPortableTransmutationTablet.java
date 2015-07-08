package big_xplosion.ee3addons.inventory;

import com.pahimar.ee3.exchange.EnergyValueRegistry;
import com.pahimar.ee3.item.ItemAlchemicalTome;
import com.pahimar.ee3.item.ItemMiniumStone;
import com.pahimar.ee3.item.ItemPhilosophersStone;
import com.pahimar.ee3.knowledge.AbilityRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class InventoryPortableTransmutationTablet implements IInventory {

	private ItemStack[] items = new ItemStack[10];

	@Override
	public int getSizeInventory() {
		return items.length;
	}

	@Override
	public ItemStack getStackInSlot(int slot) {
		return items[slot];
	}

	@Override
	public ItemStack decrStackSize(int slot, int amount) {
		if (slot < items.length && items[slot] != null) {
			if (items[slot].stackSize > amount)
				return items[slot].splitStack(amount);
			ItemStack stack = items[slot];
			setInventorySlotContents(slot, null);
			return stack;
		}
		return null;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slot) {
		if (items[slot] == null)
			return null;

		ItemStack stack = items[slot];
		setInventorySlotContents(slot, null);
		return stack;
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack stack) {
		items[slot] = stack;

		if (stack != null && stack.stackSize > getInventoryStackLimit())
			stack.stackSize = getInventoryStackLimit();

		markDirty();
	}

	@Override
	public String getInventoryName() {
		return null;
	}

	@Override
	public boolean hasCustomInventoryName() {
		return false;
	}

	@Override
	public int getInventoryStackLimit() {
		return 64;
	}

	@Override
	public void markDirty() {

	}

	@Override
	public boolean isUseableByPlayer(EntityPlayer p_70300_1_) {
		return true;
	}

	@Override
	public void openInventory() {

	}

	@Override
	public void closeInventory() {

	}

	@Override
	public boolean isItemValidForSlot(int slot, ItemStack stack) {
		if (slot < 8 && EnergyValueRegistry.getInstance().hasEnergyValue(stack) && AbilityRegistry.getInstance().isRecoverable(stack))
			return true;

		if (slot == 8 && (stack.getItem() instanceof ItemMiniumStone || stack.getItem() instanceof ItemPhilosophersStone))
			return true;

		if (slot == 9 && stack.getItem() instanceof ItemAlchemicalTome)
			return true;

		return false;
	}
}
