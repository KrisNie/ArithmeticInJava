package com.op.inheritance;

import lombok.*;

/**
 * @Author: NZY
 * @Date: 2020/3/19 17:52
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Student extends Person {
    private String Major;

    //扩展抽象类可以有两种选择。
    //一种是在抽象类中定义部分抽象类方法或不定义抽象类方法，这样就必须将子类也标记为抽象类；
    //另一种是定义全部的抽象方法，这样一来，子类就不是抽象的。
    public String getDescription() {
        return "a student majoring in " + Major;
    }
}
