package tree;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class TreeOrder {
	private static List<String> allElement = new ArrayList<String>();

	private static List<Map<String, Object>> menuTree = new ArrayList<Map<String, Object>>();

	public static void setElement() {
		allElement.add("A");
		allElement.add("A1");
		allElement.add("A2");
		allElement.add("A3");
		allElement.add("A4");
		allElement.add("A11");
		allElement.add("A21");
		allElement.add("A22");
		allElement.add("A41");
		allElement.add("A42");
		allElement.add("A111");
		allElement.add("A421");
		
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("menuId", "000001");
		map1.put("menuName", "系统管理");
		map1.put("parentId", "0");
		menuTree.add(map1);
		
		Map<String, Object> map2 = new HashMap<String, Object>();
		map2.put("menuId", "000002");
		map2.put("menuName", "信息管理");
		map2.put("parentId", "0");
		menuTree.add(map1);
		
		Map<String, Object> map3 = new HashMap<String, Object>();
		map3.put("menuId", "000003");
		map3.put("menuName", "组织管理");
		map3.put("parentId", "000001");
		menuTree.add(map1);
		
		Map<String, Object> map4 = new HashMap<String, Object>();
		map4.put("menuId", "000004");
		map4.put("menuName", "系统用户");
		map4.put("parentId", "000001");
		menuTree.add(map1);
		
		Map<String, Object> map5 = new HashMap<String, Object>();
		map5.put("menuId", "000005");
		map5.put("menuName", "会员管理");
		map5.put("parentId", "000002");
		menuTree.add(map1);
	}

	public static void main(String[] args) {
		setElement();
		Map<String, Object> map1 = new HashMap<String, Object>();
		map1.put("menuId", "000001");
		map1.put("menuName", "系统管理");
		map1.put("parentId", "0");
		deepMapOrder(map1);
		
		
		
		
		//deepOrder("A");
		//broadOrder("A");
	}

	// 深度遍历
	public static void deepMapOrder(Map<String, Object> item) {
		if (menuTree.contains(item)) {
			Stack<Map<String, Object>> s = new Stack<Map<String, Object>>();
			s.push(item);
			while (!s.isEmpty()) {
				Map<String, Object> now = s.pop();
				String t = now.get("parentId").toString();
				System.out.println(t + now);
				s.addAll(getMapChild("deep", now));
			}
		}
	}
	
	// 获取子元素
	private static List<Map<String, Object>> getMapChild(String mode, Map<String, Object> oneElement) {
		List<Map<String, Object>> childs = new ArrayList<Map<String,Object>>();
		for (int i = 0; i < menuTree.size(); i++) {
			if (menuTree.get(i).get("parentId").toString().length() == oneElement.get("parentId").toString().length() + 1
					&& (menuTree.get(i).get("parentId").toString()
							.substring(0, oneElement.get("parentId").toString().length())
							.equals(oneElement))) {
				if (mode.equals("deep")) {
					// 此处保证集合中最后一个元素是需要显示在当前层级中第一个展示的子节点（因为堆栈中是最后一个元素先出）
					if (childs != null
							&& childs.size() != 0
							&& Integer.valueOf(menuTree.get(i).toString()
									.substring(1)) > Integer.valueOf(childs
									.get(0).toString().substring(1))) {
						childs.add(0, menuTree.get(i));
					} else {
						childs.add(menuTree.get(i));
					}
				}
			}
		}
		return childs;
	}
	
	// 深度遍历
	public static void deepOrder(String oneElement) {
		if (allElement.contains(oneElement)) {
			Stack<String> s = new Stack<String>();
			s.push(oneElement);
			while (!s.isEmpty()) {
				String now = s.pop();
				StringBuffer t = getSpace(now);
				System.out.println(t.toString() + now);
				s.addAll(getChild("deep", now));
			}
		}

	}

	// 根据传入的string元素来返回需要的空格
	private static StringBuffer getSpace(String now) {
		StringBuffer t = new StringBuffer("");
		for (int i = 0; i < now.length(); i++) {
			t.append(" ");
		}
		return t;
	}

	// 获取子元素
	private static Collection<String> getChild(String mode, String oneElement) {
		List<String> childs = new ArrayList<String>();
		for (int i = 0; i < allElement.size(); i++) {
			if (allElement.get(i).toString().length() == oneElement.length() + 1
					&& (allElement.get(i).toString()
							.substring(0, oneElement.length())
							.equals(oneElement))) {
				if (mode.equals("deep")) {
					// 此处保证集合中最后一个元素是需要显示在当前层级中第一个展示的子节点（因为堆栈中是最后一个元素先出）
					if (childs != null
							&& childs.size() != 0
							&& Integer.valueOf(allElement.get(i).toString()
									.substring(1)) > Integer.valueOf(childs
									.get(0).toString().substring(1))) {
						childs.add(0, allElement.get(i));
					} else {
						childs.add(allElement.get(i));
					}
				} else {
					if (childs != null
							&& childs.size() != 0
							&& Integer.valueOf(allElement.get(i).toString()
									.substring(1)) < Integer.valueOf(childs
									.get(0).toString().substring(1))) {
						childs.add(0, allElement.get(i));
					} else {
						childs.add(allElement.get(i));
					}
				}
			}
		}
		return childs;
	}

	// 广度遍历
	private static void broadOrder(String oneElement) {
		if (allElement.contains(oneElement)) {
			List<String> l = new ArrayList<String>();
			l.add(oneElement);
			while (!l.isEmpty()) {
				String now = l.get(0);
				l.remove(0);
				StringBuffer t = getSpace(now);
				System.out.println(t.toString() + now);
				l.addAll(getChild("broad", now));
			}
		}
	}
}
