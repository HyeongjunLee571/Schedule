package org.example.schedule.service;

import org.example.schedule.dto.ScheduleRequestDto;
import org.example.schedule.dto.ScheduleResponseDto;

import java.util.List;

public interface ScheduleService {

    ScheduleResponseDto saveschedule (ScheduleRequestDto scheduleRequestDto);

    List<ScheduleResponseDto> findSchedules();

    ScheduleResponseDto findSchedulesById(Long id);

    ScheduleResponseDto updateSchedule(Long id, String name, Long password, Long verifyPassword, String title, String contents);

    ScheduleResponseDto updateemail(Long id, String name, Long password, Long verifyPassword, String title, String contents,String email);

    void deleteSchedule(Long id);

    //Page<Member> findMemBers(int , int );

    //Pagelnfo<MultiResponseDto<T>>


}
