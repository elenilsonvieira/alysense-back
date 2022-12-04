package br.edu.ifpb.dac.alysense.alysense.business.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.ExampleMatcher.StringMatcher;
import org.springframework.stereotype.Service;

import br.edu.ifpb.dac.alysense.alysense.model.entity.Characteristic;
import br.edu.ifpb.dac.alysense.alysense.model.repository.CharacteristicRepository;
import br.edu.ifpb.dac.alysense.alysense.presentation.dto.CharacteristicDTO;

@Service
public class CharacteristicService {
    
    @Autowired
    private CharacteristicRepository characteristicRepository;

    @Autowired
    private ConverterService converterService;

    public Characteristic save(Characteristic characteristic ) {
		return characteristicRepository.save(characteristic);
	}

    public CharacteristicDTO findById(Long id) {
		Characteristic entity = characteristicRepository.findById(id).get();
		CharacteristicDTO dto = converterService.CharacteristicToDTO(entity);
		return dto;
	}

	public Iterable<Characteristic> findAll(){
		return characteristicRepository.findAll();
	}

    public List<Characteristic> find(Characteristic filter){
		Example example = Example.of(filter,
				ExampleMatcher.matching().withIgnoreCase()
				.withStringMatcher(StringMatcher.CONTAINING));
		return  characteristicRepository.findAll(example);
	}

    public Characteristic update(Characteristic characteristic) {
		return characteristicRepository.save(characteristic);
	}

    public void delete(Long id) {
		characteristicRepository.deleteById(id);
	}

}
