package com.antonleagre.temporary.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.antonleagre.temporary.Main;

import static com.antonleagre.temporary.Main.TITLE;
import static com.antonleagre.temporary.Main.V_HEIGHT;
import static com.antonleagre.temporary.Main.V_WIDTH;

public class DesktopLauncher {
	public static void main (String[] arg) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		config.width = V_WIDTH;
		config.height = V_HEIGHT;
		config.title = TITLE;
		new LwjglApplication(new Main(), config);
	}
}
