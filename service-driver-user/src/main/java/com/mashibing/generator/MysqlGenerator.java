package com.mashibing.generator;

/**
 * @Auther: tutu
 * @Date: 2022/8/23 - 08 - 23 - 19:57
 * @Description: com.mashibing.generator
 * @version: 1.0
 */

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

/**
 * 自动生成代码工具类
 */
public class MysqlGenerator {
    public static void main(String[] args) {
        FastAutoGenerator.create("jdbc:mysql://localhost:3306/service-driver-user?characterEncoding=utf-8&serverTimezone=GMT%2b8","root","root")
                .globalConfig(builder -> {
                    builder.author("咻咻咻").fileOverride().outputDir("G:\\study_code\\online-taxi-public\\service-driver-user\\src\\main\\java");
                })
                .packageConfig(builder -> {
                    builder.parent("com.mashibing").pathInfo(Collections.singletonMap(OutputFile.mapperXml,
                            "G:\\study_code\\online-taxi-public\\service-driver-user\\src\\main\\java\\com\\mashibing\\mapper"));
                })
                .strategyConfig(builder -> {
                    builder.addInclude("driver_car_binding_relations");
                })
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }
}
