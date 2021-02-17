/*
 *  This is a Supplemental File from the Main Project used
 *  in Java Programming Core Fundamental III
 *  with FGroupIndonesia online & offline sessions.
 *  (c) FGroupIndonesia.com
 */
package logic;

/**
 *
 * @author ASUS
 */
public class Data {
    private String type;
    private String shutdowntime = "-";
    private int no;
    private int pid;
    private String name;
    private String memoryUsed;

    /**
     * @return the no
     */
    public int getNo() {
        return no;
    }

    /**
     * @param no the no to set
     */
    public void setNo(int no) {
        this.no = no;
    }

    /**
     * @return the pid
     */
    public int getPid() {
        return pid;
    }

    /**
     * @param pid the pid to set
     */
    public void setPid(int pid) {
        this.pid = pid;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the memoryUsed
     */
    public String getMemoryUsed() {
        return memoryUsed;
    }

    /**
     * @param memoryUsed the memoryUsed to set
     */
    public void setMemoryUsed(String memoryUsed) {
        this.memoryUsed = memoryUsed;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the shutdowntime
     */
    public String getShutdowntime() {
        return shutdowntime;
    }

    /**
     * @param shutdowntime the shutdowntime to set
     */
    public void setShutdowntime(String shutdowntime) {
        this.shutdowntime = shutdowntime;
    }
}
