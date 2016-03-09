package examples;

import java.util.List;
import java.util.ArrayList;

import java8.util.function.Consumer;
import java8.util.function.Predicate;
import java8.util.stream.Stream;

import static java8.util.stream.StreamSupport.stream;

public class ExampleStream {
	public static void main(String[] args) {

		List<Integer> myList = new ArrayList<>();
		myList.add(1);
		myList.add(2);
		myList.add(3);
		myList.add(4);
		Stream<Integer> myStream = stream(myList);
		myStream.filter(new Predicate<Integer>() {
			@Override
			public boolean test(Integer arg0) {
				if (arg0 > 2) {
					return true;
				}
				return false;
			}

		}).forEach(new Consumer<Integer>() {

			@Override
			public void accept(Integer arg0) {
				System.out.println("Il valore:" + arg0 + " è maggiore di 2");

			}

		});
		;
	}
}
