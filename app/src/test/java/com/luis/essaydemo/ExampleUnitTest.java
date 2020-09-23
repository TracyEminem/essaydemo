package com.luis.essaydemo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    /**@test 每个方法都是一个测试用例
     * 断言
     * @throws Exception
     */
    @Test
    public void addition_isCorrect()throws Exception {
        //断言，如果相等则继续执行，不等则抛异常
        assertEquals(4,  4);
    }

    /**
     * 每个测试用例方法调用前都会执行的注解
     */
    @Before
    public void setUp(){
        System.out.println("我是每个测试用例方法调用前都会执行的注解");
    }

    /**
     * 每个测试用例方法调用后都会执行的注解
     */
    @After
    public void after(){
        System.out.println("我是每个测试用例方法调用后都会执行的注解");
    }

}