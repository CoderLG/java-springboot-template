package lg.controller;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.io.File;

/**
 * author: LG
 * date: 2019-09-25 15:27
 * desc:
 */
@Slf4j
public class SpringTest {
    @Test
    public void test() {

        File dir = new File("C:\\burning\\study-videos\\test");
        File[] files = dir.listFiles();
        for (File file : files) {
            System.out.println(file.getName());
        }

    }

}