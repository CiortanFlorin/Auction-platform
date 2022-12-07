package com.mycompany.auction;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "auctions")
public class Auction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 45)
    private String itemName;

    @Column(nullable = false)
    private Integer targetPrice;

    @Column(nullable = false)
    private String startDate;

    @Column
    private Integer lowestBid;

    @Column
    private String currentWinner;

    @Column
    private String currentWinnerEmail;

    @Column
    private Boolean isFinished;

    public Boolean getFinished() {
        return isFinished;
    }

    public void setFinished(Boolean finished) {
        isFinished = finished;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public Integer getTargetPrice() {
        return targetPrice;
    }

    public void setTargetPrice(Integer targetPrice) {
        this.targetPrice = targetPrice;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public Integer getLowestBid() {
        return lowestBid;
    }

    public void setLowestBid(Integer lowestBid) {
        this.lowestBid = lowestBid;
    }

    public String getCurrentWinner() {
        return currentWinner;
    }

    public void setCurrentWinner(String currentWinner) {
        this.currentWinner = currentWinner;
    }

    public String getCurrentWinnerEmail() {
        return currentWinnerEmail;
    }

    public void setCurrentWinnerEmail(String currentWinnerEmail) {
        this.currentWinnerEmail = currentWinnerEmail;
    }
}
