package karp.泛型;



/**
 * @Author: pujx
 * @Date: 2019/5/14 15:08
 */

public class CheckWeekVO {

    private  int age;

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    private  int weight;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    private String reportTime;      // 报表生成时间
    private String datauniversid;   // 订单编号
    private String fileunid;        // OA系统中当前业务流程对应文档唯一KEY
    private String title;           // 需求名称

    public String getReportTime() {
        return reportTime;
    }

    @Override
    public String toString() {
        return "CheckWeekVO{" +
                "age=" + age +
                ", weight=" + weight +
                ", reportTime='" + reportTime + '\'' +
                ", datauniversid='" + datauniversid + '\'' +
                ", fileunid='" + fileunid + '\'' +
                ", title='" + title + '\'' +
                ", filelsh='" + filelsh + '\'' +
                ", hcCity='" + hcCity + '\'' +
                ", nextfileworktime='" + nextfileworktime + '\'' +
                ", fileworktime='" + fileworktime + '\'' +
                ", hclsmz='" + hclsmz + '\'' +
                ", clsc=" + clsc +
                '}';
    }

    public void setReportTime(String reportTime) {
        this.reportTime = reportTime;
    }

    public String getDatauniversid() {
        return datauniversid;
    }

    public void setDatauniversid(String datauniversid) {
        this.datauniversid = datauniversid;
    }

    public String getFileunid() {
        return fileunid;
    }

    public void setFileunid(String fileunid) {
        this.fileunid = fileunid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getFilelsh() {
        return filelsh;
    }

    public void setFilelsh(String filelsh) {
        this.filelsh = filelsh;
    }

    public String getHcCity() {
        return hcCity;
    }

    public void setHcCity(String hcCity) {
        this.hcCity = hcCity;
    }

    public String getNextfileworktime() {
        return nextfileworktime;
    }

    public void setNextfileworktime(String nextfileworktime) {
        this.nextfileworktime = nextfileworktime;
    }

    public String getFileworktime() {
        return fileworktime;
    }

    public void setFileworktime(String fileworktime) {
        this.fileworktime = fileworktime;
    }

    public String getHclsmz() {
        return hclsmz;
    }

    public void setHclsmz(String hclsmz) {
        this.hclsmz = hclsmz;
    }

    public double getClsc() {
        return clsc;
    }

    public void setClsc(double clsc) {
        this.clsc = clsc;
    }

    private String filelsh = "";    // 文件流水号
    private String hcCity = "";     // 地市
    private String nextfileworktime = null;   // 接收时间
    private String fileworktime = null;       // 处理时间
    /**
     * 资源是否满足
     */
    private  String hclsmz;
    private double clsc = 0.0;    // 环节处理时长（完成）或 停留时长（未完成） 小时
}
