package com.example.projektpik;

import business.TagInjector;
import com.example.projektpik.models.Student;
import config.XMLConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.xml.sax.SAXException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

@SpringBootApplication
public class ProjektpikApplication {

	public static void main(String[] args) throws ParserConfigurationException, IOException, SAXException {
		ApplicationContext appContext = SpringApplication.run(ProjektpikApplication.class, args);
		XMLConfig xmlConfig = new XMLConfig();
		TagInjector thymeleafTagInjector = new TagInjector(xmlConfig.templateEngine(appContext));
		Map<String, Object> map = new TreeMap<>();
		Student student = new Student();
		student.setName("Kobe");
		student.setSurname("Bryant");
		map.put("student",student);

		try {
			thymeleafTagInjector.produceXmlWithInjectedTags(map, "hej");
		} catch (IOException e) {
			System.err.println("Houston mamy problem");
		}

	}
}
