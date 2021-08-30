/*
 * Copyright 2002-2018 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.beans.factory;

/**
 * A marker superinterface indicating that a bean is eligible to be notified by the
 * Spring container of a particular framework object through a callback-style method.
 * The actual method signature is determined by individual subinterfaces but should
 * typically consist of just one void-returning method that accepts a single argument.
 * <p>这个接口是一个标志接口，代表当特定对象加载是能够以回调的方式别通知到。
 * <p>其实际的方法签名是由独立的子接口去实现的，但一般是一个接受单个参数，返回 void 的方法。
 *
 * <p>Note that merely implementing {@link Aware} provides no default functionality.
 * Rather, processing must be done explicitly, for example in a
 * {@link org.springframework.beans.factory.config.BeanPostProcessor}.
 * Refer to {@link org.springframework.context.support.ApplicationContextAwareProcessor}
 * for an example of processing specific {@code *Aware} interface callbacks.
 * <p>仅实现该接口不会提供任何默认的功能，需要像 BeanPostProcessor 那样实现自己的功能或操作。
 * <p>Aware 的含义是意识、感知、发觉，一般来说是感知某种动作来进行回调，比如：
 * <ul>
 * <li>
 *     {@link BeanClassLoaderAware#setBeanClassLoader}：
 *     实现该接口的 bean 在设置 BeanClassLoader 的时候能够感知到该操作，并且回调其自身实现的 setBeanClassLoader 方法。
 * </li>
 * <li>
 *     {@link BeanNameAware#setBeanName}：
 *     实现该接口的 bean 在设置 beanName 的时候能够感知到该操作，并且回调其自身实现的 setBeanName 方法。
 * </li>
 * <li>
 *     {@link BeanFactoryAware#setBeanFactory}：
 *     实现该接口的 bean 在设置 BeanFactory 的时候能够感知到该操作，并且回调其自身实现的 setBeanFactory 方法。
 * </li>
 * </ul>
 *
 * <ul><p><b>常用的 Aware 接口：</b>
 * <li>LoadTimeWeaverAware：加载Spring Bean时织入第三方模块，如AspectJ
 * <li>BeanClassLoaderAware：加载Spring Bean的类加载器
 * <li>BootstrapContextAware：资源适配器BootstrapContext，如JCA,CCI
 * <li>ResourceLoaderAware：底层访问资源的加载器
 * <li>BeanFactoryAware：声明BeanFactory
 * <li>PortletConfigAware：PortletConfig
 * <li>PortletContextAware：PortletContext
 * <li>ServletConfigAware：ServletConfig
 * <li>ServletContextAware：ServletContext
 * <li>MessageSourceAware：国际化
 * <li>ApplicationEventPublisherAware：应用事件
 * <li>NotificationPublisherAware：JMX通知
 * <li>BeanNameAware：声明Spring Bean的名字
 * </ul>
 * </p>
 * @author Chris Beams
 * @author Juergen Hoeller
 * @since 3.1
 */
public interface Aware {

}
