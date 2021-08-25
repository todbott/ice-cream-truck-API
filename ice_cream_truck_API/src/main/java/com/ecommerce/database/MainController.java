package com.ecommerce.database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import net.minidev.json.JSONObject;

@Controller
@RequestMapping(path="/truck")
public class MainController {


  @Autowired
  private ItemRepository itemRepository;
  @Autowired
  private NetRepository netRepository;

  

  // Endpoints for managing/checking items
  @RequestMapping(path="/checkInventory", method = RequestMethod.GET)
  public @ResponseBody Iterable<Item> checkInventory(@RequestParam Integer shop_id) {
    return itemRepository.checkInventory(shop_id);
  }

  @RequestMapping(path="/addInventory", produces=MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> addInventory(@RequestParam Integer shop_id
  , String category
  , @RequestParam String name
  , @RequestParam String flavor
  , @RequestParam Integer quantity) {
    JSONObject entity = new JSONObject();
    if (itemRepository.addInventory(quantity, category, name, flavor, shop_id) > 0) {
      entity.put("response", "Quantity has been added");
      return new ResponseEntity<Object>(entity, HttpStatus.OK);
    } else {
      entity.put("response", "Nothing was updated.  There may be a problem with the parameters you provided.");
      return new ResponseEntity<Object>(entity, HttpStatus.BAD_REQUEST);
    }
  } 

  @RequestMapping(path="/addItem", produces=MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> addItem(@RequestParam Integer shop_id
  , String category
  , @RequestParam String name
  , @RequestParam String flavor
  , @RequestParam Integer quantity
  , @RequestParam Float price) {
    JSONObject entity = new JSONObject();
    if (itemRepository.addItem(shop_id, category, name, flavor, quantity, price) > 0) { 
      entity.put("response", "Item has been added");
      return new ResponseEntity<Object>(entity, HttpStatus.OK);
    } else {
      entity.put("response", "Nothing was updated.  There may be a problem with the parameters you provided.");
      return new ResponseEntity<Object>(entity, HttpStatus.BAD_REQUEST);  
    }
  } 

  @RequestMapping(path="/deleteItem", produces=MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> deleteItem(@RequestParam Integer shop_id
  , String category
  , @RequestParam String name
  , @RequestParam String flavor) {
    JSONObject entity = new JSONObject();
    if (itemRepository.deleteItem(shop_id, category, name, flavor) > 0) {
      entity.put("response", "Item has been deleted");
      return new ResponseEntity<Object>(entity, HttpStatus.OK);
    } else {
      entity.put("response", "Nothing was updated.  There may be a problem with the parameters you provided.");
      return new ResponseEntity<Object>(entity, HttpStatus.BAD_REQUEST);    
    }
  } 

  @RequestMapping(path="/changePrice", produces=MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> changePrice(@RequestParam Integer shop_id
  , @RequestParam String category
  , @RequestParam String name
  , @RequestParam String flavor
  , @RequestParam Float price) {
    JSONObject entity = new JSONObject();
    if (itemRepository.changePrice(price, category, name, flavor, shop_id) > 0) {
      entity.put("response", "Price has been changed");
      return new ResponseEntity<Object>(entity, HttpStatus.OK);
    } else {
      entity.put("response", "Nothing was updated.  There may be a problem with the parameters you provided.");
      return new ResponseEntity<Object>(entity, HttpStatus.BAD_REQUEST); 
    }
  } 

  @RequestMapping(path="/getNet", produces=MediaType.APPLICATION_JSON_VALUE, method = RequestMethod.GET)
  public ResponseEntity<Object> getNet(@RequestParam Integer shop_id) {
    JSONObject entity = new JSONObject();
    Float thisNet = netRepository.getNet(shop_id);
    if (thisNet == null) {
      entity.put("response", "Getting value failed.  The shop id you sent as a parameter might not exist.");
      return new ResponseEntity<Object>(entity, HttpStatus.BAD_REQUEST); 
    } else {
      String message = "Shop with the ID " + shop_id.toString() + " has made $" + thisNet.toString() + " so far.";
      entity.put("response", message);
      return new ResponseEntity<Object>(entity, HttpStatus.OK);
    }
  }





  // --- endpoint for buying something
  @RequestMapping(path="/buy", produces=MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Object> buy(@RequestParam Integer shop_id
  , @RequestParam String category
  , @RequestParam String name
  , @RequestParam String flavor
  , @RequestParam Integer quantity) {
    JSONObject entity = new JSONObject();
    Integer existingQuantity = itemRepository.countItems(category, name, flavor, shop_id);
    Float price = itemRepository.getPrice(category, name, flavor, shop_id);
    if (existingQuantity == null) {
      entity.put("response", "Could not buy.  There may be a problem with the parameters you provided.");
      return new ResponseEntity<Object>(entity, HttpStatus.BAD_REQUEST); 
    } else {
      if (existingQuantity >= quantity) {
        itemRepository.buy(quantity, category, name, flavor, shop_id);
        entity.put("response", "ENJOY!");
        Float thisNet = price * quantity;
        netRepository.updateNet(thisNet, shop_id);
        return new ResponseEntity<Object>(entity, HttpStatus.OK);
      } else {
        String message = "SO SORRY! You tried to buy " + quantity.toString() + ", but there are " + existingQuantity.toString() + " in stock.";
        entity.put("response", message);
        return new ResponseEntity<Object>(entity, HttpStatus.SERVICE_UNAVAILABLE);
      }
    }
  }
}