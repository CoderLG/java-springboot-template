package lg.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.DefaultResponseErrorHandler;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

	@Bean(name="restTemplate")
    public RestTemplate restTemplate(){
    	
    	RestTemplate restTemplate = new RestTemplate();
    	
    	restTemplate.setErrorHandler(new DefaultResponseErrorHandler() {
    	    @Override
			protected boolean hasError(HttpStatus statusCode) {
				if(statusCode.is5xxServerError())
					return false;
				return (statusCode.series() == HttpStatus.Series.CLIENT_ERROR ||
						statusCode.series() == HttpStatus.Series.SERVER_ERROR);
			}
		});
        return restTemplate;
    }

//    @Bean(name="loadBalanced")
//	@LoadBalanced
//    RestTemplate loadBalanced() {
//		return new RestTemplate();
//	}

    
}
