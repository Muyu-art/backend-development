package com.example.oj_back.Judge;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class JudgeTask {
    int submitId;
    int compilerId;
    int problemId;
    String source;
    int timeLimit;
    int memoryLimit;

}
