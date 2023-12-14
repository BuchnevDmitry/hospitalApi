package ru.vsu.cs.buchnev.hospital.app.mapper.old;

import org.mapstruct.factory.Mappers;
import ru.vsu.cs.buchnev.hospital.api.model.response.MedicalCardResponse;
import ru.vsu.cs.buchnev.hospital.item.model.MedicalCardItem;

import java.util.List;

public interface MedicalCardMapperOld {

    MedicalCardMapperOld INSTANCE = Mappers.getMapper(MedicalCardMapperOld.class);
    MedicalCardResponse mapToDto(MedicalCardItem item);
    List<MedicalCardResponse> mapToDto(List<MedicalCardItem> items);
    List<MedicalCardItem> mapToItem(List<MedicalCardResponse> items);
    MedicalCardItem mapToItem(MedicalCardResponse dto);
}
