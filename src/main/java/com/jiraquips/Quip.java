package com.jiraquips;

import javax.xml.bind.annotation.*;

/**
 * A message returned from the {@link MessageResource}
 */
@XmlRootElement(name = "message")
@XmlAccessorType(XmlAccessType.FIELD)
public class Quip {
    @XmlAttribute
    private String key;

    @XmlElement(name = "value")
    private String message;

    public Quip() {
    }

    public Quip(String key, String message) {
        this.key = key;
        this.message = message;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
