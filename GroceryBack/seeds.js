const Visit = require("./models/visit");

const data = [
    {visitID:"1", entryTime:new Date("2020-07-16T09:10:00Z"), leaveTime:new Date("2020-07-16T09:20:00Z"), duration:10, holiday:"No", dayOfWeek:"Thursday"},
    {visitID:"2", entryTime:new Date("2020-07-17T19:10:00Z"), leaveTime:new Date("2020-07-17T19:30:00Z"), duration:20, holiday:"No", dayOfWeek:"Friday"},
    {visitID:"3", entryTime:new Date("2020-07-18T23:10:00Z"), leaveTime:new Date("2020-07-18T23:40:00Z"), duration:30, holiday:"No", dayOfWeek:"Saturday"}
];

function seedDB() {

    Visit.remove({}, function (err) {
        if(err){
            console.log(err);
        }
        console.log("successfully refresh the database!");
        data.forEach(function (seed) {
            Visit.create(seed, function (err, visit) {
                if(err){
                    console.log(err)
                } else {
                    console.log(visit);
                }
            })
        });
    });

}

module.exports = seedDB;
