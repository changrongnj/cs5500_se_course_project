var express = require("express");
    app = express();
    mongoose = require("mongoose");
    bodyParser = require("body-parser");
    visitRoute = require("./routes/visits");

mongoose.connect("mongodb://localhost/CS5500", function (err, db) {
    if(err) {
        console.log(err);
    } else {
        console.log("successfully connected to the database!");
        db.dropDatabase(function (err, result) {
            if(err) {
                console.log(err);
            } else {
                console.log("successfully refresh the database!");
            }
        });
    }
});

app.use(bodyParser.json());
app.use("/visits", visitRoute);

app.listen(8080, process.env.IP, function () {
    console.log("The Grocery Server Has Started!")
});
