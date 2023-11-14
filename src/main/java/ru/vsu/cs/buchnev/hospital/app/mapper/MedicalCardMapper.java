package ru.vsu.cs.buchnev.hospital.app.mapper;

import org.mapstruct.factory.Mappers;
import ru.vsu.cs.buchnev.hospital.api.model.MedicalCardDto;
import ru.vsu.cs.buchnev.hospital.item.model.MedicalCardItem;

import java.util.List;

public interface MedicalCardMapper {

    MedicalCardMapper INSTANCE = Mappers.getMapper(MedicalCardMapper.class);
    MedicalCardDto toDto(MedicalCardItem item);

    List<MedicalCardDto> toDto(List<MedicalCardItem> items);
}
