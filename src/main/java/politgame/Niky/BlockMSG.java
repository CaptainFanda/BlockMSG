package politgame.Niky;

import com.comphenix.protocol.ProtocolLibrary;
import com.comphenix.protocol.ProtocolManager;

import org.bukkit.plugin.java.JavaPlugin;

import politgame.Niky.Files.ConfigFile;
import politgame.Niky.Listeners.ProtocolListener;

import java.util.logging.Logger;

public final class BlockMSG extends JavaPlugin {
    private static ProtocolManager pm;
    private static BlockMSG instance;
    private static Logger Log = Logger.getLogger("Minecraft");
    @Override
    public void onEnable() {
        // Plugin startup logic
        instance = this;
        pm = ProtocolLibrary.getProtocolManager();
        ConfigFile.createFiles();
        ProtocolListener.setProtocol();
        Log.info(">-----------------<");
        Log.info("BlockMsg - Enabled");
        Log.info(">-----------------<");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        Log.info(">-----------------<");
        Log.info("BlockMsg - Disabled");
        Log.info(">-----------------<");
    }

    public static ProtocolManager getPm() {
        return pm;
    }
    public static BlockMSG getInstance() {
        return instance;
    }
}
