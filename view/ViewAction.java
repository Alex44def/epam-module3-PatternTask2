package ru.epam.jonline.module3.work_with_patterns.pattern_task2.view;

import java.util.List;

import ru.epam.jonline.module3.work_with_patterns.pattern_task2.enity.Tag;

public class ViewAction {

	public void printTagList(List<Tag> tagsList) {
		for (Tag element : tagsList) {
			System.out.println(element);
		}
	}
}
