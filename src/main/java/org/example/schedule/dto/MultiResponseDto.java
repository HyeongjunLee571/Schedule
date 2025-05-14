package org.example.schedule.dto;

import org.example.schedule.entity.Pagelnfo;
import org.springframework.data.domain.Page;

import javax.sound.sampled.DataLine;
import java.util.List;

public class MultiResponseDto<T> {
    private List<T> data;
    private Pagelnfo pagelnfo;

    public MultiResponseDto(List<T> data, Page page){
        this.data = data;
        this.pagelnfo = new Pagelnfo(
                page.getNumber() + 1,
                page.getSize(),
                page.getTotalElements(),
                page.getTotalPages()
        );
    }
}
