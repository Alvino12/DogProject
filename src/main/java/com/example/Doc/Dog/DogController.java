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
    public List<DogInsertDTO> getDog(){
        List<DogModel> dog= dogService.getDog();
        List<DogInsertDTO> dogInsertDTO = toDogDTO(dog);

        return dogInsertDTO;
    }

    @PostMapping
    public void registerNewdog(@RequestBody DogInsertDTO dogInsertDTO){
        DogModel dog = toDogModel(dogInsertDTO);
        dogService.addNewDog(dog);
    }

    @DeleteMapping(path="{dogID}")
    public void deleteDog(@PathVariable("dogID") Long dogID){
        dogService.deleteDog(dogID);
    }

    @PutMapping(path="{dogID}")
    public void updateDog(@PathVariable("dogID") Long DogID,@RequestBody DogPutDTO dogDTO){
        DogModel dog=toDogModel(dogDTO);
        dogService.updateDog(dog,DogID);
    }

    private DogModel toDogModel(DogInsertDTO dogInsertDTO){
        return modelMapper.map(dogInsertDTO,DogModel.class);
    }

    private DogModel toDogModel(DogPutDTO dogputDTO){
        return modelMapper.map(dogputDTO,DogModel.class);
    }

    private List<DogInsertDTO> toDogDTO(List<DogModel> dogModel){
        List<DogInsertDTO> dogInsertDTO = modelMapper.map(dogModel, new TypeToken<List<DogInsertDTO>>() {}.getType());
        return dogInsertDTO;
    }



}
