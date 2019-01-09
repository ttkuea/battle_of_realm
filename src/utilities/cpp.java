package utilities;

public class cpp {
	public static class Pair<T1 extends Object, T2 extends Object> implements Comparable<Pair<T1, T2>>{
		public T1 first;
		public T2 second;
		
		public Pair(T1 first, T2 second) {
			super();
			this.first = first;
			this.second = second;
		}

		@Override
		public int compareTo(Pair<T1, T2> o) {
				if (((Comparable<T1>) first).compareTo(o.first) != 0)
					return ((Comparable<T1>) first).compareTo(o.first);
				// sort by type string
				return second.getClass().getSimpleName().compareTo(o.second.getClass().getSimpleName());
		}
		
		
	}
}
