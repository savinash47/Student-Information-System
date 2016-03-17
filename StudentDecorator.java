package ll;

public abstract class StudentDecorator implements Decorator<Student> {
	private Decorator<Student> decorator;

	public StudentDecorator(Decorator<Student> decorator) {
		this.decorator = decorator;

	}

	public Decorator<Student> getDecorator() {
		return decorator;
	}
}
