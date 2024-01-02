package org.harvestdiaryserver.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Diary {
    private String userId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate time;

    private String color;
    private String fontSize;
    private String title;
    private String content;
}
