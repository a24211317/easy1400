package com.easy1400.viid;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.easy1400.common.security.annotation.EnableCustomConfig;
import com.easy1400.common.security.annotation.EnableRyFeignClients;
import com.easy1400.common.swagger.annotation.EnableCustomSwagger2;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * 系统模块
 * 
 * @author easy1400
 */
@EnableCustomConfig
@EnableCustomSwagger2
@EnableRyFeignClients
@SpringBootApplication
@EnableAsync
public class Easy1400ViidApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(Easy1400ViidApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  VIID模块启动成功   ლ(´ڡ`ლ)ﾞ  \n" +
                " .-------.       ____     __        \n" +
                " |  _ _   \\      \\   \\   /  /    \n" +
                " | ( ' )  |       \\  _. /  '       \n" +
                " |(_ o _) /        _( )_ .'         \n" +
                " | (_,_).' __  ___(_ o _)'          \n" +
                " |  |\\ \\  |  ||   |(_,_)'         \n" +
                " |  | \\ `'   /|   `-'  /           \n" +
                " |  |  \\    /  \\      /           \n" +
                " ''-'   `'-'    `-..-'              ");
    }
}
