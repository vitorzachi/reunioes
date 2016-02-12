package br.com.camtwo.reunioes.database.converter;

import br.com.camtwo.reunioes.model.basic.Hora;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Time;

/**
 * Created by vitor on 28/01/16.
 */
@Converter(autoApply = true)
public class HoraConverter implements AttributeConverter<Hora, Time>{
    @Override
    public Time convertToDatabaseColumn(Hora hora) {
        if(hora == null){
            return null;
        }
        return Time.valueOf(hora.getValor());
    }

    @Override
    public Hora convertToEntityAttribute(Time time) {
        if(time==null) {
            return null;
        }
        return new Hora(time.toLocalTime());
    }
}
