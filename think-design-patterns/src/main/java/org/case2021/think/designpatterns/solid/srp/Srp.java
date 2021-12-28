package org.case2021.think.designpatterns.solid.srp;

/**
 * Single Responsibility Principle 缩写成SRP
 *
 * <ul>
 *     A class or module should have a single responsibility
 *     一个类只负责完成一个职责或功能，不要设计大而全的类，要设计粒度小，
 *     功能单一的类，换句话说一个类包含了两个或两个以上不想干的功能就
 *     说明这个类职责不够单一，应该将它拆分成多个功能单一，粒度更小的类
 * </ul>
 *
 *
 * <p>
 *     看一个类职责是否单一不能认死理，要结合实际的业务场景来看；
 *     而实际开发中可以先设计一个粗粒度的类，根据业务的演进，若类越来越庞大
 *     可以将这个类拆分成更细粒度的类，这也就是所谓的持续重构
 *     （架构演进、持续重构的前提是最好保证有完整的单测）
 * </p>
 *
 *
 * <>
 *     判断是否单一的生活小技巧：
 *     1、类的代码行数 ，函数或属性过多，影响到代码的可读性和可维护性时就需要拆分；
 *     2、私有方法过多，导致不能复用；
 *     3、不能清晰的给类一个合适的名称，很难用给一个名次概括；或者只能用笼统的Manager、Context来命名的类，说明这个类的职责不够清晰
 *     4、类中大量的方法都在操作一个属性；可以将这几个属性和对应的方法拆分到独立类
 * </>
 * @author <a href="mailto:hensonzhang@foxmail.com">hensonzhang</a>
 * @date 2021/06/04
 */
public class Srp {



}
