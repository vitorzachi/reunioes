package br.com.camtwo.reunioes.database.converter;

import br.com.camtwo.reunioes.model.basic.DataHora;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Timestamp;

/**
 * Created by vitor on 28/01/16.
 */
@Converter(autoApply = true)
public class DataHoraConverter implements AttributeConverter<DataHora, Timestamp>{
    @Override
    public Timestamp convertToDatabaseColumn(DataHora dataHora) {
        if(dataHora == null){
            return null;
        }
        return Timestamp.valueOf(dataHora.getValor());
    }

    @Override
    public DataHora convertToEntityAttribute(Timestamp timestamp) {
        if(timestamp==null) {
            return null;
        }
        return new DataHora(timestamp.toLocalDateTime());
    }
}
