package sda.spring.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import sda.spring.converter.LocalDateAttributeConverter;
import sda.spring.model.Kurs;
import sda.spring.model.KursDto;

@Component
public class KursMapper {
	
	@Autowired
	private LocalDateAttributeConverter dateConverter;
	
	public Kurs map(KursDto dto){
		Kurs entity = new Kurs();
		entity.setFromDate(dto.getFrom());
		entity.setName(dto.getName());
		entity.setMaxParticipants(dto.getMaxParticipants());
		entity.setToDate(dto.getTo());
		return entity;
	}
	
	public KursDto map(Kurs entity){
		KursDto dto = new KursDto();
		dto.setFrom(entity.getFromDate());
		dto.setName(entity.getName());
		dto.setMaxParticipants(entity.getMaxParticipants());
		dto.setTo(entity.getToDate());
		return dto;
	}
	
	

}
