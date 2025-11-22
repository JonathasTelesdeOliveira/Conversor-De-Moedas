import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;

public class GeradorArquivo {
    public void salvaJson(Object object, String nomeArquivo) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        FileWriter escrita = new FileWriter(nomeArquivo+".json");
        escrita.write(gson.toJson(object));
        escrita.close();
    }
}
