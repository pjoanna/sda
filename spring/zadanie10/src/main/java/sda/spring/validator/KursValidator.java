package sda.spring.validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import sda.spring.model.KursDto;
import sda.spring.repository.KursRepository;

@Component
public class KursValidator implements Validator{
	
	@Autowired
	private KursRepository kursRepository;
	
	@Override
	public boolean supports(Class<?> clazz) {
		return clazz == KursDto.class;
	}

	@Override
	public void validate(Object obj, Errors errors) {
		if(obj instanceof KursDto){
			KursDto kurs = (KursDto) obj;
			if(kurs.getFrom().isAfter(kurs.getTo())){
				errors.reject("data od po data do");
			}
			if(kursRepository.findByName(kurs.getName()) != null){
				errors.reject("nazwa kursu zajeta");
			}
		}
		
	}

}
