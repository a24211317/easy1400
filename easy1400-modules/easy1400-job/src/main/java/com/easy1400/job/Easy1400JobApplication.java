package com.easy1400.job;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.easy1400.common.security.annotation.EnableCustomConfig;
import com.easy1400.common.security.annotation.EnableRyFeignClients;
import com.easy1400.common.swagger.annotation.EnableCustomSwagger2;

/**
 * 定时任务
 * 
 * @author easy1400
 */
@EnableCustomConfig
@EnableCustomSwagger2
@EnableRyFeignClients   
@SpringBootApplication
public class Easy1400JobApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(Easy1400JobApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  定时任务模块启动成功   ლ(´ڡ`ლ)ﾞ  \n" +
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
