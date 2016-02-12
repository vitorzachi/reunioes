package br.com.camtwo.reunioes.database.converter;

import br.com.camtwo.reunioes.model.basic.Id;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Created by vitor on 28/01/16.
 */
@Converter(autoApply = true)
public class IdConverter implements AttributeConverter<Id, Long>{
    @Override
    public Long convertToDatabaseColumn(Id id) {
        if(id == null){
            return null;
        }
        return id.getId();
    }

    @Override
    public Id convertToEntityAttribute(Long data) {
        return new Id(data);
    }
}
