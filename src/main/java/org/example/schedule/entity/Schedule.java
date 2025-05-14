package org.example.schedule.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.schedule.dto.ScheduleRequestDto;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@AllArgsConstructor
public class Schedule {

    private Long id;
    private String name;
    private Long password;
    private Long verifyPassword;
    private String title;
    private String contents;
    @Setter
    private String email;
    private LocalDate date = LocalDate.now();
    private LocalTime time = LocalTime.now();

    public Schedule(String name, Long password, Long verifyPassword, String title,
                    String contents){
        this.name = name;
        this.password = password;
        this.verifyPassword = verifyPassword;
        this.title = title;
        this.contents = contents;
    }

    public Schedule(Long id, String name, Long password,
                    Long verifyPassword, String title,
                    String contents, LocalDate date, LocalTime time) {

        this.id =id;
        this.name = name;
        this.password = password;
        this.verifyPassword = verifyPassword;
        this.title = title;
        this.contents = contents;
        this.date = date;
        this.time = time;
    }

    public void update(String name,Long password,Long verifyPassword,
                       String title,String contents){
        this.name = name;
        this.password = password;
        this.verifyPassword = verifyPassword;
        this.title = title;
        this.contents = contents;
    }

    public void updateemail(String email){
        this.email = email;
    }
}
