package com.mycompany.auction;


import com.mycompany.user.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service

public class AuctionService {



    @Autowired
    private JavaMailSender javaMailSender;

    void sendEmail(String recipient, String message) {

        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setTo(recipient);
        msg.setSubject("Congratulations! You won the auction!");
        msg.setText(message);

        javaMailSender.send(msg);
    }



    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AuctionRepository repo;


//    public List<Auction> listAll(){
//        return (List<Auction>) repo.findAll();
//    }

    public List<Auction> listAllFinished(){
        return (List<Auction>) repo.getAuctionByFinished();
    }

    public void save(Auction auction) {
//        Date date = new Date();
//        SimpleDateFormat formatter = new SimpleDateFormat("yyyy.MM.dd");
//        formatter.format(date);
        auction.setStartDate(java.time.LocalDate.now().toString());
        auction.setFinished(false);
        repo.save(auction);
    }

    public void bid(Auction auction) throws AuctionNotFoundException {
        Auction oldAuction = get(auction.getId());
        System.out.println(oldAuction.getLowestBid());
        if(oldAuction.getLowestBid()==null || oldAuction.getLowestBid()>=auction.getLowestBid()){
            Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            String username = ((UserDetails)principal).getUsername();
            User user = userRepository.getUserByEmail(username);
            auction.setCurrentWinner(user.getCompanyName());
            auction.setCurrentWinnerEmail(user.getEmail());
            if(oldAuction.getTargetPrice()>=auction.getLowestBid()){
                auction.setFinished(true);
            }
            String message = "You won the auction for " + auction.getItemName();
            sendEmail(auction.getCurrentWinnerEmail(),message);
            repo.save(auction);
        }
    }



    public Auction get(Integer id) throws AuctionNotFoundException {
        Optional<Auction> result = repo.findById(id);
        if (result.isPresent()){
            return  result.get();
        }
        throw new AuctionNotFoundException("Could not find any auction with id" + id);
    }

    public void delete(Integer id) throws AuctionNotFoundException {
        Long count = repo.countById(id);
        if (count == null || count == 0){
            throw new AuctionNotFoundException("Could not find any auction with id" + id);
        }
        repo.deleteById(id);
    }

    public void checkForEnding(){
        List<Auction> auctions = listAllFinished();
        String today = java.time.LocalDate.now().toString();
        for(Auction auction: auctions){
            String endTime =auction.getStartDate();
            if(endTime.equals(today) && auction.getCurrentWinnerEmail()!=null){
                auction.setFinished(true);
                String message = "You won the auction for " + auction.getItemName();
                sendEmail(auction.getCurrentWinnerEmail(),message);
                repo.save(auction);
            }

        }
    }
}
