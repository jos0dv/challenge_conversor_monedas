import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Conversor {

    public double obtenerTasa(String json){

        JsonObject jsonObject =
                JsonParser.parseString(json).getAsJsonObject();

        return jsonObject.get("conversion_rate").getAsDouble();
    }

    public double convertir(double valor, double tasa){

        return valor * tasa;

    }
}