package examples;

import java.util.ArrayList;
import java.util.List;

import java8.util.function.BiConsumer;
import java8.util.function.LongUnaryOperator;
import java8.util.function.ObjLongConsumer;
import java8.util.function.Supplier;
import java8.util.stream.LongStreams;
/**
 * 
 * @author Giovanni Romio
 * Esempio di utilizzo di LongStream con StreamSuport compatibile con Java 7.
 * In questo esempio viene utilizzata l'istruzione .collect definita da classi anonime
 * L'utilità di questo esempio sta nel capire cosa avviene all'interno di 
 * .collect(Collectors.toList()
 */
public class ExampleLongStreamAnonimousConsumer {

	public static void main(String[] args) {
		
		List<? extends Object> asList = LongStreams
			.iterate(1,
				new LongUnaryOperator() {
					@Override
					public long applyAsLong(long arg0) {
						return arg0 + 1;
					}
				}
			)
			.limit(1000)
			.collect(
				new Supplier<List<Long>>() {
					@Override
					public List<Long> get() {
						return new ArrayList<>();
					}
				},
				
				new ObjLongConsumer<List<Long>>() {
					@Override
					public void accept(List<Long> arg0, long arg1) {
						arg0.add(arg1);
					}
				},
				
				new BiConsumer<List<Long>, List<Long>>() {
					@Override
					public void accept(List<Long> arg0, List<Long> arg1) {
						arg0.addAll(arg1);
						}
				});
		
		System.out.println(asList);
	}
	
}
