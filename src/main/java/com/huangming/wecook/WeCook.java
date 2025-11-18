package com.huangming.wecook;

import com.huangming.wecook.dataclass.Message;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WeCook {

    public static void main(String[] args) {
        SpringApplication.run(WeCook.class,args);
        Message test1=new Message("This is test1 from Spring","assistant");

    }

}
