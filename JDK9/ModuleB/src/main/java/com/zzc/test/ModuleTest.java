package com.zzc.test;

import com.zzc.model.Person;
import com.zzc.utils.ArrayUtils;

public class ModuleTest {

    public static void main(String[] args) {
        int[] arr = {10, 25, 6, 23, 58, 98, 24, 35, 66, 87, 92};
        int max = ArrayUtils.getMax(arr);
        System.out.println("max = " + max);

        Person person = new Person(1001, "zczhao");
        System.out.println(person);
    }
}
