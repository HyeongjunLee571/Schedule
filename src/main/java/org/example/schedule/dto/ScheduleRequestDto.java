package org.example.schedule.dto;

import lombok.Getter;

@Getter
public class ScheduleRequestDto {
    private String name;
    private Long password;
    private Long verifyPassword;
    private String title;
    private String contents;
    private String email;
}
