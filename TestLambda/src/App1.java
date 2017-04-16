import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class App1 {
	
	
	public static Consumer<Object> c1 = x -> System.out.println(x);
	
	
	//functional interface
	@FunctionalInterface
	interface MyMethod {
	    public void print(String s);
	}
	
	public static void testf(int x ){
		if(x == 30){
			System.out.println(" -> Thirty <- ");
		}
	}
	
	public static int add10(int x ){
		x += 10;
		return x;
	}

	public static void main(String[] args) {
		
		List<Integer> intList = Arrays.asList(1, 10, 3, 7, 5);
		
		Map<String, Integer> itemsM = new HashMap<>();
		itemsM.put("A", 10);
		itemsM.put("B", 20);
		itemsM.put("C", 30);
		itemsM.put("D", 40);
		itemsM.put("E", 50);
		itemsM.put("F", 60);
		
//		for (Map.Entry<String, Integer> entry : items.entrySet()) {
//			System.out.println("Item : " + entry.getKey() + " Count : " + entry.getValue());
//		}
		
		itemsM.forEach((k,v)->System.out.println("Item : " + k + " Count : " + v));

		itemsM.forEach((k,v)->{
			testf(v);
		});
		
		itemsM.forEach((k,v) -> testf(v) );
		
		
		itemsM.forEach((k,v) -> {
			System.out.println(k + ":" +v);
		});
		
		
		itemsM.forEach((k,v) -> {
			Test1.testme(k);
		});
		
		
		itemsM.forEach((k,v) -> Test1.testme(k) );
		
		//itemsM.forEach(() -> Test1::testme);
		
			
		//itemsM.forEach((k,v) -> System.out.println(1 + ":" + k));
		
//		items.forEach((k,v)->{
//			System.out.println("Item : " + k + " Count : " + v);
//			if("E".equals(k)){
//				System.out.println("Hello E");
//			}
//		});
		
		List<String> items = new ArrayList<>();
		items.add("Max");
		items.add("Tim");
		items.add("Tom");
		items.add("Tina");
		items.add("Moritz");
		
		for(String item : items){
			System.out.println(item);
		}
		
		//lambda
		//Output : A,B,C,D,E
		items.forEach(item->System.out.println(item));
		
		items.stream()
			.filter(s->s.startsWith("A"))
			.forEach(Test1::testme);
			//.forEach(System.out::println);
		
		
		items.forEach(Test1::testme);
		
		
		String abc =
		items.stream()
			.filter(s->s.startsWith("A"))
			.findFirst()
			.get();
			
		
		System.out.println(abc);
			
		Set<Integer> intset = new HashSet();
		
		//intList.forEach(x -> intset.add(x));
		//intList.forEach(intset::add);
		
		intList.forEach(p -> {
			intset.add(Test1.add20(p));
		});
		
		intset.forEach(System.out::println);
		
//		intList.forEach(x -> {
//			intset.add(x);
//		});

		//http://stackoverflow.com/questions/23554413/calling-system-out-println-through-a-lambda-expression
		 //Consumer<Object> c1 = x -> System.out.println(x);
		 c1.accept("Print via lambda");
		
		 MyMethod method = (String s) -> { System.out.println(s); };
		 
		 method.print("hallo du");
		 
		 
		 intList.forEach(p -> System.out.println(p * 2) );
		 
		 String csv = "Max;Mustermann;Musterstr;10;56789;Musterhausen";
		 
		 Arrays.stream(csv.split(";"))
		 	.forEach(System.out::println);
		 
		 
		 String result = items
		            .stream()
		            .map(s -> s.substring(0, 1))
		            .collect(Collectors.joining());
		 System.out.println(result);
		 	            
		//Without creating many intermediate String objects you can do it like this:
		 StringBuilder sb = items.stream()
                 .mapToInt(l -> l.codePointAt(0))
                 .collect(StringBuilder::new, 
                          StringBuilder::appendCodePoint, 
                          StringBuilder::append);
		 
		 System.out.println(sb.toString());
		 
		 
		 final StringBuilder chars = new StringBuilder();
		 items.forEach(l -> chars.append(l.charAt(0)));
		 
		//Assert.assertEquals("tqbf", result);
		 
		 Test1 test = new Test1();
		 
		 int ab = intList.stream()
		 			.filter(p -> p<8)
		 			.collect(Collectors.summingInt( p -> p));
				 			
		 System.out.println(ab);
		 
		 
		 int abc1 = intList.stream()
				 		.filter(p -> p<8)
		 				.mapToInt(x -> x).sum();
		 		 			
		 System.out.println(abc1);
		 
		 
		 IntStream abc2 = intList.stream()
			 		.filter(p -> p<8)
	 				.mapToInt(Integer::intValue);
		
		 Set<Integer> hashInt = new HashSet<>();
		 abc2.forEach( p -> {
			 hashInt.add(p);
			 System.out.println(p);
		 });
		 
		 hashInt.stream().forEach(System.out::println);
		 
		 
		 items.removeIf( String::isEmpty );
		 items.forEach( System.out::println );
		 items.removeIf(Objects::isNull);
		 items.removeIf(String::isEmpty);
		 items.removeIf(s -> s == null || s.isEmpty());
		 
//		 Person p = new Person() {
//			 vorname = "Dan";
//		 }
//		 
		 
		 
	}

}
