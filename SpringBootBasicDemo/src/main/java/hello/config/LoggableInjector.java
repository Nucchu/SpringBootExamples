package hello.config;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.ReflectionUtils.FieldCallback;


@Component
public class LoggableInjector implements BeanPostProcessor {
	@Override
	public Object postProcessAfterInitialization(Object bean, String beanName)
			throws BeansException {
		return bean;
	}

	@Override
	public Object postProcessBeforeInitialization(final Object bean,
			String beanName) throws BeansException {
		List<Field> fildList=   Arrays.asList(bean.getClass().getFields());
		fildList.forEach(f->{
			 ReflectionUtils.makeAccessible(f);
			 if(f.getAnnotation(PosValChk.class)!=null){
				 System.out.println(f);
			 }
		});
		
		
		
		ReflectionUtils.doWithFields(bean.getClass(), new FieldCallback() {
			@Override
			public void doWith(Field field) throws IllegalArgumentException,
					IllegalAccessException {
				// make the field accessible if defined private
				ReflectionUtils.makeAccessible(field);
				if (field.getAnnotation(Loggable.class) != null) {
					org.slf4j.Logger log = LoggerFactory.getLogger(bean
							.getClass());
					field.set(bean, log);

				}
				 
					
				 
			}
		});

		return bean;
	}

}