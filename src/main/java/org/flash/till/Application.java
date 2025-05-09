package org.flash.till;


import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication(scanBasePackages = {"org.flash.till"})
@MapperScan(basePackages = "org.flash.till.**.mapper")
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        log.info("##################################################");
        log.info("#                                                #");
        log.info("#  FlashTill Application Started Successfully!   #");
        log.info("#                                                #");
        log.info("##################################################");
        log.info("");
        log.info("*#-      Java Version: {} ", System.getProperty("java.version"));
        log.info("*#- Working Directory: {} ", System.getProperty("user.dir"));
        log.info("*#-  Operating System: {} ", System.getProperty("os.name"));
        log.info("");
        log.info("##################################################");
        log.info("#                                                #");
        log.info("#  Application is now running...                 #");
        log.info("#                                                #");
        log.info("##################################################");
    }
}
