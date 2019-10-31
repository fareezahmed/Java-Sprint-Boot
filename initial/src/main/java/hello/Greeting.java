package hello;
    
public class Greeting {

    private final long id;
    private String content;

    public Greeting(long id, String content) {
        this.id = id;
        this.setContent(content);
    }

    public long getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    private void setContent(String content){
        this.content = content;
    }
}