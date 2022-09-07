package model.order;

import model.book.Book;
import model.member.Member;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {
    private String orderId;
    private Book book;
    private Member member;
    private Date startTime;
    private Date endTime;

    public Order() {
    }

    public Order(String orderId, Book book, Member member, Date startTime, Date endTime) {
        this.orderId = orderId;
        this.book = book;
        this.member = member;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", book=" + book +
                ", member=" + member +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }
}
