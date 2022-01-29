package org.case2021.think.designpatterns.template;

/**
 * TODO
 *
 * @author <a href="mailto:hensonzhang@foxmail.com">hensonzhang</a>
 * @date 2021/05/27
 */
public class TemplateMethodAbstractClassTest {


    public static void main(String[] args) {

        TemplateMethodAbstractClass templateMethodAbstractClass = new ConcreteTemplateClassA();
        templateMethodAbstractClass.templateMethod();
    }
}
