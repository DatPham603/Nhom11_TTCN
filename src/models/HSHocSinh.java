package models;

public class HSHocSinh extends Nguoi {

    private String lop;
    private Integer khoaHoc;
    private Integer kyHoc;

    public HSHocSinh() {
    }

    public HSHocSinh(String lop, Integer khoaHoc, Integer kyHoc) {
        this.lop = lop;
        this.khoaHoc = khoaHoc;
        this.kyHoc = kyHoc;
    }

    public HSHocSinh(String lop, Integer khoaHoc, Integer kyHoc, String hoVaTen, Integer tuoi, Integer namSinh, String queQuan) {
        super(hoVaTen, tuoi, namSinh, queQuan);
        this.lop = lop;
        this.khoaHoc = khoaHoc;
        this.kyHoc = kyHoc;
    }

    public String getLop() {
        return lop;
    }

    public void setLop(String lop) {
        this.lop = lop;
    }

    public Integer getKhoaHoc() {
        return khoaHoc;
    }

    public void setKhoaHoc(Integer khoaHoc) {
        this.khoaHoc = khoaHoc;
    }

    public Integer getKyHoc() {
        return kyHoc;
    }

    public void setKyHoc(Integer kyHoc) {
        this.kyHoc = kyHoc;
    }

    @Override
    public String toString() {
        return "HSHocSinh{" + super.toString() + "lop=" + lop + ", khoaHoc=" + khoaHoc + ", kyHoc=" + kyHoc + '}';
    }

}
