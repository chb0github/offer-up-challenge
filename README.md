# New Backend Challenge 

Hello! For your backend challenge you are tasked with creating a very simple price recommendation micro service:
We have made publicly available a database (postgresql) with all the information you will need. (just dummy data, the numbers do not reflect reality in any conceivable way)
Here are your connection details:
host: offerupchallenge.cgtzqpsohu0g.us-east-1.rds.amazonaws.com:5432 user: offerupchallenge
password: ouchallenge
name: itemprices
table: itemPrices_itemsale (you can ignore the other ones)

The itemPrices_itemsale table describes various items in the system and contains 6 columns:
id (int): unique id for an item, created by Postgres
title (char): title of the item (e.g. Xbox One)
list_price (int): the price at which the item was listed
sell_price (int): the price at which the item was sold
city (char): the city in which the item was listed
cashless (bool): true / false the seller will accept a credit card payment


The price recommendation calculation will be very simple: given an item title and city, return the most frequently occurring 
list price value (the list price mode: https://en.wikipedia.org/wiki/Mode_(statistics)) for that item set along with the total 
count of the returned item set (i.e. how many shoes are listed in Miami). If there is a tie (i.e. multiple list prices have 
the same number of occurrences) return the highest list price value.
Your service should be able to take item & city parameters using the following pattern:
http://127.0.0.1/item-price-service/?item=Furniture&city=Philadelphia
And return a json response in this form (Note: these are not expected return values, database values update on occasion):

```
{
    "status": 200,
    "content": {
        "item": "Furniture",
        "item_count": 6,
        "price_suggestion": 48,
        "city": "Philadelphia"
    } 
}
```

However, if no city is supplied: http://127.0.0.1/item-price-service/?item=ps4
```
{
    "status": 200,
    "content": {
        "item": "ps4",
        "item_count": 105,
        "price_suggestion": 373,
        "city": "Not specified"
    } 
}
```

And if neither are supplied:
```
    {
        "status": 404,
        "content": {
            "message": "Not found"
        }
    }
```
For the purposes of this challenge dont worry about partial item title matches, assume we are only concerned with exact matches (we will test the api responses, and the test will just use values from the database)
Along with the api structure, the only requirement is that you build your service on ubuntu 14.04 using a virtual machine. You can follow these instructions:
http://www.discoposse.com/index.php/2014/11/11/starting-with-vagrant-and-virtualbox-a-basic-ubuntu-14-04-lts-server/
Please limit your VM to 1 CPU + 1024 MB memory

Aside from the above, there are no other specifications. Build the service with any technology stack you prefer, Python / C++ / Java / Go / etc.
To verify your api structure and measure your microservice's performance, your service will be load tested using jmeter, 
so please have it installed on your machine prior to the demo (see below for instructions) You have been supplied with 
the jmeter test plan we will use to test your service (request parameter values are subject to change). 
This challenge does not require you to run jmeter beforehand, consider performance optimizations a bonus (bragging rights for a high score). 
If you are curious about jmeter, see below for instructions. Please email any concerns or questions you have, otherwise have fun!

BONUS CONTENT:
http://stackoverflow.com/questions/22610316/how-do-i-install-jmeter-on-a-mac 
http://thelinuxfaq.com/324-how-to-install-apache-jmeter-on-ubuntu-14-04-fedora-20-centos-7

query to target:
```
select city,title, list_price, count(list_price) as c from "itemPrices_itemsale" GROUP BY list_price,city,title order by city, c DESC ;
```