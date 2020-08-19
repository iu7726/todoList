package mh.todo.model;

import javax.persistence.*;

@Entity(name = "TodoWork")
public class TodoWork {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int group_id;
    private int tu_id;
    private String tw_start;
    private String tw_end;
    private String tw_title;
    private String tw_contents;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getGroup_id() {
        return group_id;
    }

    public void setGroup_id(int group_id) {
        this.group_id = group_id;
    }

    public int getTu_id() {
        return tu_id;
    }

    public void setTu_id(int tu_id) {
        this.tu_id = tu_id;
    }

    public String getTw_start() {
        return tw_start;
    }

    public void setTw_start(String tw_start) {
        this.tw_start = tw_start;
    }

    public String getTw_end() {
        return tw_end;
    }

    public void setTw_end(String tw_end) {
        this.tw_end = tw_end;
    }

    public String getTw_title() {
        return tw_title;
    }

    public void setTw_title(String tw_title) {
        this.tw_title = tw_title;
    }

    public String getTw_contents() {
        return tw_contents;
    }

    public void setTw_contents(String tw_content) {
        this.tw_contents = tw_content;
    }
}
