package com.onurkus.fourthhomework.converter;

import com.onurkus.fourthhomework.dto.receiptdto.ReceiptDto;
import com.onurkus.fourthhomework.dto.receiptdto.ReceiptUserDto;
import com.onurkus.fourthhomework.entity.Receipt;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ReceiptMapper {

    ReceiptMapper INSTANCE = Mappers.getMapper(ReceiptMapper.class);

    List<ReceiptDto> convertToReceiptDtoList(List<Receipt> receipt);

    List<ReceiptUserDto> convertToReceiptUserDtoList(List<Receipt> receipt);
}
