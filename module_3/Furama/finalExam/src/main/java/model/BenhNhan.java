package model;

public class BenhNhan {
    private int id;
    private int idSick;
    private String codeVictim;
    private String nameVictim;
    private String dateStart;
    private String dateEnd;
    private String reason;

    public BenhNhan(int id, String nameVictim, String dateStart, String dateEnd, String reason) {
        this.id = id;
        this.nameVictim = nameVictim;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.reason = reason;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdSick() {
        return idSick;
    }

    public void setIdSick(int idSick) {
        this.idSick = idSick;
    }

    public String getCodeVictim() {
        return codeVictim;
    }

    public void setCodeVictim(String codeVictim) {
        this.codeVictim = codeVictim;
    }

    public String getNameVictim() {
        return nameVictim;
    }

    public void setNameVictim(String nameVictim) {
        this.nameVictim = nameVictim;
    }

    public String getDateStart() {
        return dateStart;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public String getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public BenhNhan(int idSick, String codeVictim, String nameVictim, String dateStart, String dateEnd, String reason) {
        this.idSick = idSick;
        this.codeVictim = codeVictim;
        this.nameVictim = nameVictim;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.reason = reason;
    }

    public BenhNhan(int id, int idSick, String codeVictim, String nameVictim, String dateStart, String dateEnd, String reason) {
        this.id = id;
        this.idSick = idSick;
        this.codeVictim = codeVictim;
        this.nameVictim = nameVictim;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.reason = reason;
    }
}
