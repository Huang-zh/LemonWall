package lemonWall.entity;

public class BaseEntity {

    public String delFlag;

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public void preInsert(){
        setDelFlag("0");
    }
}
