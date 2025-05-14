package org.example.schedule.controoller;

import org.example.schedule.Exception.PricelessException;
import org.example.schedule.dto.ScheduleRequestDto;
import org.example.schedule.dto.ScheduleResponseDto;
import org.example.schedule.service.ScheduleService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Validator;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/schedule")
public class ScheduleControoller {

    private final ScheduleService scheduleService;
    private final Validator mvcValidator;


    public ScheduleControoller(ScheduleService scheduleService, Validator mvcValidator) {
        this.scheduleService = scheduleService;
        this.mvcValidator = mvcValidator;
    }

    @PostMapping
    public ResponseEntity<ScheduleResponseDto> createschedule
            (@RequestBody ScheduleRequestDto requestDto){
        return new ResponseEntity<>(scheduleService.saveschedule(requestDto), HttpStatus.OK);
    }

    @GetMapping
    public List<ScheduleResponseDto> findSchedules(){
        return scheduleService.findSchedules();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> findMemoById(@PathVariable Long id){
        return new ResponseEntity<>(scheduleService.findMemoById(id),HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> updateSchedule(
            @PathVariable Long id,
            @RequestBody ScheduleRequestDto responseDto
    ){
        return new ResponseEntity<>(scheduleService.updateSchedule(id,responseDto.getName(),responseDto.getPassword(),
                responseDto.getVerifyPassword(),responseDto.getTitle(),responseDto.getContents()),HttpStatus.OK);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<ScheduleResponseDto> updateemail(
            @PathVariable Long id,
            @RequestBody ScheduleRequestDto responseDto
    ){
        return new ResponseEntity<>(scheduleService.updateemail(id,responseDto.getName(),responseDto.getPassword(),
                responseDto.getVerifyPassword(),responseDto.getTitle(),responseDto.getContents(),responseDto.getEmail()),HttpStatus.OK);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long id){
        scheduleService.deleteSchedule(id);

        return new ResponseEntity<>(HttpStatus.OK);
    }

//    @ExceptionHandler(PricelessException.class)
//    public ResponseEntity<String> priceless(PricelessException e){
//        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
//    }
}
