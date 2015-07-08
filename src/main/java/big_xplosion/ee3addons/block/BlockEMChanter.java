package big_xplosion.ee3addons.block;

import big_xplosion.ee3addons.core.TabEE3Addons;
import big_xplosion.ee3addons.tile.TileEMChanter;
import net.minecraft.block.Block;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;

public class BlockEMChanter extends Block implements ITileEntityProvider {

	public BlockEMChanter() {
		super(Material.rock);
		this.setBlockName("enchanter");
		this.setCreativeTab(TabEE3Addons.tab);
	}

	@Override
	public TileEntity createNewTileEntity(World world, int meta) {
		return new TileEMChanter();
	}
}
