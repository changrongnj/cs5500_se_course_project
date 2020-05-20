# Parameters

## 05/19/2020
* Weather condition 
    * categorical: sunny, cloudy, rainy
* Temperature (numeric). 
* Date (format: month/day/year). Has three dependent parameters:
* Holiday 
    * dichotomous: yes / no
* Day of Week (Categorical: Mon, Tue, …Sun)
* Traffic 
    * (Categorical: weekBefore, dayBefore, dayOf): Either 15%, 40%, or 20% more.

* Waiting time (minutes). Defined as (entry time - arrival time).
    * Exception: May be 0 when there is no waiting line.
* Entry time (format: h:m:s). The specific time when the shopper enters the store.
* Shopping time (minutes). This is associated with entry time and leave time.
* Leave time (format: h:m:s). The time shopper leaves the store.
* Total time: time spent inside the store (entry time -> leave time)

* Here are something we are not sure about ...
    * Parking time (minutes): time spent looking for parking.
        * Exception: May be 0 if open parking is available.
    * Arrival time (format: h:m:s). The specific time when the shopper arrives at the store and begins waiting to enter the store.
    * Food court (dichotomous: yes/no). Did the shopper go to the food court to grab the food?
    * Lunch Rush Hour (dichotomous: yes/no): Is this during the lunch rush?
    * Dinner Rush Hour (dichotomous: yes/no): Is this during the dinner rush?
    * (Possible) store section that the shopper spent the most time shopping at?
    * Checkout start time (h:m:s). Specific time when the shopper initiates checkout.
    * Checkout time (minutes). Total time spent in checkout (includes wait time). 
    * Checkout type (categorical: Regular, Express, Self)


