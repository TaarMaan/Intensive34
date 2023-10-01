package ru.aston.artamonov_va.task1.task5;

import ru.aston.artamonov_va.task1.task5.Entity.Birthday;

import javax.persistence.AttributeConverter;
import java.sql.Date;
import java.util.Optional;

public class BirthdayConvector implements AttributeConverter<Birthday, Date> {
    @Override
    public Date convertToDatabaseColumn(Birthday attribute) {
        return Optional.ofNullable(attribute)
                .map(Birthday::getLocalDate)
                .map(Date::valueOf)
                .orElse(null);
    }

    @Override
    public Birthday convertToEntityAttribute(Date dbData) {
        return Optional.ofNullable(dbData)
                .map(Date::toLocalDate)
                .map(Birthday::new)
                .orElse(null);
    }
}