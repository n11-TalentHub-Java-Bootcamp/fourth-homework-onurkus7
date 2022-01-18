package com.onurkus.fourthhomework.controller;

import com.onurkus.fourthhomework.converter.DebtMapper;
import com.onurkus.fourthhomework.dto.debtdto.DebtDto;
import com.onurkus.fourthhomework.dto.debtdto.DebtSaveDto;
import com.onurkus.fourthhomework.dto.debtdto.DebtUserDto;
import com.onurkus.fourthhomework.entity.Debt;
import com.onurkus.fourthhomework.service.DebtService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("app/debts")
@AllArgsConstructor
public class DebtController {

    private DebtService debtService;

    @PostMapping("/save-debt")
    public ResponseEntity saveDebt(@RequestBody DebtSaveDto debtSaveDto)
    {
        debtSaveDto.setDebtType("Normally Debt");
        debtSaveDto.setRelationDebtType(0L);    //relationDebtType=0 -> Normally Debt

        debtSaveDto.setMaturityDate(debtService.calcMaturityDate(debtSaveDto.getCreatedDate()));

        debtSaveDto.setLastDebtAmount(debtSaveDto.getMainDebtAmount());

        DebtDto debtDto= debtService.save(debtSaveDto);
        return ResponseEntity.ok(debtDto);
    }

    @GetMapping("/created-date-list")
    public ResponseEntity getDebtByCreatedDate
            (@RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS") Date startDate,
             @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss.SSS") Date endDate) {

        List<DebtDto> debtDtoList =debtService.findByCreatedDateBetween(startDate,endDate);

        return ResponseEntity.ok(debtDtoList);
    }

    @GetMapping("/user-debts/{userId}")
    public List<DebtUserDto> getDebtByUserId(@PathVariable Long userId) {

        List<DebtUserDto> debtUserDto=debtService.findDebtByUserId(userId);

        return debtUserDto;
    }

    @GetMapping("/overdue-debts/{userId}")
    public List<DebtUserDto> getOverdueDebtByUserId(@PathVariable Long userId) {

        List<DebtUserDto> debtUserDto=debtService.findOverdueDebtByUserId(userId);

        return debtUserDto;
    }


}
