package ll;

public interface Decorator<T> extends Iterable<T>{
	public String toString();
	public Object[] toArray();
	public <E> E[] toArray(E[] e);
}
