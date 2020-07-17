var express = require("express");
var router = express.Router();
var Visit = require("../models/visit");

// Postman GET command: localhost:8080/visits/all
router.get("/all/unordered", function (req, res) {
    Visit.find({}, function (err, visits) {
        if(err) {
            console.log(err);
        } else {
            res.setHeader('Content-Type', 'application/json');
            res.end(JSON.stringify(visits));
        }
    });
});

// Postman GET command: localhost:8080/visits/all/ordered/entry
router.get("/all/ordered/entry", function (req, res) {
    Visit.find({}).sort("entryTime").exec(function (err, visits) {
        if(err) {
            console.log(err);
        } else {
            res.setHeader('Content-Type', 'application/json');
            res.end(JSON.stringify(visits));
        }
    });
});

// Postman GET command: localhost:8080/visits/single/{visitID}
router.get("/single/:visitID", function (req, res) {
    Visit.find({"visitID":req.params.visitID}, function (err, visits) {
        if(err) {
            console.log(err);
        } else {
            res.setHeader('Content-Type', 'application/json');
            res.end(JSON.stringify(visits));
        }
    });
});

// Postman GET command: localhost:8080/visits/partial/prefix/{idPrefix}/{start}/{end}
router.get("/partial/prefix/:idPrefix/:start/:end", function (req, res) {
    let start = new Date(req.params.start);
    let end = new Date(req.params.end);
    Visit.find({"entryTime":{ $gte: start, $lte: end }, "visitID":{$regex:"^"+req.params.idPrefix}}, function (err, visits) {
        if(err) {
            console.log(err);
        } else {
            res.setHeader('Content-Type', 'application/json');
            res.end(JSON.stringify(visits));
        }
    });
});

// Postman GET command: localhost:8080/visits/partial/entry/interval/{start}/{end}
router.get("/partial/entry/interval/:start/:end", function (req, res) {
    let start = new Date(req.params.start);
    let end = new Date(req.params.end);
    Visit.find({"entryTime":{ $gte: start, $lte: end }}, function (err, visits) {
        if(err) {
            console.log(err);
        } else {
            res.setHeader('Content-Type', 'application/json');
            res.end(JSON.stringify(visits));
        }
    });
});

// Postman GET command: localhost:8080/visits/partial/leave/interval/{start}/{end}
router.get("/partial/leave/interval/:start/:end", function (req, res) {
    let start = new Date(req.params.start);
    let end = new Date(req.params.end);
    Visit.find({"leaveTime":{ $gte: start, $lte: end }}, function (err, visits) {
        if(err) {
            console.log(err);
        } else {
            res.setHeader('Content-Type', 'application/json');
            res.end(JSON.stringify(visits));
        }
    })
});

// Postman GET command: localhost:8080/visits/partial/duration/interval/{min}/{max}
router.get("/partial/duration/interval/:min/:max", function (req, res) {
    Visit.find({"duration":{ $gte: req.params.min, $lte: req.params.max }}, function (err, visits) {
        if(err) {
            console.log(err);
        } else {
            res.setHeader('Content-Type', 'application/json');
            res.end(JSON.stringify(visits));
        }
    })
});

// Postman GET command: localhost:8080/visits/partial/duration/LTE/{max}
router.get("/partial/duration/LTE/:max", function (req, res) {
    Visit.find({"duration":{ $lte: req.params.max }}, function (err, visits) {
        if(err) {
            console.log(err);
        } else {
            res.setHeader('Content-Type', 'application/json');
            res.end(JSON.stringify(visits));
        }
    })
});

// Postman GET command: localhost:8080/visits/partial/duration/GTE/{min}
router.get("/partial/duration/GTE/:min", function (req, res) {
    Visit.find({"duration":{ $gte: req.params.min }}, function (err, visits) {
        if(err) {
            console.log(err);
        } else {
            res.setHeader('Content-Type', 'application/json');
            res.end(JSON.stringify(visits));
        }
    })
});

// Postman POST command: localhost:8080/visits/add/single
router.post("/add/single", function (req, res) {
   let visitID = req.body.visitID;
   let entryTime = new Date(req.body.entryTime);
   let leaveTime = new Date(req.body.leaveTime);
   let duration = req.body.duration;
   let holiday = req.body.holiday;
   let dayOfWeek = req.body.dayOfWeek;
   let newVisit = {
       visitID: visitID,
       entryTime: entryTime,
       leaveTime: leaveTime,
       duration: duration,
       holiday: holiday,
       dayOfWeek: dayOfWeek};
   console.log(newVisit);
   Visit.create(newVisit, function (err, newCreated) {
       if(err){
           console.log(err);
       } else {
           console.log("successfully add a visit!");
           res.setHeader('Content-Type', 'application/json');
           res.end(JSON.stringify(newCreated));
       }
   });
});

module.exports = router;
