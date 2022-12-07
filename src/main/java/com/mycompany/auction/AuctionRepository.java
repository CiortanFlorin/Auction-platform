package com.mycompany.auction;

import com.mycompany.auction.Auction;
import com.mycompany.user.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;

public interface AuctionRepository extends CrudRepository<Auction, Integer> {
    public Long countById(Integer id);

    @Query("SELECT u FROM Auction u WHERE u.isFinished = false ")
    public List<Auction> getAuctionByFinished();
}