package com.demo.open;

import android.graphics.PointF;

import com.demo.open.utils.TriangleUtils;

import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 三角算法函数测试类
 * @purpose Created by Runt (qingingrunt2010@qq.com) on 2022/10/19.
 */
public class TriangleUnitTest {

    @Test
    public void test(){
        PointF pA = new PointF(0f,11f),pB = new PointF(11,30),pC = new PointF(30,30);
        double a = TriangleUtils.getLengthOfSide(pA,pB),b = TriangleUtils.getLengthOfSide(pC,pB),c = TriangleUtils.getLengthOfSide(pA,pC);
        System.out.println(String.format(" "+(1.265%1)));
        System.out.println(String.format("边长 a:%s,b:%s,c:%s",a,b,c));
        System.out.println(String.format("角度 坐标计算：a:%s,b:%s,c:%s",TriangleUtils.getDegree(pA,pB,pC),TriangleUtils.getDegree(pB,pC,pA),TriangleUtils.getDegree(pC,pA,pB)));
        System.out.println(String.format("角度 转换为边长计算：a:%s,b:%s,c:%s",TriangleUtils.getDegree2(pA,pB,pC),TriangleUtils.getDegree2(pB,pC,pA),TriangleUtils.getDegree2(pC,pA,pB)));
        System.out.println(String.format("角度 边长计算：a:%s,b:%s,c:%s",TriangleUtils.getDegree(a,b,c),TriangleUtils.getDegree(b,c,a),TriangleUtils.getDegree(c,a,b)));
        System.out.println("边长 c1："+TriangleUtils.getHypotenuseFromLength(a,b ));
        System.out.println("边长 c2："+TriangleUtils.getLengthOfSide(a,b ,TriangleUtils.getDegree2(pA,pB,pC)));
        System.out.println("斜边 c3："+TriangleUtils.getHypotenuseFromDegree(32.14   ,859.5));
        System.out.println("边长 c4："+TriangleUtils.getSideFromSideAndDegree(64.28  ,57.86,1080));
        System.out.format("%s 度的余弦值为 %s", Math.toRadians(90), Math.cos(Math.toRadians(90)));
        float af = 256000;
        System.out.println("float："+(5.3385005E-4/Float.MAX_VALUE)+" "+af);
        System.out.println("float："+((double)(7.693485E-12/0.64103067))+" "+(7.693485E-12>0.64103067)+String.format(" %.2f",(7.693485E-12/0.64103067)));
    }

    @Test
    public void printLoadingRight(){
        List<String> sts = new ArrayList<>();
        List<String> animates = new ArrayList<>();
        int rate = 50;
        for(int i = 0 ; i < rate ; i ++ ){
            double deg = 360.0 / rate * i %360;
            PointF doubles = TriangleUtils.getPoint(new PointF(10, 10), deg, 7);
            System.out.println("位置 index："+i+" deg="+deg+" x="+String.format("%.2f",(doubles.x))+" y="+String.format("%.2f",(doubles.y)));
            String position = String.format("%.2f",(doubles.x))+","+String.format("%.2f",(doubles.y));
            if(deg >135 && deg < 315){
                double deg2 = (deg-135)*1.8;
                if(deg2 >= deg){
                    sts.add("<string name=\"loading_right"+i+"\">M"+position+" A7,7 0 0 1 "+position+"</string>");
                }else {
                    PointF doubles2 = TriangleUtils.getPoint(new PointF(10, 10), deg2, 7);
                    //System.out.println("角度："+String.format("%.2f",deg2)+" 位置："+String.format("%.2f",doubles2[0])+","+String.format("%.2f",doubles2[1]));
                    String position2 = String.format("%.2f",(doubles2.x))+","+String.format("%.2f",(doubles2.y));
                    sts.add("<string name=\"loading_right"+i+"\">M"+((deg>90?position2:"10,3"))+" A7,7 0 0 1 "+position+"</string>");
                }
            }else if(deg <=135 ){
                sts.add("<string name=\"loading_right"+i+"\">M10,3 A7,7 0 0 1 "+position+"</string>");
            }else if(deg >= 315){
                sts.add("<string name=\"loading_right"+i+"\">M"+position+" A7,7 0 0 1 "+position+"</string>");
            }else {
                sts.add("<string name=\"loading_right"+i+"\">M"+position+" A7,7 0 0 1 "+position+"</string>");
            }
            animates.add("<objectAnimator\n" +
                    "        android:duration=\"20\"\n" +
                    "        android:startOffset=\""+(20*i)+"\"\n" +
                    "        android:propertyName=\"pathData\"\n" +
                    "        android:valueFrom=\"@string/loading_right"+i+"\"\n" +
                    "        android:valueTo=\"@string/loading_right"+(i+1)+"\"\n" +
                    "        android:valueType=\"pathType\"\n" +
                    "        android:repeatMode=\"restart\"\n" +
                    "        android:repeatCount=\"1\"/>");
        }
        for (String s : sts ) {
            System.out.println(s);
        }
    }

    @Test
    public void printAnimate(){
        for (int i = 0; i < 50; i++) {
            System.err.println("<item\n" +
                    "        android:drawable=\"@drawable/vector_circle_"+i+"\"\n" +
                    "        android:duration=\"20\" />\n");
        }
    }

    /**
     * 创建drawable 提供帧动画的视图
     */
    @Test
    public void generateDrawables(){
        for (int i = 0; i < 50; i++) {
            StringBuilder sbContent = new StringBuilder();
            sbContent.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n" +
                    "<vector xmlns:android=\"http://schemas.android.com/apk/res/android\"\n" +
                    "    android:width=\"51dp\"\n" +
                    "    android:height=\"51dp\"\n" +
                    "    android:viewportHeight=\"51\"\n" +
                    "    android:viewportWidth=\"51\">\n" +
                    "\n" +
                    "    <path\n" +
                    "        android:name=\"circle\"\n" +
                    "        android:pathData=\"@string/loading_"+i+"\"\n" +
                    "        android:strokeAlpha=\"1\"\n" +
                    "        android:strokeColor=\"@color/teal_200\"\n" +
                    "        android:strokeLineCap=\"round\"\n" +
                    "        android:strokeWidth=\"2\"/>\n" +
                    "</vector>");
            createFile("F:/drawabls/vector_circle_"+i+".xml",sbContent.toString());
        }
    }

    /**
     * 创建文件
     * @param fileName  文件名称
     * @param content   文件内容
     */
    private void createFile(String fileName,String content){
        try{
            File file =new File(fileName);
            if(!file.exists()){
                File parentFile = file.getParentFile();
                if(!parentFile.exists()){
                    parentFile.mkdirs();
                }
                file.createNewFile();
            }
            //使用true，即进行append file
            FileWriter fileWritter = new FileWriter(fileName,true);
            BufferedWriter bw = new BufferedWriter(fileWritter);
            bw.write(content);
            bw.close();
            System.out.println("finish "+fileName);
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}
