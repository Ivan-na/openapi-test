package com.fenbeitong.openapitest.comms;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.format.annotation.DateTimeFormat;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.*;

/**
 * ValueHelper
 * <p> TODO
 *
 * @author ivan
 * @version 1.0
 * Created by ivan on 18-11-21 - 下午7:26.
 **/
public class ValueHelper {
    private static final Logger LOGGER = LoggerFactory.getLogger(ValueHelper.class);
    private static final String REFLECT = "ValueHelper : Reflect Exception";
    private static final String INSTROSPECTION = "ValueHelper : Introspection Exception";

    private ValueHelper() {

    }

    /**
     * 将List中bean的属性及属性值转化为Map对象
     *
     * @param list
     * @param ignoreProperties
     * @return
     */
    public static <T> List<Map<String, String>> tranList2MapList(List<T> list, String[] ignoreProperties) {
        List<Map<String, String>> resultList = new ArrayList<Map<String, String>>(list.size());
        for (Object bean : list) {
            resultList.add(transBean2Map(bean, null, ignoreProperties));
        }
        return resultList;
    }

    /**
     * 将bean中的属性及属性值转化为Map对象，支持自定义前缀，<属性，属性值>.
     *
     * @param bean             需要转换的bean
     * @param map              存放转换后的map,若传入null则返回一个新的map
     * @param ignoreProperties 需要忽略的属性名
     * @return Map<String       ,       Object>
     */
    public static Map<String, String> transBean2Map(Object bean, Map<String, String> map, String[] ignoreProperties) {
        return transBean2Map(bean, map, ignoreProperties, null, false);
    }

    /**
     * 将bean中的属性及属性值转化为Map对象，支持自定义前缀，<prefix+属性，属性值>
     *
     * @param bean             需要转换的bean
     * @param map              存放转换后的map,若传入null则返回一个新的map
     * @param ignoreProperties 需要忽略的属性名
     * @param keyPrefix        map中的键前缀
     * @return Map<String       ,       Object>
     */
    public static Map<String, String> transBean2Map(Object bean, Map<String, String> map, String[] ignoreProperties,
                                                    String keyPrefix, boolean includeNull) {
        Map<String, String> resultMap = new HashMap<String, String>();
        String prefix = "";
        if (null == bean) {
            throw new IllegalArgumentException("'bean' must not be null");
        }
        if (null != map) {
            resultMap = map;
        }
        if (StringUtils.isNotBlank(keyPrefix)) {
            prefix = keyPrefix;
        }
        BeanInfo beanInfo;
        try {
            beanInfo = Introspector.getBeanInfo(bean.getClass());
            PropertyDescriptor[] properties = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor property : properties) {
                String key = property.getName();
                List<String> ignoreList = (ignoreProperties != null)
                        ? new ArrayList<String>(Arrays.asList(ignoreProperties))
                        : new ArrayList<String>();
                ignoreList.add("class");
                if (!ignoreList.contains(key)) {
                    Method getter = property.getReadMethod();
                    Object value;
                    value = getter.invoke(bean);
                    if (getter.getReturnType() == Date.class && null != getter.getAnnotation(DateTimeFormat.class)) {
                        DateTimeFormat an = getter.getAnnotation(DateTimeFormat.class);
                        value = DateHelper.formatDate((Date) value, an.pattern());
                    }
                    if (includeNull || (null != value && StringUtils.isNotBlank(value + ""))) {

                        resultMap.put(prefix + key, null == value ? "" : value + "");
                    }
                }
            }
        } catch (ReflectiveOperationException e) {
            LOGGER.info(REFLECT, e);
        } catch (IntrospectionException e) {
            LOGGER.info(INSTROSPECTION, e);
        }

        return resultMap;
    }

    /**
     * 将ValueObject中的属性值复制到model中的同名属性中. 、
     *
     * @param vo    Value object，对应Controller及页面中的属性
     * @param model model，对应数据表中的属性
     * @return Object(model)
     */
    public static Object vo2model(Object vo, Object model) {
        try {
            PropertyUtils.copyProperties(model, vo);
        } catch (ReflectiveOperationException e) {
            LOGGER.info(REFLECT, e);
        }
        return model;
    }

    /**
     * 将Model中的属性值复制到ValueObject中的同名属性中.
     *
     * @param model Model，对应数据表中的属性
     * @param vo    Value Object，对应Controller及页面中的属性
     * @return Object(vo)
     */
    public static Object model2vo(Object model, Object vo) {
        try {
            PropertyUtils.copyProperties(vo, model);
        } catch (ReflectiveOperationException e) {
            LOGGER.info(REFLECT, e);
        }
        return vo;
    }
}
