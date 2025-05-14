package org.example.schedule.repesitory;

import org.example.schedule.dto.ScheduleResponseDto;
import org.example.schedule.entity.Schedule;

import java.util.List;
import java.util.Optional;

public interface ScheduleRepository {
    ScheduleResponseDto saveschedule(Schedule schedule);

    List<ScheduleResponseDto> findSchedules();

    Optional<Schedule> findMemoById(Long password);

    Schedule saveScheduleEmail(Schedule schedule);

    int updateScheduleEmail(Long id,String email);

    int deleteSchedule(Long id);

    int updateSchedule(Long id,String name,String contents);

    Schedule findMemoByIdOrElseThrow(Long id);
}
