package com.Am1n.Instagram_Clone;

import com.Am1n.Instagram_Clone.component.TestLombok;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

@SpringBootApplication
@EnableSpringDataWebSupport(pageSerializationMode = EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO)
public class InstagramCloneApplication {

	public static void main(String[] args) {
		SpringApplication.run(InstagramCloneApplication.class, args);
		TestLombok tl = new TestLombok();
		tl.setName("Amin");
		System.out.println(tl.getName());
	}

}
