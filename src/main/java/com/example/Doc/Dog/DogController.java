package com.example.Doc.Dog;

import com.example.Doc.Dog.DTO.DogInsertDTO;
import com.example.Doc.Dog.DTO.DogListDTO;
import com.example.Doc.Dog.DTO.DogPutDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(path = "api/v1/dog")
public class DogController {

    private final DogService dogService;

    public DogController(DogService dogService) {
        this.dogService = dogService;
    }

    @Autowired
    private ModelMapper modelMapper;


    @GetMapping
    public List<DogListDTO> getDog(){
        List<DogModel> dog= dogService.getDog();
        List<DogListDTO> dogListDTO = toDogDTO(dog);

        return dogListDTO;
    }

    @GetMapping(path="{dogID}")
    public DogListDTO getDogByID(@PathVariable("dogID") Long dogID){
        DogModel dog= dogService.getDogByID(dogID);
        DogListDTO dogListDTO = toDogDTOID(dog);
        return dogListDTO;
    }

    @PostMapping
    public void registerNewdog(@RequestBody @Valid DogInsertDTO dogInsertDTO){
        DogModel dog = toDogModelI(dogInsertDTO);
        dogService.addNewDog(dog);
    }

    @DeleteMapping(path="{dogID}")
    public void deleteDog(@PathVariable("dogID") Long dogID){
        dogService.deleteDog(dogID);
    }

    @PutMapping(path="{dogID}")
    public void updateDog(@PathVariable("dogID") Long DogID,@RequestBody DogPutDTO dogDTO){
        DogModel dog=toDogModelP(dogDTO);
        dogService.updateDog(dog,DogID);
    }

    private DogModel toDogModelI(DogInsertDTO dogInsertDTO){
        return modelMapper.map(dogInsertDTO,DogModel.class);
    }

    private DogModel toDogModelP(DogPutDTO dogputDTO){
        return modelMapper.map(dogputDTO,DogModel.class);
    }

    private List<DogListDTO> toDogDTO(List<DogModel> dogModel){
        List<DogListDTO> dogListDTO = modelMapper.map(dogModel, new TypeToken<List<DogListDTO>>() {}.getType());
        return dogListDTO;
    }
    private DogListDTO toDogDTOID(DogModel dogModel){
        DogListDTO dogListDTO = modelMapper.map(dogModel, new TypeToken<DogListDTO>() {}.getType());
        return dogListDTO;
    }



}
