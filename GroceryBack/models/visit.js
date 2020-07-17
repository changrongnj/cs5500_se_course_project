var mongoose = require("mongoose");

var visitSchema = new mongoose.Schema({
    visitID:String,
    entryTime:Date,
    leaveTime:Date,
    duration:Number,
    holiday:String,
    dayOfWeek:String
});

module.exports = mongoose.model("Visit", visitSchema);
