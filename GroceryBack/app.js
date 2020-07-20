const express = require("express");
      app = express();
      mongoose = require("mongoose");
      bodyParser = require("body-parser");
      visitRoute = require("./routes/visits");
      cors = require('cors');
      seedDB = require('./seeds');

mongoose.connect("mongodb://localhost/CS5500", function (err, _) {
    if(err) {
        console.log(err);
    } else {
        console.log("successfully connected to the database!");
    }
});

seedDB();
app.use(bodyParser.json());
app.use(cors({ credentials: true, origin: "http://localhost:3000" }));
app.use("/visits", visitRoute);

app.listen(8080, process.env.IP, function () {
    console.log("The Grocery Server Has Started!")
});
