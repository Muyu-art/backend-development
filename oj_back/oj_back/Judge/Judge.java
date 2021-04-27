package com.example.oj_back.Judge;

import java.io.*;

public class Judge {
    public static void judge(JudgeTask task) throws IOException {
        JudgeResult result=new JudgeResult();
        result.setSubmitId(task.getSubmitId());
        String path="";//执行路径
        File file=new File(path);//创建执行文件
        file.mkdirs();
        createFile(task.getCompilerId(),path,task.getSource());
        //

    }

    public static void createFile(int compilerId,String path,String source) throws IOException {
        String filename="";
        switch(compilerId){
            case 1:
                filename="main.c";
                break;
            case 2:
                filename="main.cpp";
                break;
            case 3:
                filename="Main.java";
                break;
            case 4:
                filename="main.pas";
            case 5:
                filename="main.py";
                break;
        }
        File file=new File(path+"/"+filename);//创建代码文件
        file.createNewFile();
        OutputStream output = new FileOutputStream(file);
        PrintWriter writer=new PrintWriter(output);
        writer.print(source);
        writer.close();
        output.close();
    }

    public static String complie
}

