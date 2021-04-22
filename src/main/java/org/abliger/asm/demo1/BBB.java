package org.abliger.asm.demo1;

import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashMap;

/**
 * 对应dump()方法
 */
@Target("unchecked")
public class BBB extends HashMap<String,String> implements Serializable {

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }
    public BBB(){
    }
    public BBB(String aaa){
        this.str=aaa;
    }
    @Target("unchecked")
    public String str;
    public void print(){
        System.out.println("test");
    }

}