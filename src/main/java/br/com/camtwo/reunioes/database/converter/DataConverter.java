package br.com.camtwo.reunioes.database.converter;

import br.com.camtwo.reunioes.model.basic.Data;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Date;

/**
 * Created by vitor on 28/01/16.
 */
@Converter(autoApply = true)
public class DataConverter implements AttributeConverter<Data, Date>{
    @Override
    public Date convertToDatabaseColumn(Data date) {
        if(date == null){
            return null;
        }
        return Date.valueOf(date.getValor());
    }

    @Override
    public Data convertToEntityAttribute(Date data) {
        if(data==null) {
            return null;
        }
        return new Data(data.toLocalDate());
    }
}
