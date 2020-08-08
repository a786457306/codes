package com.zzw.java.base.innerClass;

/**
 * 成员内部类
 * 在另一个类的内部，与成员变量同级别。整个类都可以访问
 *
 * @author Daydreamer
 * @date 2020/8/8 22:28
 */
public class MemberOuter {

    private String outerPrivate;

    public int count = -1;

    public MemberOuter(String outer) {
        this.outerPrivate = outer;
        // 外部类要访问内部类的方法，必须创建对象
        MemberInner inner = new MemberInner();
        inner.haha();
    }

    /**
     * 成员内部类
     * 任意访问外部类的所有属性和方法，public private static 均可
     */
    class MemberInner {
        public int count = -2;
        public void haha() {
            System.out.println(outerPrivate);
            System.out.println(count);
        }
    }
}

class testMember {
    public static void main(String[] args) {
        MemberOuter outer = new MemberOuter("hi");
        System.out.println(outer.count);
        // 要访问成员内部类，必须通过外部类的对象
        MemberOuter.MemberInner inner = outer.new MemberInner();
    }
}