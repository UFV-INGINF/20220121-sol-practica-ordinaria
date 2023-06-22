package es.ufv.dis.extraordinaria.practica;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class Controller {

    ArrayList<People> listPeople = new ArrayList<>();
    ArrayList<Params> listRequests = new ArrayList<>();
//    ArrayList<Starships> listStarship = new ArrayList<Starships>();



    @PostMapping(path = "params",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public People sendParams (@RequestBody Params params) {
        listRequests = Methods.readRequestsJSON();

        listRequests.add(params);

        People person = Methods.getPeopleSwapi(params);

        listPeople.add(person);

        Methods.writePeopleJSON(listPeople);
        Methods.writeRequestsJSON(listRequests);
//        Methods.writeStarshipsJSON(listStarships);

        return person;
    }

    @GetMapping("/requests")
    public ArrayList<Params> getListRequests () {

        return Methods.readRequestsJSON();
    }

}
