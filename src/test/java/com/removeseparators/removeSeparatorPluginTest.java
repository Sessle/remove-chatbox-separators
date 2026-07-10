package com.removeseparators;

import net.runelite.client.RuneLite;
import net.runelite.client.externalplugins.ExternalPluginManager;

public class removeSeparatorPluginTest
{
	public static void main(String[] args) throws Exception
	{
		ExternalPluginManager.loadBuiltin(removeSeparatorPlugin.class);
		RuneLite.main(args);
	}
}