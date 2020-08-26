package lg.study.xiaomage;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.util.stream.Stream;

public class BeanMain {
    public static void main(String[] args) throws IntrospectionException {
        BeanInfo beanInfo = Introspector.getBeanInfo(Person.class,Object.class);
        Stream.of(beanInfo.getPropertyDescriptors()).forEach(propertyDescriptor -> System.out.println(propertyDescriptor));
    }
}
