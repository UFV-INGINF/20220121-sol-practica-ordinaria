package es.ufv.dis.extraordinaria.practica;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

public class Methods {

    private final static String url = "https://swapi.dev/api/%s/%s";

    static People getPeopleSwapi(Params params) {

        People person = null;

        String peopleUrl = String.format(url, params.getEntity(), params.getId());

        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(peopleUrl))
                    .GET()
                    .build();

            HttpResponse<String> response = HttpClient
                    .newBuilder()
                    .build()
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String jsonData = response.body();

            Gson gson = new Gson();
            person = gson.fromJson(jsonData, People.class);

        } catch (URISyntaxException e) {
            System.out.println("Error al crear la request: " + e.getMessage());
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }


        return person;
    }


    static void writePeopleJSON(ArrayList<People> peopleList) {

        Gson gson = new Gson();

        try (FileWriter writer = new FileWriter("people.json")) {
            gson.toJson(peopleList, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void writeRequestsJSON(ArrayList<Params> requestsList) {

        Gson gson = new Gson();

        try (FileWriter writer = new FileWriter("requests.json")) {
            gson.toJson(requestsList, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static ArrayList<Params> readRequestsJSON() {
        Gson gson = new Gson();

        Type listType = new TypeToken<ArrayList<Params>>() {
        }.getType();

        try {
            return gson.fromJson(new FileReader("requests.json", StandardCharsets.UTF_8), listType);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
