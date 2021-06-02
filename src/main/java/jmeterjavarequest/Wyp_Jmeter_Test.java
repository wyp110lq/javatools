package jmeterjavarequest;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

public class Wyp_Jmeter_Test implements JavaSamplerClient {
    private String variable;
    private String filename;
    //main主方法主要是用来本地调试，用来测试封装的Java方法是否功能正常，如果能实现正常功能，就可以进行编译、打包在Jmeter中进行调用
    public static void main(String[] args){

        Arguments parames = new Arguments();
        parames.addArgument("filename","D:\\main.txt");
        parames.addArgument("variable","2018");
        JavaSamplerContext arg0 = new JavaSamplerContext(parames);
        Wyp_Jmeter_Test test = new Wyp_Jmeter_Test();
        test.setupTest(arg0);
        test.runTest(arg0);
        test.teardownTest(arg0);
    }
    //setupTest方法为初始化方法，实际运行时每个线程仅执行一次，在测试方法运行前执行，默认置空即可
    @Override
    public void setupTest(JavaSamplerContext context) {

    }
    //runTest方法为测试方法，该方法用来传入输入的参数，然后调用参数类，进行测试
    public SampleResult runTest(JavaSamplerContext arg0) {
        SampleResult results = new SampleResult();
        variable = arg0.getParameter("variable");
        filename = arg0.getParameter("filename");
        results.sampleStart();
        try{
            Export test = new Export();
            Export.output(filename,variable);
            results.setSuccessful(true);
        }catch (Throwable e){
            results.setSuccessful(false);
            e.printStackTrace();
        }finally {
            results.sampleEnd();
        }
        return results;
    }
    @Override
    //teardownTest方法为结束方法，实际运行时每个线程仅执行一次，在测试方法结束后执行，默认置空即可
    public void teardownTest(JavaSamplerContext context) {

    }
    @Override
    //设置传入的参数，可以设置多个，已设置的参数会显示在jmeter的参数列表中
    public Arguments getDefaultParameters() {
        Arguments params = new Arguments();
        params.addArgument("filename","D:\\getDefault.txt"); //设置参数，并赋默认值
        params.addArgument("variable","2019");
        return params;
    }
}
