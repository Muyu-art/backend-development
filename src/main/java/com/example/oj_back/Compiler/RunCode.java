package com.example.oj_back.Compiler;

public class RunCode {
    String input;
    String output;
    String outputEx;
    public boolean Judge(String output,String outputEx)
    {
        if(output.equals(outputEx))
        {
            return true;
        }else
        {
            return false;
        }
    }
}
