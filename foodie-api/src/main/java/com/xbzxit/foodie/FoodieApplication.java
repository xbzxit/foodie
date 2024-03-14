package com.xbzxit.foodie;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author HFZJ
 * @version 1.0
 * @create 2024-03-13-13:56
 * @company www.nuzarsurf.com
 */

@SpringBootApplication
// 扫描 mybatis 通用 mapper 所在的包
@MapperScan(basePackages = "com.xbzxit.foodie.mapper")
// 扫描所有包以及相关组件包
@ComponentScan(basePackages = {"com.xbzxit.foodie", "org.n3r.idworker"})
public class FoodieApplication {

    public static void main(String[] args) {
        SpringApplication.run(FoodieApplication.class, args);
    }

}
