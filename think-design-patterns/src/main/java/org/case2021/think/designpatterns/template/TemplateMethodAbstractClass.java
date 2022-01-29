package org.case2021.think.designpatterns.template;


/**
 * 模版方法设计模式
 * <p>templateMethod()方式实现最基础的业务，其次会调用methodA() method()B方法来实现扩展
 * <p>继承本模版的所有实际模版都要实现自己的模版，此处只是定义不做具体实现，或者只是做基础的实现，按需调整
 * <p>作用:1、复用 2、扩展
 *
 * @see java.io.InputStream
 * @see java.io.ByteArrayInputStream
 * @see java.util.AbstractList
 * @author <a href="mailto:hensonzhang@foxmail.com">hensonzhang</a>
 * @date 2021/05/27
 */
public abstract class TemplateMethodAbstractClass {

    /**
     * 模版方法定义，使用final不允许被重写
     */
    public final void templateMethod() {
        System.out.println("TemplateMethodAbstractClass#templateMethod()，父类的基础实现");
        methodA();
        methodB();
    }

    /**
     * method a
     */
    protected abstract void methodA();

    /**
     * method b
     */
    protected abstract void methodB();

}
