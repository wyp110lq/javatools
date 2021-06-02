package jmeterjavarequest;

import org.apache.jmeter.config.Arguments;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerClient;
import org.apache.jmeter.protocol.java.sampler.JavaSamplerContext;
import org.apache.jmeter.samplers.SampleResult;

public class Yss_Jmeter_Test implements JavaSamplerClient {
    private String variable;
    private String filename;
    public static void main(String[] args){

        Arguments parames = new Arguments();
        parames.addArgument("filename","D:\\main.txt");
        parames.addArgument("variable","2018");
        JavaSamplerContext arg0 = new JavaSamplerContext(parames);
        Yss_Jmeter_Test test = new Yss_Jmeter_Test();
        test.setupTest(arg0);
        test.runTest(arg0);
        test.teardownTest(arg0);
    }
    @Override
    public void setupTest(JavaSamplerContext context) {

    }

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
