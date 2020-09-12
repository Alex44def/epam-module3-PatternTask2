package ru.epam.jonline.module3.work_with_patterns.pattern_task2;

import java.util.ArrayList;
import java.util.List;

import ru.epam.jonline.module3.work_with_patterns.pattern_task2.enity.Tag;
import ru.epam.jonline.module3.work_with_patterns.pattern_task2.logic.MainAction;
import ru.epam.jonline.module3.work_with_patterns.pattern_task2.view.ViewAction;

public class App {

	public static void main(String[] args) {

		String textXML1 = "<notes>\n" + "<note id=\"1\">\n" + "<to>Вася</to>\n" + "<from>Света</from>\n"
				+ "<heading>Напоминание</heading>\n" + "<body>Позвони мне завтра!</body>\n" + "</note>\n"
				+ "<note id=\"2\" point=\"45y1\">\n" + "<to>Петя</to>\n" + "<from>Маша</from>\n"
				+ "<heading>Важное напоминание</heading>\n" + "<body/>\n" + "</note>\n" + "</notes>\n";

		MainAction action = new MainAction();
		ViewAction view = new ViewAction();

		List<Tag> tagsList = new ArrayList<>();

		tagsList = action.splitXMLbyTag(textXML1);

		view.printTagList(tagsList);
	}

}