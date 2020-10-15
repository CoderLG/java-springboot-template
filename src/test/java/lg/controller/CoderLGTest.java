package lg.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

/**
 * author: LG
 * date: 2020-06-18 10:09
 * desc:
 */
//@SpringBootTest
//@RunWith(SpringRunner.class)
//@Slf4j
public class CoderLGTest {


    @Test
    public void test3(){

        List<String> strings = new ArrayList<>();
        strings.add("a");
        strings.set(0, "ss");
        System.out.println(strings.get(0));
//        System.out.println(strings.get(0));

    }


    @Test
    public void test2(){
        File file = new File("D:\\tmp");
        String[] list = file.list();
        for (String s : list) {
            if(s.endsWith(".tiff"))
                System.out.println(s);
        }

    }

    @Test
    public void test(){
        File file = new File("/home/dir/testFile.meta.xml");
        System.out.println(file.getName());
        System.out.println(file.getName().substring(0,file.getName().indexOf(".") ));
        System.out.println(file.getName().length());
        System.out.println(file.getName().indexOf("."));
        System.out.println(file.getName().substring(file.getName().indexOf(".") + 1));
        System.out.println("testFile.meta.xml".substring(3,4));

    }


}
