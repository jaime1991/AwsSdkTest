package curso.aws.tutorial.domain.usecase.base.applicationevents;

public class Message {

    private String id;
    private Object content;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Message message = (Message) o;

        if (getId() != null ? !getId().equals(message.getId()) : message.getId() != null) return false;
        return getContent() != null ? getContent().equals(message.getContent()) : message.getContent() == null;
    }

    @Override
    public int hashCode() {
        int result = getId() != null ? getId().hashCode() : 0;
        result = 31 * result + (getContent() != null ? getContent().hashCode() : 0);
        return result;
    }
}
