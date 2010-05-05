package com.jiraquips;

import javax.xml.bind.annotation.*;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * A message returned from the {@link MessageResource}
 */
@XmlRootElement(name = "message")
@XmlAccessorType(XmlAccessType.FIELD)
public class Quip {
    @XmlElement(name = "key")
    private String key;

    @XmlElement(name = "value")
    private String message;
	
	// Stored internally but not presented in JSON messages - the cached string version
	// is used below (saves worrying about whether Java 'long' representation is same as
	// Javascript, and browser timezone etc).
	private long timestampMillis;
	
	@XmlElement(name = "timestamp")
	private String timestamp;
	
	@XmlElement(name = "author")
	private String author;

    public Quip() {
    }

    public Quip(String key, long timestamp, String author, String message) {
        this.key = key;
        this.message = message;
		this.author = author;
		
		setTimestamp(timestamp); // handles setting up the cached string.
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
		return timestampMillis;
	}
	
	public void setTimestamp(long timestamp) {
		this.timestampMillis = timestamp;
		
		Date date = new Date();
		date.setTime(timestampMillis);
		
		SimpleDateFormat dateformat = new SimpleDateFormat("dd/MM/yy");
		this.timestamp = dateformat.format(date);
	}
	
	public String getAuthor() {
		return author;
	}
	
	public void setAuthor(String author) {
		this.author = author;
	}
}
