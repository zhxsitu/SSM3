package com.zhx.test;

import org.mybatis.generator.api.ShellRunner;

/**
 * @version 1.0
 * @Author 郑煌兴
 * @注释
 */
public class MBGTest {
    public static void main(String[] args) {
        String config = MBGTest.class.getClassLoader()
                .getResource("generatorConfig.xml").getFile();
        String[] arg = {"-configfile", config, "-overwrite"};
        ShellRunner.main(arg);
    }

}
