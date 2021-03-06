package com.example.oj_back.Judge;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Stdout {

    /**
     * {'status': 0, 'max_memory': 23328L, 'max_time': 207L}
     */
    private String result;
    private int timeused;
    private int memoryused;
}