package model;

public class BenhAn {
    private int idSick;
    private String codeSick;

    public int getIdSick() {
        return idSick;
    }

    public void setIdSick(int idSick) {
        this.idSick = idSick;
    }

    public String getCodeSick() {
        return codeSick;
    }

    public void setCodeSick(String codeSick) {
        this.codeSick = codeSick;
    }

    public BenhAn() {
    }

    public BenhAn(int idSick, String codeSick) {
        this.idSick = idSick;
        this.codeSick = codeSick;
    }
}
