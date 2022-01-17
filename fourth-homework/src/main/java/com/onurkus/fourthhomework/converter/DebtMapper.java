package com.onurkus.fourthhomework.converter;

import com.onurkus.fourthhomework.dto.debtdto.DebtDto;
import com.onurkus.fourthhomework.dto.debtdto.DebtSaveDto;
import com.onurkus.fourthhomework.dto.debtdto.DebtUserDto;
import com.onurkus.fourthhomework.entity.Debt;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DebtMapper {

    DebtMapper INSTANCE = Mappers.getMapper(DebtMapper.class);

    Debt convertDebtSaveDtoToDebt(DebtSaveDto debtSaveDto);

    DebtDto convertToDebtDto(Debt debt);

    List<DebtDto> convertToDebtDtoList(List<Debt> debt);

    List<DebtUserDto> convertToDebtUserDtoList(List<Debt> debt);

}
