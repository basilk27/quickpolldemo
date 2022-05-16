package com.mbsystems.quickpolldemo.entities;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

@Converter( autoApply = true )
public class AdminConverter implements AttributeConverter<Admin, String> {
    @Override
    public String convertToDatabaseColumn(Admin admin) {
        return (admin == null) ? null : admin.getType();
    }

    @Override
    public Admin convertToEntityAttribute(String type) {
        if (type == null) {
            return null;
        }

        return Stream.of( Admin.values() )
                .filter( c -> c.getType().equals(type) )
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
