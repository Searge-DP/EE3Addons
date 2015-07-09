package big_xplosion.ee3addons.proxy;

import big_xplosion.ee3addons.EE3Addons;
import big_xplosion.ee3addons.client.handler.GuiHandler;
import big_xplosion.ee3addons.client.handler.RenderPlayerEventHandler;
import big_xplosion.ee3addons.util.EventRegistry;
import cpw.mods.fml.common.network.NetworkRegistry;

public class ClientProxy extends CommonProxy {

	@Override
	public void preInit() {
		super.preInit();

		NetworkRegistry.INSTANCE.registerGuiHandler(EE3Addons.instance, new GuiHandler());

		initClientEventHandlers();
	}

	@Override
	public void init() {
		super.init();
	}

	@Override
	public void postInit() {
		super.postInit();
	}

	private void initClientEventHandlers() {
		EventRegistry.registerEvent(new RenderPlayerEventHandler(), EventRegistry.EventType.FORGE);
	}
}
