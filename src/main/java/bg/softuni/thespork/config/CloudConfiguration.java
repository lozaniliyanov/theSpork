package bg.softuni.thespork.config;


import com.cloudinary.Cloudinary;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class CloudConfiguration {

    @Value("${cloudinary.cloud-name}")
    private String cloudName;
    @Value("${cloudinary.api-key}")
    private String apiKey;
    @Value("${cloudinary.api-secret}")
    private String apiSecret;

    @Bean
    public Cloudinary createCloudinaryConfiguration() {

        Map<String, Object> config = new HashMap<>();
        config.put("cloud-name", cloudName);
        config.put("api-key", apiKey);
        config.put("api-secret", apiSecret);
        return new Cloudinary();
    }
}
