package lg.scheduler;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * author: LG
 * date: 2019-12-05 10:57
 * desc:
 */

@Component
@Slf4j
public class StartupRunner implements CommandLineRunner {


    /**
     * 当所有的bean都初始化完成之后开始执行此方法
     *
     * @param args
     * @throws Exception
     */
    @Override
    public void run(String... args) throws Exception {
        log.info("所有bean加载完之后，开始运行");

    }
}
