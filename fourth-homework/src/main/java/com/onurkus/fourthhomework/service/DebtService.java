package com.onurkus.fourthhomework.service;

import com.onurkus.fourthhomework.converter.DebtMapper;
import com.onurkus.fourthhomework.dto.debtdto.DebtDto;
import com.onurkus.fourthhomework.dto.debtdto.DebtSaveDto;
import com.onurkus.fourthhomework.dto.debtdto.DebtUserDto;
import com.onurkus.fourthhomework.entity.Debt;
import com.onurkus.fourthhomework.service.entityservice.DebtEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class DebtService {

    private final DebtEntityService debtEntityService;

    public DebtDto save(DebtSaveDto debtSaveDto) {

        Debt debt = DebtMapper.INSTANCE.convertDebtSaveDtoToDebt(debtSaveDto);

        debt = debtEntityService.save(debt);

        DebtDto debtDto = DebtMapper.INSTANCE.convertToDebtDto(debt);

        return debtDto;
    }

    public List<DebtDto> findByCreatedDateBetween(Date start, Date end) {

        List<Debt> debtList = debtEntityService.findByCreatedDateBetween(start,end);

        List<DebtDto> debtDtoList = DebtMapper.INSTANCE.convertToDebtDtoList(debtList);
        return debtDtoList;
    }

    public List<DebtUserDto> findDebtByUserId (Long userId){

        List<Debt> debtList=debtEntityService.findDebtByUserId(userId);
        List<DebtUserDto> debtUserDto = DebtMapper.INSTANCE.convertToDebtUserDtoList(debtList);

        return debtUserDto;
    }

    public Date calcMaturityDate (Date createdDate){

        Calendar c= Calendar.getInstance();
        c.setTime(createdDate);
        c.add(Calendar.DATE,14);

        return c.getTime();
    }

}
