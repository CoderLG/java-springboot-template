package lg;

import com.spring4all.swagger.EnableSwagger2Doc;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * author: LG
 * date: 2019-09-02 18:39
 * desc:
 */

@Slf4j
@SpringBootApplication
@EnableSwagger2Doc
@EnableAsync
@EnableCaching
@EnableJpaAuditing
//@EnableFeignClients({ "lg.feign" })
public class APP {
    public static void main(String[] args) {
        SpringApplication.run(APP.class, args);
        log.info("服务启动");
    }
}
