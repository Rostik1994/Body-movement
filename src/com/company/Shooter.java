package com.company;

import java.io.*;
import java.math.*;
interface Angle {
    void setAngle(double a);
}

interface Power {
    void setVelocity(double v);
}

interface Target {
    public void setTargetDistance(double s);
    void setTargetHeight(double h);
}

public class Shooter implements Angle, Power, Target {

    double  a, v0, s, h;
    public void setAngle(double a) {this.a = a;}
    public void setVelocity(double v) {this.v0 = v;}
    public void setTargetDistance(double s) {this.s = s;}
    public void setTargetHeight(double h) {this.h = h;}

    public static void main(String[] args) {

        Shooter sh = new Shooter();
        sh.setAngle(40.0);
        sh.setVelocity(20.0);
        sh.setTargetDistance(40.0);
        sh.setTargetHeight(1.0);
        double Y = sh.s * Math.tan( sh.a * Math.PI/180 ) - ( 9.8 * sh.s * sh.s ) / ( 2 * sh.v0 * sh.v0 * Math.cos( sh.a * Math.PI/180 ) * Math.cos( sh.a * Math.PI/180 ) );
        System.out.println("Наводчик: " + Y);
        if (Y < 0) System.out.println("Недолет");
        if (Y > 0 && Y <= sh.h) System.out.println("Попал!");
        if (Y > sh.h) System.out.println("Перелет");




    }
}
