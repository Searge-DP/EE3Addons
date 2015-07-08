package big_xplosion.ee3addons.util;

import cpw.mods.fml.common.FMLCommonHandler;
import net.minecraftforge.common.MinecraftForge;

public class EventRegistry {

	public static void registerEvent(Object eventClass, EventType type) {
		if (type == EventType.FML || type == EventType.BOTH)
			FMLCommonHandler.instance().bus().register(eventClass);
		if (type == EventType.FORGE || type == EventType.BOTH)
			MinecraftForge.EVENT_BUS.register(eventClass);
	}

	public enum EventType {
		FML,
		FORGE,
		BOTH
	}
}
