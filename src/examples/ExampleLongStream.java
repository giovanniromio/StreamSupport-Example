package examples;

import java.util.List;

import java8.util.function.LongFunction;
import java8.util.function.LongUnaryOperator;
import java8.util.stream.Collectors;
import java8.util.stream.LongStreams;
/**
 * 
 * @author Giovanni Romio
 * Esempio di utilizzo di LongStream della libreria StreamSupport compatibile con Java7
 * Notare che non vengono utilizzate le lambda expression
 */
public class ExampleLongStream {
	
	public static void main(String[] args) {

		List<? extends Object> asList = LongStreams.iterate(1, new LongUnaryOperator() {
			@Override
			public long applyAsLong(long arg0) {
				return arg0 + 1;
			}
		}).limit(1000).mapToObj(new LongFunction<Object>() {
			@Override
			public Object apply(long arg0) {
				return arg0;
			}
		}).collect(Collectors.toList());
		System.out.println(asList);

	}
}