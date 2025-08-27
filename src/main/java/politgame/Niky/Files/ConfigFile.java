package politgame.Niky.Files;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class ConfigFile {
    private static final File file = new File("plugins/BlockMSG/config.yml");

    public static void createFiles() {
        YamlConfiguration yml;
        if(!file.exists()) {
            yml = YamlConfiguration.loadConfiguration(file);
            List<String> blockedMessages = Arrays.asList("fuck", "bitch", "asshol", "ass", "shit");
            yml.addDefault("blocked", blockedMessages);
            yml.addDefault("replaced", ":)");
            yml.addDefault("error", "&7[&6Server Name&7] &ePlease, Use less swearing");
            yml.options().copyDefaults(true);
            try {
                yml.save(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static YamlConfiguration getYaml() {
        return YamlConfiguration.loadConfiguration(file);
    }
}
