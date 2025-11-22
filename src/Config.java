import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {
    private static final Properties props = new Properties();

    static {
        try {
            props.load(new FileInputStream("resources/config.properties"));
        } catch (IOException e) {
            throw new RuntimeException("Falha ao carregar o arquivo de configuração.", e);
        }
    }

    public static String get(String key) {
        return props.getProperty(key);
    }
}