package org.example.schedule.service;

import org.apache.catalina.util.ErrorPageSupport;
import org.example.schedule.dto.ScheduleRequestDto;
import org.example.schedule.dto.ScheduleResponseDto;
import org.example.schedule.entity.Schedule;
import org.example.schedule.repesitory.ScheduleRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.function.DoubleToIntFunction;

@Service
public class ScheduleServicelmpl implements ScheduleService {


    private final ScheduleRepository scheduleRepository;

    public ScheduleServicelmpl(ScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }


    @Override
    public ScheduleResponseDto saveschedule(ScheduleRequestDto requestDto) {

        Schedule schedule = new Schedule(requestDto.getName(),requestDto.getPassword(),
                requestDto.getVerifyPassword(),requestDto.getTitle(),requestDto.getContents());


        return scheduleRepository.saveschedule(schedule);
    }

    @Override
    public List<ScheduleResponseDto> findSchedules() {
        List<ScheduleResponseDto> allSchedules = scheduleRepository.findSchedules();
        return allSchedules;
    }

    @Override
    public ScheduleResponseDto findSchedulesById(Long id) {

        Schedule memoByIdOrElseThrow = scheduleRepository.findMemoByIdOrElseThrow(id);

        return new ScheduleResponseDto(memoByIdOrElseThrow);
    }

    @Override
    public ScheduleResponseDto updateSchedule(Long id, String name, Long password, Long verifyPassword, String title, String contents) {
        int updateschedule = scheduleRepository.updateSchedule(id,name,contents);

        if(updateschedule == 0){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND," 메모가 없습니다.");
        }

        Schedule memoByIdOrElseThrow = scheduleRepository.findMemoByIdOrElseThrow(id);

        return new ScheduleResponseDto(memoByIdOrElseThrow);
    }

    @Transactional
    @Override
    public ScheduleResponseDto updateemail(Long id, String name, Long password, Long verifyPassword, String title, String contents,String email) {

        if(name != null || password != null || verifyPassword != null || title != null || contents != null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"잘못 요청하였습니다.");
        }

        int scheduleemail = scheduleRepository.updateScheduleEmail(id,email);
        // 이메일 값 추가

        if(scheduleemail == 0){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND," 메모가 없습니다.");
        }

        //이메일 값 추가 후 출력

        Schedule memoByIdOrElseThrow = scheduleRepository.findMemoByIdOrElseThrow(id);

        return new ScheduleResponseDto(memoByIdOrElseThrow);

    }

    @Override
    public void deleteSchedule(Long id) {
        int daletedRow = scheduleRepository.deleteSchedule(id);

        if(daletedRow == 0){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND," 메모가 없습니다.");
        }
    }//고유식별자로 조회하여서 삭제한다.(이유 식별자 하위에 모든 값이 있기에 아이디 삭제시  다 삭제된다. (파일과 같음)
}
