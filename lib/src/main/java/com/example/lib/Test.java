package com.example.lib;

/**
 * Time:2019/6/4
 * <p>
 * Author:44483
 * <p>
 * Description:
 */
public class Test {
    public static void main(String args[]) {
        LruCache cache = new LruCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println("11111 current value = " + cache.get(1));
        cache.put(3, 3);

        System.out.println("2222 current value = " + cache.get(2));
        cache.put(4, 4);
        System.out.println("1111 current value = " + cache.get(1));
        System.out.println("3333 current value = " + cache.get(3));
        System.out.println("4444 current value = " + cache.get(4));
    }
}
