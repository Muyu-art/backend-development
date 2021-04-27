package com.example.oj_back.Judge;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JudgeResult {
    int submitId;
    int status;
    int timeUsed;
    int memoryUsed;
    String erorMessage;
}
