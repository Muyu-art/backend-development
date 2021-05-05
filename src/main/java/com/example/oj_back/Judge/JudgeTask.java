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
    int questionId;//问题id
    int languageId;//语言类型
    String code;//代码
    int usecaseNum;//用例数量
    int timeLimit;//时间限制
    int memoryLimit;//内存限制
}
