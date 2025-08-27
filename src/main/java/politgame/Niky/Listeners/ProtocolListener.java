package politgame.Niky.Listeners;

import com.comphenix.protocol.PacketType;
import com.comphenix.protocol.ProtocolManager;
import com.comphenix.protocol.events.ListenerPriority;
import com.comphenix.protocol.events.PacketAdapter;
import com.comphenix.protocol.events.PacketContainer;
import com.comphenix.protocol.events.PacketEvent;

import org.bukkit.ChatColor;
import org.bukkit.configuration.file.YamlConfiguration;

import politgame.Niky.BlockMSG;
import politgame.Niky.Files.ConfigFile;

import java.util.List;

public class ProtocolListener {
    public static void setProtocol() {
        YamlConfiguration yml = ConfigFile.getYaml();
        ProtocolManager pm = BlockMSG.getPm();
        pm.addPacketListener(new PacketAdapter(
                BlockMSG.getInstance(),
                ListenerPriority.NORMAL,
                PacketType.Play.Client.CHAT
        ){
            @Override
            public void onPacketReceiving(PacketEvent event) {
                PacketContainer packet = event.getPacket();
                List<String> blockMsg = yml.getStringList("blocked");
                String replaced = yml.getString("replaced");
                replaced = replaced.replace("&", "§");
                String error = yml.getString("error");
                error = error.replace("&", "§");
                String message = packet.getStrings().read(0).toLowerCase();
                for(String msg : blockMsg) {
                    if (message.contains(msg)) {
                        packet.getStrings().write(0, replaced);
                        event.getPlayer().sendMessage(error);
                    }
                }
            }
        });
    }
}
