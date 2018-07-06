package codesquad.domain;

public class Question {
    private String writer;
    private String title;
    private String contents;
    private int id;

    public Question() {

    }

    public String getWriter() {
        return writer;
    }

    public String getTitle() {
        return title;
    }

    public String getContents() {
        return contents;
    }

    public int getId() {
        return id;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public void setId(int id) {
        this.id = id;
    }
}
