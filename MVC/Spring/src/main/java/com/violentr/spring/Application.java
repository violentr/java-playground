package com.violentr.spring;

import com.violentr.spring.utils.BubleSortAlgorithm;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.Arrays;

@SpringBootApplication
public class Application {
/* Udemy course: https://www.udemy.com/course/spring-tutorial-for-beginners */
	public static void main(String[] args) {
		ApplicationContext application =
				SpringApplication.run(Application.class, args);
//		SortAlgorithmImpl algo = new SortAlgorithmImpl(new BubleSortAlgorithm());
//		int[] result = algo.sort(new int[]{1,6,8});
//		System.out.println(Arrays.toString(result));

      	BubleSortAlgorithm bubleSortAlgorithm = application.getBean(BubleSortAlgorithm.class);
		System.out.println(Arrays.toString(bubleSortAlgorithm.sort(new int[]{1, 5, 8})));
//        String[] beans = application.getBeanDefinitionNames();
//        application.getBean(mvcValidator.class);
//        for (String beanName : beans) {
//            System.out.println(beanName);
//        }
	}

}
