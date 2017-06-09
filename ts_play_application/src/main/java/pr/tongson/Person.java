package pr.tongson;

import cn.bmob.v3.BmobObject;

/**
 * <b>Project:</b> ${file_name}<br>
 * <b>Create Date:</b> 2017/6/9<br>
 * <b>Author:</b> mmc_Kongming_Tongson<br>
 * <b>Description:</b> <br>
 */
public class Person extends BmobObject {
    private String name;
    private String address;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
}
