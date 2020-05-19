const router = require('express').Router();
const con = require('./apiHelper');

router.get("/lesson", function(req, res) {
    console.log("Get lesson");

    con.query(`SELECT * FROM lessons
                WHERE id_course = '${req.query.id_course}'`, function(err, innerRes){
        if(err) {
            throw err;
        }
        res.send(innerRes);
    });
});

module.exports = router;