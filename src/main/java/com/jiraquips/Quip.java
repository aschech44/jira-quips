package com.jiraquips;

import javax.xml.bind.annotation.*;

/**
 * A message returned from the {@link MessageResource}
 */
@XmlRootElement(name = "message")
@XmlAccessorType(XmlAccessType.FIELD)
public class Quip {
    @XmlAttribute(name = "key")
    private String key;

    @XmlElement(name = "value")
    private String message;
	
	@XmlElement(name = "timestamp")
	private long timestamp;
	
	@XmlElement(name = "author")
	private String author;

    public Quip() {
    }

    public Quip(String key, long timestamp, String author, String message) {
        this.key = key;
        this.message = message;
		this.timestamp = timestamp;
		this.author = author;
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
	
	public long getTimestamp() {
		return timestamp;
	}
	
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
}
