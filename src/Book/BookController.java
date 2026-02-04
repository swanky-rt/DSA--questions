package Book;

import java.util.List;

import static com.sun.xml.internal.ws.api.message.Packet.Status.Response;

//this file doesnt support springboot impl
@RestController
@RequestMapping("/api/book")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<BookPojo>> getAllBooks(){
        List<BookPojo> books = bookService.findAllBooks();
        return ResponseEntity.ok(books);
    }

    @PostMapping
    public ResponseEntity<BookPojo> createBook(@RequestBody BookPojo newBook){
        BookPojo createBook = bookService.addBook(newBook);
        return ResponseEntity.status(HttpStatus.created).body(createBook);
    }
}
