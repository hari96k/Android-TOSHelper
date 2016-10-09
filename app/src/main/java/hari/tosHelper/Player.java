package hari.tosHelper;

public class Player {
    String alignment;
    Integer position;
    Boolean status;

    public Player(String alignment, Integer position, Boolean status){
        this.alignment = alignment;
        this.position = position;
        this.status = status;
    }

    public void setPosition(Integer position){
        this.position = position;
    }

}
