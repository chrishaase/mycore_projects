package main.java.data2Druckvorlage_service;


import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="source")
@XmlAccessorType(XmlAccessType.FIELD)
public class Source {

    private String mycoreid;

    private String author;
    private String title;
    private String year;
    private String place;
    private String publisher;

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getMycoreid() {
        return mycoreid;
    }

    public void setMycoreid(String mycoreid) {
        this.mycoreid = mycoreid;
    }
}
