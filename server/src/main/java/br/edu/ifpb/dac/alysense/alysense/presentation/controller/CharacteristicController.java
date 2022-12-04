package br.edu.ifpb.dac.alysense.alysense.presentation.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.edu.ifpb.dac.alysense.alysense.business.service.CharacteristicService;
import br.edu.ifpb.dac.alysense.alysense.business.service.ConverterService;
import br.edu.ifpb.dac.alysense.alysense.model.entity.Characteristic;
import br.edu.ifpb.dac.alysense.alysense.presentation.dto.CharacteristicDTO;

@RestController
@RequestMapping("/api/characteristic")
public class CharacteristicController {

    @Autowired
    private CharacteristicService characteristicService;

    @Autowired
    private ConverterService converterService;


    @PostMapping
	public ResponseEntity save(@RequestBody CharacteristicDTO dto) {

		try {
			Characteristic entity = converterService.DTOToCharacteristic(dto);
			characteristicService.save(entity);
			dto = converterService.CharacteristicToDTO(entity);
			return new ResponseEntity(dto, HttpStatus.CREATED);
		} catch (Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

    @PutMapping("{id}")
	public ResponseEntity update(@PathVariable("id") Long id,@RequestBody CharacteristicDTO dto) {
		try {
			dto.setId(id);
			Characteristic characteristic = converterService.DTOToCharacteristic(dto);
			characteristic = characteristicService.update(characteristic);
			dto = converterService.CharacteristicToDTO(characteristic);
			return ResponseEntity.ok(dto);
		}catch(Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

    @DeleteMapping("{id}")
	public ResponseEntity delete(@PathVariable("id") Long id){
		try {
			characteristicService.delete(id);
			return new ResponseEntity(HttpStatus.NO_CONTENT);
		}catch(Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

    @GetMapping
	public ResponseEntity find( @RequestParam(value = "id", required = false) Long id,
        @RequestParam(value = "Atribute", required = false) String atribute) {
		try {
			Characteristic filter = new Characteristic();
			filter.setId(id);
            filter.setAtribute(atribute);
			
			List<Characteristic> entities = characteristicService.find(filter);
			List<CharacteristicDTO> dtos = converterService.CharacteristicToDTO(entities);
			return ResponseEntity.ok(dtos);
		}catch(Exception e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}

	}
}
