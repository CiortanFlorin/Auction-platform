//package com.mycompany.auction;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//
//import java.util.List;
//
//@Controller
//public class AuctionController {
//
//    @Autowired
//    private AuctionService auctionService;
//
//    @GetMapping("/auctions")
//    public String showAuctionList(Model model){
//        List<Auction> listAuctions = auctionService.listAll();
//        model.addAttribute("listAuctions", listAuctions);
//        return "auctions";
//
//    }
//}
