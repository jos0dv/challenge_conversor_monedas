import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ConsultaAPI {
    public String obtenerDatos(String monedaBase, String monedaDestino) throws IOException, InterruptedException {

        String apiKey = "40910f321ed43f42c9ebd3ac";

        String direccion =
                "https://v6.exchangerate-api.com/v6/"
                        + apiKey
                        + "/pair/"
                        + monedaBase
                        + "/"
                        + monedaDestino;

        HttpClient client = HttpClient.newHttpClient();

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .build();

        HttpResponse<String> response =
                client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }
}
