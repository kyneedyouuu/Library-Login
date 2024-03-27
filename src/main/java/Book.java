import java.util.UUID;

public class Book {
    public static UUID bookId;
    private String title;
    private String author;
    private String category;
    private int stock = 0;
    private int duration = 0;

    // Constructor parameter
    public Book(String title, String author, String category) {
        this.bookId = UUID.randomUUID();
        this.title = title;
        this.author = author;
        this.category = category;
        this.stock = stock;
        this.duration = duration;
    }

    public static UUID bookId() {
        return null;
    }

    // method getter
    public UUID getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getCategory() {
        return category;
    }

    public int getStock() {
        return stock;
    }

    public int getDuration() {
        return duration;
    }

    // method setter
    public void setTitle(String title) {
        this.title = title;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    // Method untuk menghasilkan UUID baru
    public static UUID generateBookId() {
        return UUID.randomUUID();
    }

    // Enum untuk kategori buku
    public enum BookCategory {
        HISTORY,
        TEXTBOOK,
        STORY
    }


    static class HistoryBook extends Book {
        public HistoryBook(String title, String author, int stock) {
            super(title, author, "History");
        }
    }

    static class StoryBook extends Book {
        public StoryBook(String title, String author, int stock) {
            super(title, author, "Story");
        }
    }

    static class TextBook extends Book {
        public TextBook(String title, String author, int stock) {
            super(title, author, "TextBook");
        }
    }
}
