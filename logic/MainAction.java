package ru.epam.jonline.module3.work_with_patterns.pattern_task2.logic;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ru.epam.jonline.module3.work_with_patterns.pattern_task2.enity.Tag;
import ru.epam.jonline.module3.work_with_patterns.pattern_task2.service.ServiceAction;

public class MainAction {
	
	ServiceAction service = new ServiceAction();

	List<Tag> tagsList = new ArrayList<>();

	
	public List<Tag> splitXMLbyTag(String textXML) {
		
		Pattern p = Pattern.compile("(</?([a-z]+[a-zA-Z0-9])+( [a-z]+[a-zA-Z0-9]+=\"[a-zA-Z0-9]+\")*/?>)");
		Matcher m = p.matcher(textXML);
		
		int start = 0;
		
		while (m.find()) {
			Tag element = new Tag();
			String tag = textXML.substring(m.start(), m.end());
			element.setNameTag(m.group(2));
			String attr = m.group(3);
			if (attr != null) {
				element.setAttributes(service.getAttributesFromTag(m.group()));
			}
			String typeTagByRegex = service.getTypeTagByRegex(tag);
			if (typeTagByRegex.equals("open")) {
				start = m.end();
			}
			element.setTypeTag(typeTagByRegex);
			tagsList.add(element);
			if (tagsList.size() > 1 && tagsList.get(tagsList.size() - 1).getTypeTag().equals("close")
					&& tagsList.get(tagsList.size() - 2).getTypeTag().equals("open")
					&& tagsList.get(tagsList.size() - 1).getNameTag()
							.equals(tagsList.get(tagsList.size() - 2).getNameTag())) {
				String str = textXML.substring(start, m.start());
				element.setContentTag(str);
			}
		}
		
		return tagsList;
	}
	
}
