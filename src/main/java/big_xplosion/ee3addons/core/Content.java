package big_xplosion.ee3addons.core;

import big_xplosion.ee3addons.block.BlockEMChanter;
import big_xplosion.ee3addons.tile.TileEMChanter;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public class Content {

	public static Block emchanter;

	public static void preInit() {
		initBlocks();
	}

	private static void initBlocks() {
		emchanter = new BlockEMChanter();

		GameRegistry.registerBlock(emchanter, "emchanter");

		GameRegistry.registerTileEntity(TileEMChanter.class, "emchanter");
	}
}
