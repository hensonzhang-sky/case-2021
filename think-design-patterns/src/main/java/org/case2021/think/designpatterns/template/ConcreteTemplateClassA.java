package org.case2021.think.designpatterns.template;

/**
 * 模版A，必须要实现方法a,b
 *
 * @author <a href="mailto:hensonzhang@foxmail.com">hensonzhang</a>
 * @date 2021/05/27
 */
public class ConcreteTemplateClassA extends TemplateMethodAbstractClass{
    @Override
    protected void methodA() {
        System.out.println("ConcreteTemplateClassA#methodA");
    }

    @Override
    protected void methodB() {
        System.out.println("ConcreteTemplateClassA#methodB");
    }


    public static void main(String[] args) {

    }
}
