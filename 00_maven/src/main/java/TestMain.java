import modal.Book;
import modal.User;

public class TestMain {

	public static void main(String[] args) {
		User user = new User();
		user.setName("Guybrush");
		user.setPassword("1234");
		
		User user2 = new User("123","123");

		System.out.println(user);
		
		Book book1 = new Book("山德森", "迷霧之子");
		
		Book book2 = new Book("山德森", "破戰者");
		
		System.out.println(book1.equals(book2));

	}

}
