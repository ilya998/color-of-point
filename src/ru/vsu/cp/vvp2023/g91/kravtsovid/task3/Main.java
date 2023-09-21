package ru.vsu.cp.vvp2023.g91.kravtsovid.task3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static final Line L1 = new Line(-2, -2, 3.0 / 5);
    public static final Line L2 = new Line(-1, -3, 3.0 / 5);
    public static final Parabola P1 = new Parabola(-3, 2, 1.0 / 2);
    public static final Parabola P2 = new Parabola(-5, -6, 1.0 / 2);
    public static final Parabola P3 = new Parabola(-1, 4, 1.0 / 8);

    public static void inpt(Scanner scn) {
        try {
            global.temp = scn.nextDouble();
            if (!(-10.0 < global.temp && global.temp < 10.0)) {
                System.out.println("Число выходит за допустимый предел. Пожалуйста вводите только числа от -10 до 10");
            } else {
                global.a = false;
            }
        } catch (InputMismatchException e) {
            String err = scn.next();
            System.out.println('"' + err + '"' + " не является допустимым значением, пожалуйста вводите только числа от -10 до 10!");
        }
    }

    public static SimpleColor getColor(double x, double y) {
        System.out.printf("(" + x + ", " + y + ") -> ");
        if (L1.isPointAboveLine(x, y)) {
            if (P1.isPointRightOfParabola(x, y)) {
                if (P3.isPointRightOfParabola(x, y)) {
                    return SimpleColor.YELLOW;
                } else {
                    return SimpleColor.BLUE;
                }
            } else if (P3.isPointRightOfParabola(x, y)) {
                return SimpleColor.GRAY;
            } else {
                return SimpleColor.WHITE;
            }
        } else {
            if (L2.isPointAboveLine(x, y)) {
                if (P2.isPointRightOfParabola(x, y)) {
                    return SimpleColor.YELLOW;
                } else {
                    if (P1.isPointRightOfParabola(x, y) && !P3.isPointRightOfParabola(x, y)) {
                        return SimpleColor.YELLOW;
                    } else {
                        return SimpleColor.WHITE;
                    }
                }
            } else {
                if (P1.isPointRightOfParabola(x, y)) {
                    if (P2.isPointRightOfParabola(x, y)) {
                        return SimpleColor.YELLOW;
                    } else {
                        return SimpleColor.ORANGE;
                    }
                } else {
                    return SimpleColor.WHITE;
                }
            }
        }
    }

    public static void printColorForPoint(double x, double y) {
        System.out.println(getColor(x, y));
    }

    public static void main(String[] args) {
        double x = 0, y = 0;
        System.out.println(getColor(1, 1));
        System.out.println(getColor(-1, 1));
        System.out.println(getColor(5, 1));
        System.out.println(getColor(9, 9));
        System.out.println(getColor(8, 1));
        Scanner scan = new Scanner(System.in);
        while (global.a) {
            System.out.print("Input X: ");
            inpt(scan);
            x = global.temp;
        }
        Scanner scan1 = new Scanner(System.in);
        global.a = true;
        while (global.a) {
            System.out.print("Input Y: ");
            inpt(scan1);
            y = global.temp;
        }
        printColorForPoint(x, y);
    }
}
