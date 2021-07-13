package com.example.Doc.Dog;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping(path = "api/v1/dog")
public class DogController {

    private final DogService dogService;

    public DogController(DogService dogService) {
        this.dogService = dogService;
    }

    @Autowired
    private ModelMapper modelMapper;


    @GetMapping
    public List<DogDTO> getDog(){
        List<DogModel> dog= dogService.getDog();
        List<DogDTO> dogDTO = toDogDTO(dog);

        return dogDTO;
    }

    @PostMapping
    public void registerNewdog(@RequestBody DogDTO dogDTO){
        DogModel dog = toDogModel(dogDTO);
        dogService.addNewDog(dog);
    }

    @DeleteMapping(path="{dogID}")
    public void deleteDog(@PathVariable("dogID") Long dogID){
        dogService.deleteDog(dogID);
    }

    @PutMapping(path="{dogID}")
    public void updateDog(@PathVariable("dogID") Long DogID,@RequestBody DogDTO dogDTO){
        DogModel dog=toDogModel(dogDTO);
        dogService.updateDog(dog,DogID);
    }

    private DogModel toDogModel(DogDTO dogDTO){
        return modelMapper.map(dogDTO,DogModel.class);
    }

    private List<DogDTO> toDogDTO(List<DogModel> dogModel){
        List<DogDTO> dogDTO= modelMapper.map(dogModel, new TypeToken<List<DogDTO>>() {}.getType());
        return dogDTO;
    }



}
