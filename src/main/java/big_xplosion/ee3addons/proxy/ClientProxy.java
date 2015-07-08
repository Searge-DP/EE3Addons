package big_xplosion.ee3addons.proxy;

import big_xplosion.ee3addons.client.handler.RenderPlayerEventHandler;
import big_xplosion.ee3addons.util.EventRegistry;

public class ClientProxy extends CommonProxy {

	@Override
	public void preInit() {
		super.preInit();

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

	@Override
	public void initClientEventHandlers() {
		EventRegistry.registerEvent(new RenderPlayerEventHandler(), EventRegistry.EventType.FORGE);
	}
}
