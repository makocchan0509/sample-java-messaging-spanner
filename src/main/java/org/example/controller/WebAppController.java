package org.example.controller;

import org.example.PubSubApplication.PubsubOutboundGateway;
import org.example.model.ItemsRepository;
import org.example.model.Items;
import org.example.model.ShopsRepository;
import org.example.model.Shops;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.UUID;

@RestController
public class WebAppController {

    @Autowired
    private PubsubOutboundGateway pubsubOutboundGateway;

    @Autowired
    private ItemsRepository itemsRepository;

    @Autowired
    private ShopsRepository shopsRepository;

    @PostMapping("/publishMessage")
    public RedirectView publishMessage(@RequestParam("message") String message) {
        pubsubOutboundGateway.sendToPubsub(message);
        return new RedirectView("/");
    }

    @PostMapping("/createShop")
    public ModelAndView createShop(@RequestParam("shopName") String shopName,
                                   @RequestParam("describe") String describe) {
        Shops shop = new Shops();

        shop.setShopName(shopName);
        shop.setDescribe(describe);
        shopsRepository.save(shop);

        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }

    @PostMapping("/createItem")
    public ModelAndView createItem(@RequestParam("shopId") UUID shopId,
                                   @RequestParam("itemName") String itemName) {
        Items item = new Items();
        item.setShopId(shopId);
        item.setItemName(itemName);
        itemsRepository.save(item);

        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }
}