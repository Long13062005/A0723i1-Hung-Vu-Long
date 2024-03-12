package dto;

public class BenhNhanDto {
    private int id;
    private String codeSick;
    private String codeVictim;
    private String nameVictim;
    private String dateStart;
    private String dateEnd;
    private String reason;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodeSick() {
        return codeSick;
    }

    public void setCodeSick(String codeSick) {
        this.codeSick = codeSick;
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

    public BenhNhanDto() {
    }

    public BenhNhanDto(int id, String codeSick, String codeVictim, String nameVictim, String dateStart, String dateEnd, String reason) {
        this.id = id;
        this.codeSick = codeSick;
        this.codeVictim = codeVictim;
        this.nameVictim = nameVictim;
        this.dateStart = dateStart;
        this.dateEnd = dateEnd;
        this.reason = reason;
    }
}
