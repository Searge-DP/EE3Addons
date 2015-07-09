package big_xplosion.ee3addons.inventory;

import com.pahimar.ee3.api.exchange.EnergyValue;
import com.pahimar.ee3.api.exchange.EnergyValueRegistryProxy;
import com.pahimar.ee3.exchange.EnergyValueRegistry;
import com.pahimar.ee3.item.ItemAlchemicalTome;
import com.pahimar.ee3.item.ItemMiniumStone;
import com.pahimar.ee3.item.ItemPhilosophersStone;
import com.pahimar.ee3.knowledge.AbilityRegistry;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraftforge.common.util.Constants;

public class InventoryPortableTransmutationTablet implements IInventory {

	private ItemStack tablet;

	private ItemStack[] items;
	private EnergyValue storedEnergyValue;
	private EnergyValue availableEnergyValue;

	public InventoryPortableTransmutationTablet(ItemStack tablet) {
		this.tablet = tablet;
		this.items = new ItemStack[10];
		this.storedEnergyValue = new EnergyValue(0);
		this.availableEnergyValue = new EnergyValue(0);
	}

	public EnergyValue getStoredEnergy() {
		return storedEnergyValue;
	}

	public EnergyValue getAvailableEnergy() {
		return availableEnergyValue;
	}

	public void updateEnergyValueFromInventory() {
		float newEnergyValue = storedEnergyValue.getValue();

		for (int i = 0; i <= 8; i++) {
			if (items[i] != null && EnergyValueRegistryProxy.hasEnergyValue(items[i]))
				newEnergyValue += EnergyValueRegistryProxy.getEnergyValueForStack(items[i]).getValue();
		}

		this.availableEnergyValue = new EnergyValue(newEnergyValue);
	}

	public void consumeInventoryForEnergyValue(ItemStack outputItemStack) {
		EnergyValue outputEnergyValue = EnergyValueRegistryProxy.getEnergyValue(outputItemStack);

		if (this.storedEnergyValue.compareTo(outputEnergyValue) >= 0)
			this.storedEnergyValue = new EnergyValue(this.storedEnergyValue.getValue() - outputEnergyValue.getValue());
		else {
			while (this.storedEnergyValue.compareTo(outputEnergyValue) < 0 && this.availableEnergyValue.compareTo(outputEnergyValue) >= 0) {
				for (int i = 0; i < 8; i++) {
					ItemStack stackInSlot = getStackInSlot(i);
					if (stackInSlot != null && EnergyValueRegistryProxy.hasEnergyValue(stackInSlot)) {
						this.storedEnergyValue = new EnergyValue(this.storedEnergyValue.getValue() + EnergyValueRegistryProxy.getEnergyValue(stackInSlot).getValue());
						decrStackSize(i, 1);
					}
				}
			}
			if (this.storedEnergyValue.getValue() >= outputEnergyValue.getValue())
				this.storedEnergyValue = new EnergyValue(this.storedEnergyValue.getValue() - outputEnergyValue.getValue());
		}

		updateEnergyValueFromInventory();
	}

	public void readFromNBT() {
		items = new ItemStack[this.getSizeInventory()];

		if (tablet.getTagCompound().hasKey("Items", Constants.NBT.TAG_COMPOUND)) {
			NBTTagList list = tablet.getTagCompound().getTagList("Items", Constants.NBT.TAG_COMPOUND);

			for (int i = 0; i < list.tagCount(); ++i) {
				NBTTagCompound tagCompound = list.getCompoundTagAt(i);
				byte slotIndex = tagCompound.getByte("Slot");
				if (slotIndex >= 0 && slotIndex < items.length)
					items[slotIndex] = ItemStack.loadItemStackFromNBT(tagCompound);
			}
		}

		NBTTagCompound energyValueTagCompound = tablet.getTagCompound().getCompoundTag("StoredEnergyValue");

		if (energyValueTagCompound != null && !energyValueTagCompound.hasNoTags())
			storedEnergyValue = EnergyValue.loadEnergyValueFromNBT(energyValueTagCompound);
		else
			storedEnergyValue = new EnergyValue(0);
	}

	public void writeToNBT() {
		NBTTagList list = new NBTTagList();

		for (int i = 0; i < items.length; i++) {
			if (items[i] != null) {
				NBTTagCompound tagCompound = new NBTTagCompound();
				tagCompound.setByte("Slot", (byte) i);
				items[i].writeToNBT(tagCompound);
				list.appendTag(tagCompound);
			}
		}

		tablet.getTagCompound().setTag("Items", list);
		NBTTagCompound energyValueTagCompound = new NBTTagCompound();

		if (storedEnergyValue != null)
			storedEnergyValue.writeToNBT(energyValueTagCompound);

		tablet.getTagCompound().setTag("StoredEnergyValue", energyValueTagCompound);
	}

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
		ItemStack itemStack = getStackInSlot(slot);

		if (itemStack != null) {
			if (itemStack.stackSize <= amount) {
				setInventorySlotContents(slot, null);
			} else {
				itemStack = itemStack.splitStack(amount);
				if (itemStack.stackSize == 0)
					setInventorySlotContents(slot, null);
			}
		}

		return itemStack;
	}

	@Override
	public ItemStack getStackInSlotOnClosing(int slot) {
		ItemStack itemStack = getStackInSlot(slot);

		if (itemStack != null)
			setInventorySlotContents(slot, null);

		return itemStack;
	}

	@Override
	public void setInventorySlotContents(int slot, ItemStack stack) {
		if (slot < getSizeInventory()) {
			items[slot] = stack;
			if (stack != null && stack.stackSize > getInventoryStackLimit())
				stack.stackSize = getInventoryStackLimit();

			updateEnergyValueFromInventory();
		}
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
	public boolean isUseableByPlayer(EntityPlayer player) {
		return true;
	}

	@Override
	public void openInventory() {
		readFromNBT();
	}

	@Override
	public void closeInventory() {
		writeToNBT();
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
