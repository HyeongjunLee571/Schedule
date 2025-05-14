package org.example.schedule.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Pagelnfo {

    private int page;
    private int size;
    private Long totalElements;
    private int totalPages;

}
