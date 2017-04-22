package my.pack.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Sample {

    private String msg;

    public Sample() {

    }

    public Sample(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
