package com.test.test;
/**
 * @author Liuyuxiao
 * @version 1.0
 * @description: TODO
 * @date 2022/3/9 11:24
 */
public class Test {
//    private static String KHGL_Number = "ER-";
    private static int i=0;
    public static void main(String[] args) {
//       Test test=new Test();
//        System.out.println(KHGL_Number());
        String a=KHGL_Number();
        System.out.println(a);
        String b=KHGL_Number();
        System.out.println(b);
        String c=KHGL_Number();
        System.out.println(c);
    }
    public static String KHGL_Number() {
        i++;
        String KHGL_Number = "ER-";
        String format = String.format("%05d", i);
        KHGL_Number+=format;
//	     System.out.println(KHGL_Number+format);
        return KHGL_Number;
    }
}
