package treewalk.treewalk;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import treewalk.treewalk.pojo.Node;

public class App {

	public static void main(String[] args) {
		App app = new App();
		List<String> reviews = app.getFile("reviews.txt");

		Map<String, Node<String>> map = new HashMap<String, Node<String>>();
		Node<String> parent;
		Node<String> child;

		for (String x : reviews) {
			String[] persons = x.split("reviews");

			parent = getNode(map, persons[0].trim());
			child = getNode(map, persons[1].trim());

			parent.addChild(child);
		}

		Iterator<Node<String>> it = map.values().iterator();
		Node<String> root = null;

		while (it.hasNext()) {
			root = it.next();

			if (root.isRoot())
				break;
		}
		
		traverseAndPrint(root, 0);
	}

	private static Node<String> getNode(Map<String, Node<String>> map, String person) {
		Node<String> parent = null;
		if (map.get(person) == null) {
			parent = new Node<String>(person);
			map.put(person, parent);
		} else {
			parent = map.get(person);
		}
		return parent;
	}

	private static void traverseAndPrint(Node<String> child, int depth) {
		int t = depth;
		while (t > 0) {
			System.out.print("|");
			t--;
		}
		System.out.println((child.isLeaf() ? "\\-" : "") + child.getData());
		depth++;
		for (Node<String> each : child.getChildren()) {
			traverseAndPrint(each, depth);
		}

	}

	private List<String> getFile(String fileName) {
		List<String> list = new ArrayList<>();
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource(fileName).getFile());
		try (Scanner scanner = new Scanner(file)) {
			while (scanner.hasNextLine()) {
				list.add(scanner.nextLine());
			}
			scanner.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}

}
