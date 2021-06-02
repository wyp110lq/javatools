package testngtest;

import org.testng.annotations.Test;

public class IgnoreTest {

    @Test(enabled=false)
    public void TestNgLearn1() {
        System.out.println("this is TestNG test case1");
    }

    @Test
    public void TestNgLearn2() {
        System.out.println("this is TestNG test case2");
    }
}

