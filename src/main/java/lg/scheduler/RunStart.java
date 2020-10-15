package lg.scheduler;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class RunStart implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("所有bean全部加载完之后，开始运行");
    }
}
