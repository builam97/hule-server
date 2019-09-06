package com.example.demo.reflection;

import java.io.PrintWriter;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.example.demo.entities.Users;

public class Reflection {

    public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, InstantiationException {
        // TODO Auto-generated method stub
        Testing t = new Testing("val111", false);
        Class<? extends Testing> tClass = t.getClass();

//        Method method = tClass.getClass().getDeclaredMethod("getString1");
//        method.setAccessible(true);
//        Object r = method.invoke(tClass);
        
        
        Object o= tClass.newInstance();  
        Method m =tClass.getDeclaredMethod("getString1", new Class[] {String.class});  
        m.setAccessible(true);  
        Object r1 = m.invoke(o, "val1");
        System.out.println(r1);
    }

}
