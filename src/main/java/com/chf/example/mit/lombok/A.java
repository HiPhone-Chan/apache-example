package com.chf.example.mit.lombok;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.val;
import lombok.extern.log4j.Log4j2;

@Data
@AllArgsConstructor
@Log4j2
public class A {

    private int a;

    private String str;

    public void check(@NonNull String str) {
        log.error("hi~");
        this.str = str;
    }

    public static void main(String[] args) {
        val a = new A(1, "1");
        a.setA(123);
        a.setStr("2");
        System.out.println(a);
    }
}
