package com.zzw;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {
        System.out.println( "Hello World!" );

        List<String> arrayList = new ArrayList<>();
//        Collection<String> strings = Collections.synchronizedCollection(list);
        List<String> synchronizedList = Collections.synchronizedList(arrayList);
        synchronizedList.add("1");

        Vector<String> vector = new Vector<>();
        vector.add("1");
    }


    
}
