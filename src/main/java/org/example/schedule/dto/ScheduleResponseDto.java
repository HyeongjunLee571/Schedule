package org.example.schedule.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.schedule.entity.Schedule;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@AllArgsConstructor
public class ScheduleResponseDto {

    private Long id;
    private String name;
    private Long password;
    private Long verifyPassword;
    private String title;
    private String contents;
    private String email = null;
    private LocalDate date;
    private LocalTime time;

    public ScheduleResponseDto(Schedule schedule){
        this.id = schedule.getId();
        this.name = schedule.getName();
        this.password = schedule.getPassword();
        this.verifyPassword = schedule.getVerifyPassword();
        this.title = schedule.getTitle();
        this.contents = schedule.getContents();
        this.date = schedule.getDate();
        this.email = schedule.getEmail();
        this.time = schedule.getTime();
    }

    public ScheduleResponseDto(Long id, String name, Long password,
                               Long verifyPassword, String title,
                               String contents, LocalDate date, LocalTime time) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.verifyPassword = verifyPassword;
        this.title = title;
        this.contents = contents;
        this.date = date;
        this.time = time;
    }
}
