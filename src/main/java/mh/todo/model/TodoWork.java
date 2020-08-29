package mh.todo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "TodoWork")
public class TodoWork {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    private int GROUP_ID;
    private int TU_ID;
    private String TW_START;
    private String TW_END;
    private String TW_TITLE;
    private String TW_CONTENTS;
    private int CATEGORY_ID;
    private int TW_CHECK;

    public int getId() {
        return ID;
    }

    public void setId(int ID) {
        this.ID = ID;
    }

    public int getGROUP_ID() {
        return GROUP_ID;
    }

    public void setGROUP_ID(int GROUP_ID) {
        this.GROUP_ID = GROUP_ID;
    }

    public int getTU_ID() {
        return TU_ID;
    }

    public void setTU_ID(int TU_ID) {
        this.TU_ID = TU_ID;
    }

    public String getTW_START() {
        return TW_START;
    }

    public void setTW_START(String TW_START) {
        this.TW_START = TW_START;
    }

    public String getTW_END() {
        return TW_END;
    }

    public void setTW_END(String TW_END) {
        this.TW_END = TW_END;
    }

    public String getTW_TITLE() {
        return TW_TITLE;
    }

    public void setTW_TITLE(String TW_TITLE) {
        this.TW_TITLE = TW_TITLE;
    }

    public String getTW_CONTENTS() {
        return TW_CONTENTS;
    }

    public void setTW_CONTENTS(String TW_CONTENTS) {
        this.TW_CONTENTS = TW_CONTENTS;
    }

    public int getCATEGORY_ID() {
        return this.CATEGORY_ID;
    }

    public void setCATEGORY_ID(int CATEGORY_ID) {
        this.CATEGORY_ID = CATEGORY_ID;
    }

    public int getTW_CHECK() {
        return this.TW_CHECK;
    }

    public void setTW_CHECK(int TW_CHECK) {
        this.TW_CHECK = TW_CHECK;
    }
}
