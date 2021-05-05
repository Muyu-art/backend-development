package com.example.oj_back.Judge;

import com.alibaba.fastjson.JSONObject;

import java.io.*;


public class Judge {
    public JudgeResult judge(JudgeTask task) throws IOException {
        //System.out.println(task.getCode());
        JudgeResult result=new JudgeResult();//判题结果
        result.setSubmitId(task.getQuestionId());//题目id
        String path="/home/workspace/code/"+task.getQuestionId();//执行路径
        File file =new File(path);
        String filename="";
        file.mkdirs();
        try {
            filename=createFile(task.getLanguageId(), path, task.getCode());//将代码文件保存到服务器的工作目录
        } catch (Exception e) {
            e.printStackTrace();
            result.setStatus("System Error");
            ExecutorUtil.exec("rm -rf " + path);//用完之后删除路径
            return result;
        }
        String message=complie(task.getLanguageId(),path);
        if(message!=null&&task.getLanguageId()!=4)
        {
            result.setStatus("Compile Error");
            result.setErorMessage(message);
            ExecutorUtil.exec("rm -rf"+path);
        }
        ExecutorUtil.exec("chmod -R 755"+path);
        String judge_data="/home/workspace/data/"+task.getQuestionId();
        String type=process(task.getLanguageId(),filename);
        String cmd="python3 "+"/home/judge/demo/test.py "+type+" "+judge_data+" "+task.getUsecaseNum()+" "+task.getTimeLimit()+" "+task.getMemoryLimit();//执行命令+输入数据+测试程序+用例数量+时间限制+内存限制
        //String cmd="python3 /home/judge/demo/test.py /home/judge/demo/a+b.c /home/workspace/data/1 1";
        System.out.println("命令为"+cmd);
        parseToResult(cmd, result);
        ExecutorUtil.exec("rm -rf " + path);
        return result;
    }

    public  String createFile(int compilerId,String path,String source) throws IOException {
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
        return path+"/"+filename;
    }

    public String complie(int compilerId,String path)//编译代码
    {
        //编译命令
        String cmd="";
        switch(compilerId){
            case 1:
                cmd="gcc "+path+"/main.c -o "+path+"/main";
                break;
            case 2:
                cmd="g++ "+path+"/main.cpp -o "+path+"/main";
                break;
            case 3:
                cmd="javac "+path+"/Main.java";
                break;
            case 4:
                cmd="python3 -m py_compile "+path+"/main.py";
                break;
        }
        //System.out.println("compile success");
        return ExecutorUtil.exec(cmd).getError();
    }
    private static String process(int compileId,String path) {
        switch (compileId) {
            case 1:
            case 2:
                return path;
            case 3:
                return "javajh"+path;
            case 4:
                return "python3jh"+path;
        }
        return null;
    }

    private void parseToResult(String cmd, JudgeResult result) {
        ExecMessage exec = ExecutorUtil.exec(cmd);
        if (exec.getError() != null) {
            //System.out.println("hello");
            result.setStatus("Error");
            result.setErorMessage(exec.getError());
        } else {
            //System.out.println("HI");
            Stdout out = JSONObject.parseObject(exec.getStdout(), Stdout.class);
            result.setStatus(out.getResult());
            result.setTimeUsed(out.getTimeused());
            result.setMemoryUsed(out.getMemoryused());
        }
    }
}

