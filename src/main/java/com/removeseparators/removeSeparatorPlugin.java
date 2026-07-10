package com.removeseparators;

import com.google.inject.Provides;
import javax.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import net.runelite.api.ChatMessageType;
import net.runelite.api.Client;
import net.runelite.api.GameState;
import net.runelite.api.events.ClientTick;
import net.runelite.api.events.GameStateChanged;
import net.runelite.api.events.WidgetLoaded;
import net.runelite.api.widgets.Widget;
import net.runelite.client.callback.ClientThread;
import net.runelite.client.config.ConfigManager;
import net.runelite.client.eventbus.Subscribe;
import net.runelite.client.plugins.Plugin;
import net.runelite.client.plugins.PluginDescriptor;

@Slf4j
@PluginDescriptor(
	name = "Example"
)
public class removeSeparatorPlugin extends Plugin
{
	@Inject
	private Client client;

	@Inject
	private ClientThread clientThread;

	@Inject
	private removeSeparatorConfig config;

	@Subscribe
	public void onClientTick(ClientTick event)
	{
		hideChatSeparators();
	}

	private void hideChatSeparators()
	{
		Widget container = client.getWidget(162, 56);

		if (container == null || container.getChildren() == null)
		{
			log.info("Container null");
			return;
		}

		for (Widget child : container.getChildren())
		{
			child.setOpacity(255);
		}
	}

	@Provides
	removeSeparatorConfig provideConfig(ConfigManager configManager)
	{
		return configManager.getConfig(removeSeparatorConfig.class);
	}
}
