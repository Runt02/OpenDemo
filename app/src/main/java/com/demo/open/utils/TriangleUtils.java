package com.demo.open.utils;

import android.graphics.Point;
import android.graphics.PointF;

/**
 * 三角形算法
 * @purpose Created by Runt (qingingrunt2010@qq.com) on 2022/10/19.
 */
public class TriangleUtils {



    /************************直角三角算法*******************************/

    /**
     * 直角三角获取斜边
     * @param a 直角边长
     * @param b 直角边长
     * @return 斜边边长
     */
    public static Double getHypotenuseFromLength(double a,double b){
        return Math.sqrt(a*a+b*b);
    }

    /**
     * 直角三角形 根据角度和直角边长求斜边
     * @param degree    角度
     * @param width     直角边长
     * @return 斜边边长
     */
    public static double getHypotenuseFromDegree(double degree,double width){
        double cos = Math.cos(Math.toRadians(degree));//余弦
        return width / cos;
    }

    /**
     * 直角三角形 根据角度和斜边求直角边
     * @param degree    角度
     * @param width     斜边
     * @return 直角边长
     */
    public static double getRightSideFromDegree(double degree,double width){
        double cos = Math.cos(Math.toRadians(degree));
        return width * cos;
    }

    /**
     * 直角三角形 根据直角边和斜边求直角边
     * @param a 直角边
     * @param b 斜边
     * @return 直角边长
     */
    public static double getRightSideFromLength(double a,double b){
        return Math.sqrt(b*b - a*a);
    }



    /************************end 直角三角算法*******************************/

    /**
     * 根据 B角和C角的a边长，获取A角-C角的b边长
     * @param A
     * @param B
     * @param a
     * @return
     */
    public static double getSideFromSideAndDegree(double A,double B,double a){
        // a÷sin A == b ÷ sin B
        return a/Math.sin(Math.toRadians(A))*Math.sin(Math.toRadians(B));
    }

    /**
     * 获取对边
     * @param a 边长
     * @param b 边长
     * @param degree 角度
     * @return
     */
    public static Double getLengthOfSide(double a,double b,double degree){
        System.out.println(String.format("a:%s,b:%s,degrees:%s",a,b,degree));
        return Math.sqrt(b*b+a*a-2*a*b*Math.cos(Math.toRadians(degree)));
    }

    /**
     * 已知边长  求AC 角度
     * @param a
     * @param b
     * @param c
     * @return
     */
    public static double getDegree(double a,double b,double c){
        // 计算弧度表示的角
        double degrees = Math.acos((a*a +  b*b -c*c)/(2.0*a*b));
        // 用角度表示的角
        return  Math.toDegrees(degrees);
    }

    /**
     * 两点之间的长度
     * @param point0 坐标
     * @param point1 坐标
     * @return
     */
    public static double getLengthOfSide(PointF point0, PointF point1){

        return Math.sqrt(Math.pow((point0.x-point1.x),2)+Math.pow((point0.y-point1.y),2));

    }


    /**
     * 根据坐标 获取角度
     * @param point0  坐标
     * @param degreePoint  坐标  获取该点的角度
     * @param point2  坐标
     * @return
     */
    public static int getDegree(PointF point0, PointF degreePoint, PointF point2) {
        //向量的点乘
        double vector = (point0.x - degreePoint.x) * (point2.x - degreePoint.x) + (point0.y - degreePoint.y) * (point2.y - degreePoint.y);
        //向量的模乘
        double sqrt = Math.sqrt(
                (Math.abs((point0.x - degreePoint.x) * (point0.x - degreePoint.x)) + Math.abs((point0.y - degreePoint.y) * (point0.y - degreePoint.y)))
                        * (Math.abs((point2.x - degreePoint.x) * (point2.x - degreePoint.x)) + Math.abs((point2.y - degreePoint.y) * (point2.y - degreePoint.y)))
        );
        //反余弦计算弧度
        double radian = Math.acos(vector / sqrt);
        //弧度转角度制
        return (int) (180 * radian / Math.PI);
    }

    /**
     * 根据坐标 获取角度
     * @param pA  坐标
     * @param degreePoint  坐标  获取该点的角度
     * @param pC  坐标
     * @return
     */
    public static  double getDegree2(PointF pA, PointF degreePoint, PointF pC) {
        double a = getLengthOfSide(pA,degreePoint),b = getLengthOfSide(pC,degreePoint),c = getLengthOfSide(pA,pC);
        return getDegree(a,b,c);
    }

    /**
     * 根据角度和边长获取位置
     * @param p         起点位置
     * @param degree   角度
     * @param width     边长
     * @return  位置
     */
    public static PointF getPoint(PointF p,double degree,double width){
        int v = (int) (degree / 90);
        double d =  (degree % 90);
        double side = getRightSideFromDegree(d, width);//与中心的直角边长
        double top = getRightSideFromLength(side, width);//另一直角边
        Double x = 0.0 , y = 0.0 ;
        switch (v){
            case 0:
                x = (p.x+top);
                y = (p.y-side);
                break;
            case 1:
                x = (p.x+side);
                y = (p.y+top);
                break;
            case 2:
                x = (p.x-top);
                y = (p.y+side);
                break;
            case 3:
                x = (p.x-side);
                y = (p.y-top);
                break;
        }
        return new PointF(x.floatValue(),y.floatValue());
    }


}
