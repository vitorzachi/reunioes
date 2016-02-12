package br.com.camtwo.reunioes.database.converter;

import br.com.camtwo.reunioes.model.basic.Email;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;

/**
 * Created by vitor on 28/01/16.
 */
@Converter(autoApply = true)
public class EmailConverter implements AttributeConverter<Email, String>{
    @Override
    public String convertToDatabaseColumn(Email email) {
        if(email == null){
            return null;
        }
        return email.getValor();
    }

    @Override
    public Email convertToEntityAttribute(String data) {
        return new Email(data);
    }
}
