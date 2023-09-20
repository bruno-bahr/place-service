package br.com.brunobahr.placeservice.web;

import br.com.brunobahr.placeservice.api.PlaceRequest;
import br.com.brunobahr.placeservice.api.PlaceResponse;
import br.com.brunobahr.placeservice.domain.Place;
import br.com.brunobahr.placeservice.domain.PlaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/places")
public class PlaceController {
    @Autowired
    private PlaceService placeService;

    @PostMapping
    public ResponseEntity<Mono<PlaceResponse>> create(@RequestBody PlaceRequest request){
        var newPlace = placeService.create(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(newPlace);
    }
}
