package models;

public class Nguoi {

    protected String hoVaTen;
    protected Integer tuoi;
    protected Integer namSinh;
    protected String queQuan;

    public Nguoi() {
    }

    public Nguoi(String hoVaTen, Integer tuoi, Integer namSinh, String queQuan) {
        this.hoVaTen = hoVaTen;
        this.tuoi = tuoi;
        this.namSinh = namSinh;
        this.queQuan = queQuan;
    }

    public String getHoVaTen() {
        return hoVaTen;
    }

    public void setHoVaTen(String hoVaTen) {
        this.hoVaTen = hoVaTen;
    }

    public Integer getTuoi() {
        return tuoi;
    }

    public void setTuoi(Integer tuoi) {
        this.tuoi = tuoi;
    }

    public Integer getNamSinh() {
        return namSinh;
    }

    public void setNamSinh(Integer namSinh) {
        this.namSinh = namSinh;
    }

    public String getQueQuan() {
        return queQuan;
    }

    public void setQueQuan(String queQuan) {
        this.queQuan = queQuan;
    }

    @Override
    public String toString() {
        return "Nguoi{" + "hoVaTen=" + hoVaTen + ", tuoi=" + tuoi + ", namSinh=" + namSinh + ", queQuan=" + queQuan + '}';
    }

}
