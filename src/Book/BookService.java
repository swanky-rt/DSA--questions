package Book;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookService {
    private List<BookPojo> books = new ArrayList<>();
    private long counter = 1;

    public List<BookPojo> findAllBooks(){
        return books;
    }

    public BookPojo addBook(BookPojo bookPojo){
        bookPojo.setId(counter++);
        books.add(bookPojo);
        return bookPojo;
    }

}
